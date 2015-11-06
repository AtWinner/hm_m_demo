package com.hemaapp.demo.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.MyAdapter;
import com.hemaapp.demo.VerticalViewPager.PagerAdapter;
import com.hemaapp.demo.VerticalViewPager.VerticalViewPager;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class VerticalViewPagerActivity extends MyActivity {
	private VerticalViewPager verticalViewPager;
	private Random mRandom = new Random();
//	private List<ItemModel> listData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_verticalviewpager);
		super.onCreate(savedInstanceState);
		
	}

	@Override
	protected void callBeforeDataBack(HemaNetTask netTask) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void callAfterDataBack(HemaNetTask netTask) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void callBackForServerSuccess(HemaNetTask netTask,
			HemaBaseResult baseResult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void callBackForServerFailed(HemaNetTask netTask,
			HemaBaseResult baseResult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void callBackForGetDataFailed(HemaNetTask netTask, int failedType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void findView() {
		verticalViewPager = (VerticalViewPager) findViewById(R.id.verticalViewPager);
		verticalViewPager.setAdapter(adapter);
		
	}

	@Override
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		// TODO Auto-generated method stub
		
	}
	
	
	private PagerAdapter adapter = new PagerAdapter() {
		
		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view == object;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			Log.d("", "instantiateItem:" + position);
			View convertView = LayoutInflater.from(VerticalViewPagerActivity.this).inflate(R.layout.layout_doublepage, null);
			TextView textView = (TextView)convertView.findViewById(R.id.textView);
			textView.setText("Page" + (position + 1));
//			ListView listView = (ListView)convertView.findViewById(R.id.listView);
//			listData = new ArrayList<VerticalViewPagerActivity.ItemModel>();
//			listData.add(new ItemModel("去个人中心", UserCenterActivity.class));
//			listData.add(new ItemModel("MyRecyclerView", RecyclerViewActivity.class));
//			listData.add(new ItemModel("Canvas", CanvasActivity.class));
//			listData.add(new ItemModel("ColorEditor", ColorEditorActivity.class));
//			listData.add(new ItemModel("可编辑的列表", EditListViewActivity.class));
//			listData.add(new ItemModel("Vertical_ViewPager", VerticalViewPagerActivity.class));
//			listData.add(new ItemModel("ViewPager_With_Underline", UnderlineDemoActivity.class));
//			listData.add(new ItemModel("Dialog", DialogActivity.class));
//			listData.add(new ItemModel("城市", CityActivity.class));
//			listData.add(new ItemModel("HeadListview", HeadListviewActivity.class));
//			listData.add(new ItemModel("SweetDialog", SweetDialogActivity.class));
//			listData.add(new ItemModel("RecyclerView", RecyclerViewActivityNew.class));
//			listData.add(new ItemModel("伪瀑布流", RecyclerViewActivityStagger.class));
//			listData.add(new ItemModel("测试ActionBar", MActionBarActivity.class));
//			listData.add(new ItemModel("上下关系两个布局", MultiPagesUpActivity.class));
//			listData.add(new ItemModel("FragmentManager", FragmentManagerActivity.class));
//			listData.add(new ItemModel("蓝牙", BlueToothActivity.class));
//			listView.setAdapter(new MainAdapter(mContext));
			
			LinearLayout linearLayout = (LinearLayout)convertView.findViewById(R.id.linearLayout);
			for(int i = 0; i < 20; i++)
			{
				TextView tv = new TextView(VerticalViewPagerActivity.this);
				tv.setLayoutParams(new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.WRAP_CONTENT));
				tv.setGravity(Gravity.CENTER);
				tv.setTextSize(30);
				tv.setTextColor(Color.BLACK);
				tv.setText("HEHE" + position);
				tv.setId((position+1) * 10 + i);
				linearLayout.addView(tv);
			}
			
			container.addView(convertView);

			return convertView;
		} 
		
		@Override
		public void destroyItem(ViewGroup container, int position,
				Object object) {
			// TODO Auto-generated method stub
			super.destroyItem(container, position, object);
			container.removeView((View) object);
		}
	}; 
	
	
//	private class MainAdapter extends MyAdapter
//	{
//		public MainAdapter(Context mContext) {
//			super(mContext);
//			// TODO Auto-generated constructor stub
//		}
//
//		@Override
//		public int getCount() {
//			int count = listData == null ? 0 : listData.size();
//			return count;
//		}
//
//		@Override
//		public Object getItem(int position) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public long getItemId(int position) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//
//		@Override
//		public View getView(int position, View convertView, ViewGroup parent) {
//			if(convertView == null)
//			{
//				convertView =  LayoutInflater.from(mContext).inflate(R.layout.listitem_main, null);
//			}
//			TextView txtMain = (TextView)convertView.findViewById(R.id.txtMain);
//			txtMain.setText(listData.get(position).Text);
//			return convertView;
//		}
//	}
//	private class ItemModel 
//	{
//		public String Text;
//		public Class<?> nextActivity;
//		public ItemModel (String Text, Class<?> nextActivity)
//		{
//			this.nextActivity = nextActivity;
//			this.Text = Text;
//		}
//	}
}
