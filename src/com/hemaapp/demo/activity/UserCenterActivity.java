package com.hemaapp.demo.activity;

import xtom.frame.image.cache.XtomImageCache;
import xtom.frame.media.XtomVoicePlayer;
import xtom.frame.util.XtomSharedPreferencesUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import cn.pedant.SweetAlert.SweetAlertDialog;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.MyHttpInformation;
import com.hemaapp.demo.MyUtil;
import com.hemaapp.demo.dialog.MyTwoButtonDialog;
import com.hemaapp.demo.dialog.MyTwoButtonDialog.OnButtonListener;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

public class UserCenterActivity extends MyActivity implements OnClickListener {
	private Button btnQuit, btnClear;
	private String CacheSize;
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
			showTextDialog("ÒÑÍË³ö");
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
		showTextDialog("Á¬½ÓÊ§°Ü");
	}

	@Override
	protected void findView() {
		btnQuit = (Button)findViewById(R.id.btnQuit);
		btnClear = (Button)findViewById(R.id.btnClear);
	}

	@Override
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		btnQuit.setOnClickListener(this);
		btnClear.setOnClickListener(this);
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
		case R.id.btnClear:
			CacheSize = MyUtil.getCacheSize(mContext);
			new ClearTask().execute();
			break;
		default:
			break;
		}
	}
	private class ClearTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			// É¾³ýÍ¼Æ¬»º´æ
			XtomImageCache.getInstance(mContext).deleteCache();
			// É¾³ýÓïÒô»º´æ
			XtomVoicePlayer player = XtomVoicePlayer.getInstance(mContext);
			player.deleteCache();
			player.release();
			return null;
		}

		@Override
		protected void onPreExecute() {
			showProgressDialog("ÕýÔÚÇå³ý»º´æ");
		}
		@Override
		protected void onPostExecute(Void result) {
			cancelProgressDialog();
			SweetAlertDialog dialog = new SweetAlertDialog(mContext, SweetAlertDialog.SUCCESS_TYPE)
            	.setConfirmText("È·¶¨");
			dialog.setTitleText("Çå³ý" + CacheSize);
			dialog.setCancelable(false);
			dialog.show();
		}
	}
}
