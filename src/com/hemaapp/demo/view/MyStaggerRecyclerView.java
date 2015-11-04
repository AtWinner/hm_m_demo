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
 * 瀑布流的RecyclerView
 * @author Wen
 * @author HuFanglin
 *
 */
public class MyStaggerRecyclerView extends RecyclerView{

	private SparseArray<SparseArray<XtomImageTask>> tasks = new SparseArray<SparseArray<XtomImageTask>>();
	private XtomImageWorker imageWorker;// 图片下载器
	private OnScrollListener onScrollListener;// 由于设置了自定义滑动监听,如果再设置滑动监听的话只需记录一下,在自定义监听中调用即可
	private MyStaggerRecyclerViewScrollListener mScrollListener;
	private int[] firstPositions;//第一个可见的Item位置
	private int[] lastPositions;//最后一个可见的Item位置
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
	 * 网络任务初始化，滑动监听初始化
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
			case SCROLL_STATE_IDLE: {// 滑动结束时
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
						+ staggeredGridLayoutManager.getSpanCount();// 末位的定位不准确，加一行
				excuteTasks(First, Last);
				if (mScrollListener != null) {
					mScrollListener.onStop(MyStaggerRecyclerView.this);
				}
			}
				break;
			case SCROLL_STATE_DRAGGING: {// 滑动开始，取消未加载完的网络任务
				imageWorker.clearTasks();
				imageWorker.setThreadControlable(true);
				if (mScrollListener != null)
					mScrollListener.onStart(MyStaggerRecyclerView.this);
			}
				break;
			case SCROLL_STATE_SETTLING:
				// 滑动中，不需要什么操作，静静地等待就行
				break;
			}
		}
	}
	/**
	 * 添加网络线程
	 * @param position
	 * @param index
	 * @param task
	 */
	public void addTask(int position, int index, XtomImageTask task) {
		if (!imageWorker.isThreadControlable()) {
			imageWorker.loadImage(task);
		}
		// 需要异步执行的任务，添加进任务队列
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
	 * 加载线程
	 * @param first 开始位置
	 * @param last 结束位置
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
		// 清空不可见条目的任务
		int size = tasks.size();
		for (int index = 0; index < size; index++) {
			int key = tasks.keyAt(index);
			if (key < first || key > last) {
				tasks.remove(key);
			}
		}
	}
	
	/**
	 * 滑动监听
	 */
	public interface MyStaggerRecyclerViewScrollListener {
		/**
		 * 开始滑动
		 * 
		 * @param view
		 */
		public void onStart(MyStaggerRecyclerView view);

		/**
		 * 停止滑动
		 * 
		 * @param view
		 */
		public void onStop(MyStaggerRecyclerView view);
	}
	/**
	 * 设置滑动监听
	 * @param scrollerListener
	 */
	public void setScrollListener(MyStaggerRecyclerViewScrollListener scrollerListener)
	{
		mScrollListener = scrollerListener;
	}
	/**
	 * 获取滑动监听
	 * @return
	 */
	public MyStaggerRecyclerViewScrollListener getScrollListener()
	{
		return mScrollListener;
	}
	
}
