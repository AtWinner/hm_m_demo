package com.hemaapp.demo.activity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.hm_m_demo.R;
import com.example.hm_m_demo.R.layout;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

public class SpinnerActivity extends MyActivity {
	private String [] items = {"Item1", "Item2"};
	private Spinner spinner1, spinner2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_spinner);
		super.onCreate(savedInstanceState);
		ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
		for(String item : items)
		{
			adapter.add(item);
		}
		spinner1.setAdapter(adapter);
		spinner2.setAdapter(adapter);
		
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
		spinner1 = (Spinner)findViewById(R.id.spinner1);
		spinner2 = (Spinner)findViewById(R.id.spinner2);
		
	}

	@Override
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		// TODO Auto-generated method stub
		
	}

}
