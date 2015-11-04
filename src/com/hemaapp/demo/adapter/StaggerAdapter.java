package com.hemaapp.demo.adapter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import xtom.frame.image.load.XtomImageTask;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.adapter.SimpleAdapter.OnItemClickListener;
import com.hemaapp.demo.model.StaggerModel;
import com.hemaapp.demo.view.MyStaggerRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class StaggerAdapter extends RecyclerView.Adapter<StaggerViewHolder> {
	private LayoutInflater mInflater;
	private Context mContext;
	private List<StaggerModel> mDatas;
//	private List<Integer> mHeights;
	private MyStaggerRecyclerView recylerView;
	public StaggerAdapter(Context context, List<StaggerModel> datas, MyStaggerRecyclerView recylerView)
	{
//		super(context, datas);
		this.mContext = context;
		this.mDatas = datas;
		this.recylerView = recylerView;
		mInflater = LayoutInflater.from(context);
//		mHeights = new ArrayList<Integer>();
//		for(int i = 0; i < mDatas.size(); i++)
//		{
//			mHeights.add(((int)(100 +Math.random() * 300)));
//		}
	}
	@Override
	public int getItemCount() {
		return mDatas.size();
	}

	@Override
	public void onBindViewHolder(StaggerViewHolder holder, int position) {
		StaggerViewHolder viewHolder = holder;
		viewHolder.tv.setText(mDatas.get(position).getName());
		addItemClickListener(viewHolder);
		try {
			URL url = new URL(mDatas.get(position).getUrl());
			XtomImageTask imageTask = new XtomImageTask(viewHolder.imageView, url, mContext);
			recylerView.addTask(position, 0, imageTask);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 绑定ItemClick事件，需要在onBindViewHolder中调用
	 * @param holder
	 */
	protected void addItemClickListener(final StaggerViewHolder holder)
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
	public StaggerViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view = mInflater.inflate(R.layout.recycleritem_single_textview, arg0, false);
		StaggerViewHolder viewHolder = new StaggerViewHolder(view);
		return viewHolder;
	}

	public void addData(int position, StaggerModel object)
	{
		mDatas.add(position, object);
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

class StaggerViewHolder extends ViewHolder
{
	public TextView tv;
	public FrameLayout father;
	public ImageView imageView;
	public StaggerViewHolder(View itemView) {
		super(itemView);
		tv =(TextView)itemView.findViewById(R.id.tv);
		imageView = (ImageView)itemView.findViewById(R.id.imageView);
	}
}