package com.hemaapp.demo.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.activity.CityActivity;
import com.hemaapp.demo.model.DistrictInfor;
import com.hemaapp.demo.view.CityGridView;

import xtom.frame.XtomAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;


public class LocationAdapter extends XtomAdapter {

	private CityActivity mActivity;
	private List<DistrictInfor> list;
	private ArrayList<DistrictInfor> lastCties = new ArrayList<DistrictInfor>();
	private String city;
	private HashMap<String, Integer> alphaIndexer;

	private boolean isShow;

	private static final int ITEM_LOCATION = 0;
	private static final int ITEM_LAST = 1;
	private static final int ITEM_CITY = 2;

	public LocationAdapter(CityActivity mActivity, boolean isShow) {
		super(mActivity);
		this.mActivity = mActivity;
		this.isShow = isShow;
	}

	private DistrictInfor foundcity(String str) {
		for (DistrictInfor info : list) {
			if (info.getName().equals(str)) {
				return info;
			}
		}
		return null;
	}

	public void setList(List<DistrictInfor> list) {
		if (list == null)
			this.list = new ArrayList<DistrictInfor>();
		else {
			this.list = list;
		}

		alphaIndexer = new HashMap<String, Integer>();

		for (int i = 0; i < list.size(); i++) {
			// 当前汉语拼音首字母
			// getAlpha(list.get(i));
			String currentStr = list.get(i).getCharindex();
			// 上一个汉语拼音首字母，如果不存在为“ ”
			String previewStr = (i - 1) >= 0 ? list.get(i - 1).getCharindex()
					: " ";
			if (!previewStr.equals(currentStr)) {
				String name = list.get(i).getCharindex();
				alphaIndexer.put(name, i);
			}
		}
	}

	@Override
	public int getCount() {
		if (isShow)
			return list.size() + 2;
		else
			return list.size();

	}

	@Override
	public Object getItem(int position) {
		if (isShow)
			return list.get(position - 2);
		else
			return list.get(position);
	}

	/**
	 * 当ListView数据发生变化时,调用此方法来更新ListView
	 * 
	 * @param list
	 */
	public void updateListView(List<DistrictInfor> list) {
		this.list = list;
		notifyDataSetChanged();
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getViewTypeCount() {
		if (isShow)
			return 3;
		else
			return 1;
	}

	@Override
	public int getItemViewType(int position) {
		switch (position) {
		case 0:
			if (isShow)
				return ITEM_LOCATION;
		case 1:
			if (isShow)
				return ITEM_LAST;
		default:
			return ITEM_CITY;
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int type = getItemViewType(position);
		if (convertView == null) {
			convertView = getView(type);
		}
		setData(convertView, type, position);
		return convertView;
	}

	private View getView(int type) {
		View view = null;
		switch (type) {
		case ITEM_LOCATION:
			view = LayoutInflater.from(mActivity).inflate(
					R.layout.listitem_location_0, null);
			HolderLocation la = new HolderLocation();
			la.tv = (TextView) view.findViewById(R.id.site);
			view.setTag(la);

			break;
		case ITEM_LAST:
			view = LayoutInflater.from(mActivity).inflate(
					R.layout.listitem_location_1, null);
			HolderLast holder = new HolderLast();
			holder.gvlast = (CityGridView) view.findViewById(R.id.lastgv);
			view.setTag(holder);
			break;
		case ITEM_CITY:
			view = LayoutInflater.from(mActivity).inflate(
					R.layout.listitem_location_3, null);
			HolderCity holderc = new HolderCity();
			holderc.alpha = (TextView) view.findViewById(R.id.alpha);
			holderc.name = (TextView) view.findViewById(R.id.name);
			view.setTag(holderc);
			break;
		}
		return view;
	}

	private void setData(View view, int type, int position) {
		switch (type) {
		case ITEM_LOCATION:
			HolderLocation location = (HolderLocation) view.getTag();
			if (isNull(city)) {
				location.tv.setText("定位中");
			} else {
				location.tv.setText(city);
				location.tv.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						DistrictInfor info = foundcity(city);
						returnFound(info);
					}
				});
			}
			break;
		case ITEM_LAST:
			HolderLast last = (HolderLast) view.getTag();
			CityAdapter adapter = new CityAdapter(mActivity, lastCties);
			last.gvlast.setAdapter(adapter);
			last.gvlast.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					int p = lastCties.size() - position - 1;
					DistrictInfor citysel = lastCties.get(p);
					returnFound(citysel);
				}
			});
			break;
		case ITEM_CITY:
			HolderCity city = (HolderCity) view.getTag();
			int size = isShow ? 2 : 0;
			city.name.setText(list.get(position - size).getName());
			// city.name.setTag(list.get(position-size));
			String currentStr = list.get(position - size).getCharindex();
			String previewStr = (position - 1 - size) >= 0 ? list.get(
					position - 1 - size).getCharindex() : " ";
			if (!previewStr.equals(currentStr)) {
				city.alpha.setVisibility(View.VISIBLE);
				city.alpha.setText(currentStr);
			} else {
				city.alpha.setVisibility(View.GONE);
			}
			view.setTag(R.id.TAG, list.get(position - size));
			break;
		default:
			break;
		}

	}

	private void returnFound(DistrictInfor citysel) {
		mActivity.itemclick(citysel);
	}

	class HolderLast {
		CityGridView gvlast;
	}

	class HolderLocation {
		TextView tv;
	}

	class HolderCity {
		TextView alpha;
		TextView name;
	}

	public HashMap<String, Integer> getAlphaIndexer() {
		return alphaIndexer;
	}

	public void setAlphaIndexer(HashMap<String, Integer> alphaIndexer) {
		this.alphaIndexer = alphaIndexer;
	}

	public void setLastCties(ArrayList<DistrictInfor> lastCties) {
		if (lastCties != null)
			this.lastCties = lastCties;
	}

	public void setLocCity(String city) {
		this.city = city;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}

	public boolean isShow() {
		return isShow;
	}

}
