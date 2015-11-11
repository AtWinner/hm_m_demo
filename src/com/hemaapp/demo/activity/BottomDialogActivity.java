package com.hemaapp.demo.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.dialog.MyBottomButtonDialog;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

public class BottomDialogActivity extends MyActivity implements OnClickListener
{
	
	private Button btnMyBottomButtonDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_bottomdialog);
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
		btnMyBottomButtonDialog = (Button)findViewById(R.id.btnMyBottomButtonDialog);
		
	}

	@Override
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		btnMyBottomButtonDialog.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnMyBottomButtonDialog:
			MyBottomButtonDialog mMyBottomButtonDialog = new MyBottomButtonDialog(mContext);
			mMyBottomButtonDialog.setButtonListener(new MyBottomButtonDialog.OnButtonListener() {
				
				@Override
				public void onTopButtonClick(MyBottomButtonDialog dialog) {
					showTextDialog("TopButtonClick");
					dialog.cancel();
				}
				
				@Override
				public void onMiddleButtonClick(MyBottomButtonDialog dialog) {
					showTextDialog("MiddleButtonClick");
					dialog.cancel();
				}
			});
			mMyBottomButtonDialog.show();
			break;

		default:
			break;
		}
		
	}

}
