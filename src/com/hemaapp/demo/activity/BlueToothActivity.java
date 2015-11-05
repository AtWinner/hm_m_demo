package com.hemaapp.demo.activity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

public class BlueToothActivity extends MyActivity
{
    private final int REQUEST_ENABLE_BT = 1;
	private BluetoothAdapter mBluetoothAdapter;
	private BluetoothSocket mBluetoothSocket;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_bluetooth);
		super.onCreate(savedInstanceState);
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (!mBluetoothAdapter.isEnabled()) {
			Intent enableBtIntent = new Intent(
					BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
		}
	}
	
	@Override
	protected void onDestroy() {
		mBluetoothAdapter.disable();
		super.onDestroy();
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
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		// TODO Auto-generated method stub
		
	}

}
