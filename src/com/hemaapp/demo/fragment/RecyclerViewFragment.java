package com.hemaapp.demo.fragment;

import java.util.Random;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyFragment;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

public class RecyclerViewFragment extends MyFragment{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.fragment_recyclerview);
		super.onCreate(savedInstanceState);
		Random random = new Random();
		int color =Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
		findViewById(R.id.father).setBackgroundColor(color);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		// TODO Auto-generated method stub
		
	}

}
