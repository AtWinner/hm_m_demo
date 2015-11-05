package com.hemaapp.demo.activity;

import xtom.frame.view.XtomRefreshLoadmoreLayout;
import xtom.frame.view.XtomRefreshLoadmoreLayout.OnStartListener;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.view.MySwitchLoadLayout;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MultiPagesDownActivity extends MyActivity {
	private MySwitchLoadLayout mySwitchLoadLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_multipage_up);
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
		mySwitchLoadLayout = (MySwitchLoadLayout) findViewById(R.id.mySwitchLoadLayout);
	}

	@Override
	protected void getExras() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setListener() {
		mySwitchLoadLayout.setOnStartListener(new OnStartListener() {

			@Override
			public void onStartRefresh(XtomRefreshLoadmoreLayout v) {
				finish(R.anim.none, R.anim.bottom_out);
			}

			@Override
			public void onStartLoadmore(XtomRefreshLoadmoreLayout v) {

			}
		});
		mySwitchLoadLayout.setLoadmoreable(false);
	}
}
