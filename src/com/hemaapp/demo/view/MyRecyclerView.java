package com.hemaapp.demo.view;

import xtom.frame.image.load.XtomImageTask;
import xtom.frame.image.load.XtomImageWorker;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.SparseArray;

public class MyRecyclerView extends RecyclerView {
	
	private SparseArray<SparseArray<XtomImageTask>> tasks = new SparseArray<SparseArray<XtomImageTask>>();
	private XtomImageWorker imageWorker;// 图片下载器
	private OnScrollListener onScrollListener;// 由于设置了自定义滑动监听,如果再设置滑动监听的话只需记录一下,在自定义监听中调用即可
	
	public MyRecyclerView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public MyRecyclerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	public MyRecyclerView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	private void init(Context context) {
		if (isInEditMode()) {
			return;
		}
		imageWorker = new XtomImageWorker(context.getApplicationContext());
//		setOnScrollListener(new ScrollListener());
//		setOnScrollListener(onScrollListener);
	}
	@Override
	protected void onMeasure(int widthSpec, int heightSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthSpec, heightSpec);
	}
}
