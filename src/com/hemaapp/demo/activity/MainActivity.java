package com.hemaapp.demo.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cn.pedant.SweetAlert.SweetAlertDialog;
import cn.pedant.SweetAlert.SweetAlertDialog.OnSweetClickListener;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.MyAdapter;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends MyActivity implements OnItemClickListener
{

	private ListView mainListView;
	private View viewColor;
	private RelativeLayout.LayoutParams params;
	private List<ItemModel> listData;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
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
		findViewById(R.id.imageQuitActivity).setVisibility(View.INVISIBLE);
		findViewById(R.id.txtNext).setVisibility(View.INVISIBLE);
		((TextView)findViewById(R.id.txtTitle)).setText("MainList");

		Typeface fontFace = Typeface.createFromAsset(getAssets(),
                "FZKT_GBK.TTF");
		((TextView)findViewById(R.id.txtTitle)).setTypeface(fontFace);
		mainListView =(ListView)findViewById(R.id.mainListView); 
		listData = new ArrayList<MainActivity.ItemModel>();
		listData.add(new ItemModel("去个人中心", UserCenterActivity.class));
		listData.add(new ItemModel("MyRecyclerView", RecyclerViewActivity.class));
		listData.add(new ItemModel("Canvas", CanvasActivity.class));
		listData.add(new ItemModel("ColorEditor", ColorEditorActivity.class));
		listData.add(new ItemModel("可编辑的列表", EditListViewActivity.class));
		listData.add(new ItemModel("Vertical_ViewPager", VerticalViewPagerActivity.class));
		listData.add(new ItemModel("ViewPager_With_Underline", UnderlineDemoActivity.class));
		listData.add(new ItemModel("Dialog", DialogActivity.class));
		listData.add(new ItemModel("城市", CityActivity.class));
		listData.add(new ItemModel("HeadListview", HeadListviewActivity.class));
		listData.add(new ItemModel("SweetDialog", SweetDialogActivity.class));
		listData.add(new ItemModel("RecyclerView", RecyclerViewActivityNew.class));
		listData.add(new ItemModel("伪瀑布流", RecyclerViewActivityStagger.class));
		listData.add(new ItemModel("测试ActionBar", MActionBarActivity.class));
		listData.add(new ItemModel("上下关系两个布局", MultiPagesUpActivity.class));
		listData.add(new ItemModel("FragmentManager", FragmentManagerActivity.class));
		listData.add(new ItemModel("蓝牙", BlueToothActivity.class));
		listData.add(new ItemModel("Spinner", SpinnerActivity.class));
		listData.add(new ItemModel("SlidingMenu Custom", PropertiesActivity.class));
		listData.add(new ItemModel("SlidingTab", SlidingTabActivity.class));
		listData.add(new ItemModel("CheckBox", AnimCheckBoxActivity.class));
		listData.add(new ItemModel("CardViewActivity", CardViewActivity.class));
		
		
		
		mainListView.setAdapter(new MainAdapter(mContext));
		
	}

	@Override
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		mainListView.setOnItemClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(this, listData.get(position).nextActivity);
		if(intent != null)
		{
			startActivity(intent);
			overridePendingTransition(R.anim.activity_fade_in, R.anim.activity_fade_out);
		}
		
	}
	private class ItemModel 
	{
		public String Text;
		public Class<?> nextActivity;
		public ItemModel (String Text, Class<?> nextActivity)
		{
			this.nextActivity = nextActivity;
			this.Text = Text;
		}
	}
	
	private class MainAdapter extends MyAdapter
	{
		public MainAdapter(Context mContext) {
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

	@Override
	protected boolean onKeyBack() {
		new SweetAlertDialog(mContext, SweetAlertDialog.WARNING_TYPE)
				.setTitleText("确定要退出吗？").setConfirmText("好的")
				.setConfirmClickListener(new OnSweetClickListener() {

					@Override
					public void onClick(SweetAlertDialog sweetAlertDialog) {

						new SweetAlertDialog(mContext, SweetAlertDialog.SUCCESS_TYPE)
								.setTitleText("退出啦？")
								.setConfirmText("好的")
								.setConfirmClickListener(new OnSweetClickListener() {
									
									@Override
									public void onClick(SweetAlertDialog sweetAlertDialog) {
										finish();
									}
								})
								.show();
						
					}
				}).show();
		return false;
	}
	
	
}
