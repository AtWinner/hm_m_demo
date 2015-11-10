package com.hemaapp.demo.activity;

import android.os.Bundle;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.view.AnimCheckBox;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

public class AnimCheckBoxActivity extends MyActivity {
	private AnimCheckBox checkBox1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_animcheckbox);
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
		checkBox1 = (AnimCheckBox)findViewById(R.id.checkBox1);
		checkBox1.setChecked(false);
//		checkBox1.set
	}

	@Override
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean onKeyBack() {
		finish(R.anim.abc_fade_in, R.anim.abc_fade_out);
		return super.onKeyBack();
	}
}
