package com.hemaapp.demo.activity;

import xtom.frame.view.XtomRefreshLoadmoreLayout;
import xtom.frame.view.XtomRefreshLoadmoreLayout.OnStartListener;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.view.MySwitchLoadLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MultiPagesUpActivity extends Activity
{
	private MySwitchLoadLayout mySwitchLoadLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_multipage_up);
		super.onCreate(savedInstanceState);
		mySwitchLoadLayout = (MySwitchLoadLayout)findViewById(R.id.mySwitchLoadLayout);
		setListener();
		mySwitchLoadLayout.setRefreshable(false);
		
	}
	private void setListener()
	{
		mySwitchLoadLayout.setOnStartListener(new OnStartListener() {
			
			@Override
			public void onStartRefresh(XtomRefreshLoadmoreLayout v) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartLoadmore(XtomRefreshLoadmoreLayout v) {
				Intent intent = new Intent(MultiPagesUpActivity.this, MultiPagesDownActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.bottom_in, R.anim.none);
				mySwitchLoadLayout.loadmoreSuccess();
			}
		});
	}
}
