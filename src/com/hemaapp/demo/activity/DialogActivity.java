package com.hemaapp.demo.activity;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.dialog.MyTwoVertivalButtonDialog;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DialogActivity extends MyActivity implements OnClickListener{
	private Button btnTwoVertical;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_dialog);
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
		btnTwoVertical = (Button)findViewById(R.id.btnTwoVertical);
		
	}

	@Override
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		btnTwoVertical.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnTwoVertical:
			MyTwoVertivalButtonDialog dialog = new MyTwoVertivalButtonDialog(mContext);
			dialog.show();
			break;

		default:
			break;
		}
		
	}

}
