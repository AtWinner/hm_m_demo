package com.hemaapp.demo.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.MyAdapter;
import com.hemaapp.demo.model.EditList;

public class EditListAdapter extends MyAdapter{

	private List<EditList> listData;
	private boolean IsEdit = false;
	public EditListAdapter(Context mContext, ListView listView, List<EditList> listData) {
		super(mContext);
		this.listData = listData;
	}

	@Override
	public int getCount() {
		int count = listData == null ? 0 : listData.size();
		return count;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null)
		{
			convertView = LayoutInflater.from(mContext).inflate(R.layout.listitem_editlist, null);
		}
		ViewHolder holder = new ViewHolder();
		holder.imageSelector = (ImageView)convertView.findViewById(R.id.imageSelector);
		int Visibility = IsEdit ? View.VISIBLE : View.GONE;
		holder.imageSelector.setVisibility(Visibility);
		int imageRes = listData.get(position).isSelect() ? R.drawable.circle_checked : R.drawable.circle_none;
		holder.imageSelector.setImageResource(imageRes);
		
		holder.textView = (TextView)convertView.findViewById(R.id.textView);
		holder.textView.setText(listData.get(position).getContent());
		return convertView;
	}
	
	private class ViewHolder
	{
		public ImageView imageSelector;
		public TextView textView;
	}

	public void SetIsEdit(boolean isEdit)
	{
		IsEdit = isEdit;
	}
	
	
	public boolean GetEdit()
	{
		return IsEdit;
	}

	
	

}
