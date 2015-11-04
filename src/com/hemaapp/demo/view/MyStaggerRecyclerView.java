package com.hemaapp.demo.view;

import xtom.frame.image.load.XtomImageTask;
import xtom.frame.image.load.XtomImageWorker;
import xtom.frame.view.XtomListView;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.util.SparseArray;
/**
 * �ٲ�����RecyclerView
 * @author Wen
 * @author HuFanglin
 *
 */
public class MyStaggerRecyclerView extends RecyclerView{

	private SparseArray<SparseArray<XtomImageTask>> tasks = new SparseArray<SparseArray<XtomImageTask>>();
	private XtomImageWorker imageWorker;// ͼƬ������
	private OnScrollListener onScrollListener;// �����������Զ��廬������,��������û��������Ļ�ֻ���¼һ��,���Զ�������е��ü���
	private MyStaggerRecyclerViewScrollListener mScrollListener;
	private int[] firstPositions;//��һ���ɼ���Itemλ��
	private int[] lastPositions;//���һ���ɼ���Itemλ��
	private int First;
	private int Last;
	public MyStaggerRecyclerView(Context context) {
		this(context, null);
	}

	public MyStaggerRecyclerView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public MyStaggerRecyclerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}
	/**
	 * ���������ʼ��������������ʼ��
	 * @param context
	 */
	private void init(Context context)
	{
		if (isInEditMode()) {
			return;
		}
		imageWorker = new XtomImageWorker(context.getApplicationContext());
		setOnScrollListener(new ScrollListener());
	}
	
	@Override
	public void setOnScrollListener(OnScrollListener listener) {
		if (listener instanceof ScrollListener) {
			onScrollListener = null;
			super.setOnScrollListener(listener);
		} else {
			onScrollListener = listener;
		}
		super.setOnScrollListener(listener);
	}
	
	private class ScrollListener extends OnScrollListener
	{
		@Override
		public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
			super.onScrollStateChanged(recyclerView, newState);
			if (onScrollListener != null)
			{
				onScrollListener.onScrollStateChanged(recyclerView, newState);
			}
			switch (newState) {
			case SCROLL_STATE_IDLE: {// ��������ʱ
				StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) getLayoutManager();
				if (firstPositions == null)
					firstPositions = new int[staggeredGridLayoutManager
							.getSpanCount()];
				if (lastPositions == null)
					lastPositions = new int[staggeredGridLayoutManager
							.getSpanCount()];
				int[] first = ((StaggeredGridLayoutManager) getLayoutManager())
						.findFirstVisibleItemPositions(firstPositions);
				int[] last = ((StaggeredGridLayoutManager) getLayoutManager())
						.findLastVisibleItemPositions(lastPositions);
				First = first[0];
				Last = last[last.length - 1]
						+ staggeredGridLayoutManager.getSpanCount();// ĩλ�Ķ�λ��׼ȷ����һ��
				excuteTasks(First, Last);
				if (mScrollListener != null) {
					mScrollListener.onStop(MyStaggerRecyclerView.this);
				}
			}
				break;
			case SCROLL_STATE_DRAGGING: {// ������ʼ��ȡ��δ���������������
				imageWorker.clearTasks();
				imageWorker.setThreadControlable(true);
				if (mScrollListener != null)
					mScrollListener.onStart(MyStaggerRecyclerView.this);
			}
				break;
			case SCROLL_STATE_SETTLING:
				// �����У�����Ҫʲô�����������صȴ�����
				break;
			}
		}
	}
	/**
	 * ��������߳�
	 * @param position
	 * @param index
	 * @param task
	 */
	public void addTask(int position, int index, XtomImageTask task) {
		if (!imageWorker.isThreadControlable()) {
			imageWorker.loadImage(task);
		}
		// ��Ҫ�첽ִ�е�������ӽ��������
		SparseArray<XtomImageTask> tasksInPosition = tasks.get(position);
		if (imageWorker.loadImage(task)) {
			if (tasksInPosition == null) {
				tasksInPosition = new SparseArray<XtomImageTask>();
				tasks.put(position, tasksInPosition);
			}
			tasksInPosition.put(index, task);
		} else {
			if (tasksInPosition != null)
				tasksInPosition.remove(index);
		}
	}
	
	/**
	 * �����߳�
	 * @param first ��ʼλ��
	 * @param last ����λ��
	 */
	private void excuteTasks(int first, int last)
	{
		for (int i = first; i <= last; i++) {
			SparseArray<XtomImageTask> tasksInPosition = tasks.get(i);
			if (tasksInPosition != null) {
				int size = tasksInPosition.size();
				for (int index = 0; index < size; index++) {
					int key = tasksInPosition.keyAt(index);
					XtomImageTask task = tasksInPosition.get(key);
					imageWorker.loadImageByThread(task);
				}
			}
		}
		// ��ղ��ɼ���Ŀ������
		int size = tasks.size();
		for (int index = 0; index < size; index++) {
			int key = tasks.keyAt(index);
			if (key < first || key > last) {
				tasks.remove(key);
			}
		}
	}
	
	/**
	 * ��������
	 */
	public interface MyStaggerRecyclerViewScrollListener {
		/**
		 * ��ʼ����
		 * 
		 * @param view
		 */
		public void onStart(MyStaggerRecyclerView view);

		/**
		 * ֹͣ����
		 * 
		 * @param view
		 */
		public void onStop(MyStaggerRecyclerView view);
	}
	/**
	 * ���û�������
	 * @param scrollerListener
	 */
	public void setScrollListener(MyStaggerRecyclerViewScrollListener scrollerListener)
	{
		mScrollListener = scrollerListener;
	}
	/**
	 * ��ȡ��������
	 * @return
	 */
	public MyStaggerRecyclerViewScrollListener getScrollListener()
	{
		return mScrollListener;
	}
	
}
