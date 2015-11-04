package com.hemaapp.demo.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.hm_m_demo.R;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimpleAdapter extends RecyclerView.Adapter<MyViewHolder> {
	private LayoutInflater mInflater;
	private Context mContext;
	private List<String> mDatas;
	public SimpleAdapter(Context context, List<String> datas)
	{
		this.mContext = context;
		this.mDatas = datas;
		mInflater = LayoutInflater.from(context);
	}
	@Override
	public int getItemCount() {
		return mDatas.size();
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		holder.tv.setText(mDatas.get(position));
		addItemClickListener(holder);
	}
	/**
	 * 绑定ItemClick事件，需要在onBindViewHolder中调用
	 * @param holder
	 */
	protected void addItemClickListener(final MyViewHolder holder)
	{
		if (mOnItemClickListener != null) {
			holder.itemView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					mOnItemClickListener.onItemClick(holder.itemView, holder.getPosition());

				}
			});
			
			holder.itemView.setOnLongClickListener(new OnLongClickListener() {
				
				@Override
				public boolean onLongClick(View v) {
					mOnItemClickListener.onItemLongClick(holder.itemView, holder.getPosition());
					return false;
				}
			});
		}
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view = mInflater.inflate(R.layout.recycleritem_single_textview, arg0, false);
		MyViewHolder viewHolder = new MyViewHolder(view);
		
		return viewHolder;
	}
	public void addData(int position)
	{
		mDatas.add(position, "Insert One");
		notifyItemInserted(position);
	}
	
	public void removeData(int position)
	{
		mDatas.remove(position);
		notifyItemRemoved(position);
	}
	
	public interface OnItemClickListener
	{
		void onItemClick(View view, int position);
		void onItemLongClick(View view, int position);
	}
	private OnItemClickListener mOnItemClickListener;
	public void setOnItemClickListener(OnItemClickListener listener)
	{
		this.mOnItemClickListener = listener;
	}
}

class MyViewHolder extends ViewHolder
{
	public TextView tv;
	public MyViewHolder(View itemView) {
		super(itemView);
		tv =(TextView)itemView.findViewById(R.id.tv);
	}
}
