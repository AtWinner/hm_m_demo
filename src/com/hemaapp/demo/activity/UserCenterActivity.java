package com.hemaapp.demo.activity;

import xtom.frame.util.XtomSharedPreferencesUtil;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.MyHttpInformation;
import com.hemaapp.demo.dialog.MyTwoButtonDialog;
import com.hemaapp.demo.dialog.MyTwoButtonDialog.OnButtonListener;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

public class UserCenterActivity extends MyActivity implements OnClickListener {
	private Button btnQuit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_usercenter);
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void callBeforeDataBack(HemaNetTask netTask) {
		MyHttpInformation infomation = (MyHttpInformation)netTask.getHttpInformation();
		switch (infomation) {
		case CLIENT_LOGINOUT:
			showProgressDialog(R.string.progressQuit);
			break;

		default:
			break;
		}
	}

	@Override
	protected void callAfterDataBack(HemaNetTask netTask) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void callBackForServerSuccess(HemaNetTask netTask,
			HemaBaseResult baseResult) {
		MyHttpInformation infomation = (MyHttpInformation)netTask.getHttpInformation();
		switch (infomation) {
		case CLIENT_LOGINOUT:
			getApplicationContext().setUser(null);
			XtomSharedPreferencesUtil.save(mContext, "username", "");
			XtomSharedPreferencesUtil.save(mContext, "password", "");
			cancelProgressDialog();
			showTextDialog("已退出");
			break;
		}
		
	}

	@Override
	protected void callBackForServerFailed(HemaNetTask netTask,
			HemaBaseResult baseResult) {
		cancelProgressDialog();
		showTextDialog(baseResult.getMsg());
		
	}

	@Override
	protected void callBackForGetDataFailed(HemaNetTask netTask, int failedType) {
		cancelProgressDialog();
		showTextDialog("连接失败");
	}

	@Override
	protected void findView() {
		btnQuit = (Button)findViewById(R.id.btnQuit);
	}

	@Override
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		btnQuit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnQuit:
			MyTwoButtonDialog dialog = new MyTwoButtonDialog(mContext);
			dialog.setText(R.string.askQuit);
			dialog.setButtonListener(new OnButtonListener() {
				@Override
				public void onRightButtonClick(MyTwoButtonDialog dialog) {
					dialog.cancel();
					if(getApplicationContext().getUser() == null || isNull(getApplicationContext().getUser().getToken()))
					{
						showTextDialog(R.string.haveNoUserInfo);
					}
					else
					{
						getNetWorker().clientLoginOut(getApplicationContext().getUser().getToken());
					}
				}
				@Override
				public void onLeftButtonClick(MyTwoButtonDialog dialog) {
					dialog.cancel();
				}
			});
			dialog.show();
			break;

		default:
			break;
		}
	}

}
