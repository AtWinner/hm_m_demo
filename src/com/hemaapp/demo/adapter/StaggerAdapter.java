package com.hemaapp.demo.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.hm_m_demo.R;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class StaggerAdapter extends SimpleAdapter {
	private LayoutInflater mInflater;
	private Context mContext;
	private List<String> mDatas;
	private List<Integer> mHeights;
	public StaggerAdapter(Context context, List<String> datas)
	{
		super(context, datas);
		this.mContext = context;
		this.mDatas = datas;
		mInflater = LayoutInflater.from(context);
		mHeights = new ArrayList<Integer>();
		for(int i = 0; i < mDatas.size(); i++)
		{
			mHeights.add(((int)(100 +Math.random() * 300)));
		}
	}
	@Override
	public int getItemCount() {
		return mDatas.size();
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)holder.tv.getLayoutParams();
		params.height = mHeights.get(position);
		holder.tv.setLayoutParams(params);
		holder.tv.setText(mDatas.get(position));
		addItemClickListener(holder);
		
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view = mInflater.inflate(R.layout.recycleritem_single_textview, arg0, false);
		MyViewHolder viewHolder = new MyViewHolder(view);
		
		return viewHolder;
	}

}