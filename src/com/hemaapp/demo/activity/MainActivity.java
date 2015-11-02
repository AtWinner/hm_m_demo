package com.hemaapp.demo.activity;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends MyActivity implements OnClickListener
{

	private Button btnUserCenter, btnCircleIndicator, btnMyRecyclerView, btnCanvas, btnColorEditor,
		btnEditListView, btnImageActivity, btnVerticalViewPager, btnUnderlineDemoActivity, btnDialog, 
		btnAsyncTask, btnCity, btnHeadListview;
	private View viewColor;
	private RelativeLayout.LayoutParams params;
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
		btnUserCenter = (Button)findViewById(R.id.btnUserCenter);
		btnCircleIndicator = (Button)findViewById(R.id.btnCircleIndicator);
		btnMyRecyclerView = (Button)findViewById(R.id.btnMyRecyclerView);
		btnCanvas = (Button)findViewById(R.id.btnCanvas);
		btnColorEditor = (Button)findViewById(R.id.btnColorEditor);
		btnEditListView = (Button)findViewById(R.id.btnEditListView);
		btnImageActivity = (Button)findViewById(R.id.btnImageActivity);
		btnVerticalViewPager = (Button)findViewById(R.id.btnVerticalViewPager);
		btnUnderlineDemoActivity = (Button)findViewById(R.id.btnUnderlineDemoActivity);
		btnDialog = (Button)findViewById(R.id.btnDialog);
		btnAsyncTask = (Button)findViewById(R.id.btnAsyncTask);
		viewColor = findViewById(R.id.viewColor);
		params = (RelativeLayout.LayoutParams)viewColor.getLayoutParams();
		btnCity = (Button)findViewById(R.id.btnCity);
		btnHeadListview = (Button)findViewById(R.id.btnHeadListview);
	}

	@Override
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		btnUserCenter.setOnClickListener(this);
		btnCircleIndicator.setOnClickListener(this);
		btnMyRecyclerView.setOnClickListener(this);
		btnCanvas.setOnClickListener(this);
		btnColorEditor.setOnClickListener(this);
		btnEditListView.setOnClickListener(this);
		btnImageActivity.setOnClickListener(this);
		btnVerticalViewPager.setOnClickListener(this);
		btnUnderlineDemoActivity.setOnClickListener(this);
		btnDialog.setOnClickListener(this);
		btnAsyncTask.setOnClickListener(this);
		btnCity.setOnClickListener(this);
		btnHeadListview.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.btnUserCenter:
			intent.setClass(this, UserCenterActivity.class);
			break;
		case R.id.btnMyRecyclerView:
			intent.setClass(this, RecyclerViewActivity.class);
			break;
		case R.id.btnCanvas:
			intent.setClass(this, CanvasActivity.class);
			break;
		case R.id.btnColorEditor:
			intent.setClass(this, ColorEditorActivity.class);
			break;
		case R.id.btnEditListView:
			intent.setClass(this, EditListViewActivity.class);
			break;
		case R.id.btnImageActivity:
			intent.setClass(mContext, AlbumActivity.class);
			intent.putExtra("limitCount", 8);// 图片选择张数限制
			startActivityForResult(intent, 1);
			break;
		case R.id.btnVerticalViewPager:
			intent.setClass(this, VerticalViewPagerActivity.class);
			break;
		case R.id.btnUnderlineDemoActivity:
			intent.setClass(this, UnderlineDemoActivity.class);
			break;
		case R.id.btnDialog:
			intent.setClass(this, DialogActivity.class);
			break;
		case R.id.btnAsyncTask:
			testAsyncTask();
			intent = null;
			break;
		case R.id.btnCity:
			intent.setClass(this, CityActivity.class);
			break;
		case R.id.btnHeadListview:
			intent.setClass(this, HeadListviewActivity.class);
			break;
		default:
			intent = null;
			break;
		}
		if(intent != null)
		{
			startActivity(intent);
			overridePendingTransition(R.anim.right_in, R.anim.none);
		}
	}
	
	private void testAsyncTask()
	{
		if(IsOpen)
		{
			(new LabelScrollTask()).execute(-15);
			IsOpen = false;
		}
		else
		{
			(new LabelScrollTask()).execute(15);
			IsOpen = true;
		}
	}
	private Boolean IsOpen = false;//记录Label是否打开
	private int Height = 0;
	private int MaxHeight = 200;//记录Label展示是实际高度
	
	private class LabelScrollTask extends AsyncTask<Integer, Integer, Integer>
	{

		@Override
		protected Integer doInBackground(Integer... speed) {
			int  myLabelHeight =IsOpen ? Height : MaxHeight;
			while(true)
			{
				myLabelHeight = myLabelHeight + speed[0];
				if (myLabelHeight < Height) 
				{
					myLabelHeight = Height;
					break;
				}
				if (myLabelHeight > MaxHeight) 
				{
					myLabelHeight = MaxHeight;
					break;
				}
				publishProgress(myLabelHeight);
				// 为了要有滚动效果产生，每次循环使线程睡眠2毫秒，这样肉眼才能够看到滚动动画。
				sleep(1);
			}
			return myLabelHeight;
		}
		@Override
		protected void onProgressUpdate(Integer... height) {
			params.height = height[0];
			viewColor.setLayoutParams(params);
			super.onProgressUpdate(height);
		}
		
		@Override
		protected void onPostExecute(Integer height) {
			params.height = height;
			viewColor.setLayoutParams(params);
			super.onPostExecute(height);
		}
	}

	/**
	 * 使当前线程睡眠指定的毫秒数。
	 * 
	 * @param millis
	 *            指定当前线程睡眠多久，以毫秒为单位
	 */
	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
