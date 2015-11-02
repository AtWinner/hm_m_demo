package com.hemaapp.demo.adapter;

import java.util.ArrayList;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.model.DistrictInfor;

import xtom.frame.XtomAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CityAdapter extends XtomAdapter {

	private Context mActivity;
	private ArrayList<DistrictInfor> cities;

	public CityAdapter(Context mActivity, ArrayList<DistrictInfor> cities) {
		super(mActivity);
		this.mActivity = mActivity;
		if (cities == null)
			this.cities = new ArrayList<DistrictInfor>();
		else
			this.cities = cities;
	}

	@Override
	public int getCount() {
		int size = cities.size();
		if (size > 6)
			size = 6;
		return size;
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

		ViewHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mActivity).inflate(
					R.layout.listitem_city, null);
			holder = new ViewHolder();
			holder.tv = (TextView) convertView.findViewById(R.id.tv);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		int p = cities.size() - position - 1;
		holder.tv.setText(cities.get(p).getName());
		log_w("= cityAdapter  getName()=" + cities.get(position).getName());
		return convertView;
	}

	class ViewHolder {
		TextView tv;
	}
}
