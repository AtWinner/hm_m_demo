package com.hemaapp.demo.adapter;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by baoyz on 2014/6/29.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    // 数据集
    private String[] mDataset;
    private RecyclerView recyclerView;
    private int Location;
    private ViewPager viewPager;

    public MyAdapter(String[] dataset, RecyclerView recyclerView, ViewPager viewPager) {
        super();
        mDataset = dataset;
        this.recyclerView = recyclerView;
        this.viewPager = viewPager;
        Location = 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // 创建一个View，简单起见直接使用系统提供的布局，就是一个TextView
        View view = View.inflate(viewGroup.getContext(), android.R.layout.simple_list_item_1, null);
        // 创建一个ViewHolder
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        // 绑定数据到ViewHolder上
        viewHolder.mTextView.setText(mDataset[i]);
        int colors = i == Location ? Color.BLUE: Color.BLACK;
        viewHolder.mTextView.setTextColor(colors);
        final int location = i;
        viewHolder.mTextView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				 Location = location;
				 viewPager.setCurrentItem(location);
				 notifyDataSetChanged();
			}
		});
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView;
        }
    }
    
    public void changeSelectPage(int location)
    {
    	Location = location;
    	notifyDataSetChanged();
    }
    
    
}
