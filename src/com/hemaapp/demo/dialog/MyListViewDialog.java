package com.hemaapp.demo.dialog;

import java.util.ArrayList;
import java.util.List;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyAdapter;
import com.hemaapp.demo.MyUtil;
import com.hemaapp.demo.activity.MainActivity;
import com.hemaapp.demo.model.DialogItemModel;

import xtom.frame.XtomObject;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;


public class MyListViewDialog extends XtomObject  {
	private Dialog mDialog;
	private ViewGroup mContent;
	private ListView dialogListView;
	private List<DialogItemModel> listData;

	public MyListViewDialog(Context context, List<DialogItemModel> listData) {
		mDialog = new Dialog(context, R.style.dialog);
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.dialog_with_listview, null);
		mContent = (ViewGroup) view.findViewById(R.id.content);
		dialogListView = (ListView)view.findViewById(R.id.dialogListView);
		this.listData = listData;
		dialogListView.setAdapter(new DialogAdapter(context));
		FrameLayout.LayoutParams params = (FrameLayout.LayoutParams)dialogListView.getLayoutParams();
		params.height = MyUtil.getScreenHeight(context) * 2 / 3;
		params.width = MyUtil.getScreenWidth(context) * 2 / 3;
		dialogListView.setLayoutParams(params);
		mDialog.setCancelable(true);
		mDialog.setContentView(view);
	}

	/**
	 * 给弹框添加自定义View
	 * 
	 * @param v
	 *            自定义View
	 */
	public void setView(View v) {
		mContent.removeAllViews();
		mContent.addView(v);
	}

	public void show() {
		mDialog.show();
	}

	public void cancel() {
		mDialog.cancel();
	}

	public void setOnItemClickListener(OnItemClickListener mOnItemClickListener)
	{
		dialogListView.setOnItemClickListener(mOnItemClickListener);
	}
	
	
	private class DialogAdapter extends MyAdapter
	{
		public DialogAdapter(Context mContext) {
			super(mContext);
			// TODO Auto-generated constructor stub
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
				convertView =  LayoutInflater.from(mContext).inflate(R.layout.listitem_main, null);
			}
			TextView txtMain = (TextView)convertView.findViewById(R.id.txtMain);
			txtMain.setText(listData.get(position).Text);
			return convertView;
		}
		
	}
}
