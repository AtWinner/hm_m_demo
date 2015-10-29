package com.hemaapp.demo.activity;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends MyActivity implements OnClickListener
{

	private Button btnUserCenter, btnCircleIndicator, btnMyRecyclerView, btnCanvas, btnColorEditor,
		btnEditListView, btnImageActivity;
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
		case R.id.btnCircleIndicator:
			intent.setClass(this, CircleIndicatorActivity.class);
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
}
