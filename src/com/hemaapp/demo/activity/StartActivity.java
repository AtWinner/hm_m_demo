package com.hemaapp.demo.activity;

import xtom.frame.util.XtomSharedPreferencesUtil;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.MyHttpInformation;
import com.hemaapp.demo.MyNetWorker;
import com.hemaapp.demo.db.UserDBHelper;
import com.hemaapp.demo.model.SysInitInfo;
import com.hemaapp.demo.model.User;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaArrayResult;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

/**
 * 初始页
 * @author Wen
 * @author HuFanglin
 * 系统初始化->登录->跳转
 */
public class StartActivity extends MyActivity
{
	private SysInitInfo sysInitInfo;
	private User user;
	public TextView txtWelcome;
	private boolean IsFromNotice = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_start);
		super.onCreate(savedInstanceState);
		init();
	}
	private void init()
	{
		sysInitInfo = getApplicationContext().getSysInitInfo();
		user = getApplicationContext().getUser();
		txtWelcome = (TextView)findViewById(R.id.txtWelcome);
		Animation animation = AnimationUtils.loadAnimation(this, R.anim.logo);
		animation.setAnimationListener(new StartAnimationListener());
		txtWelcome.startAnimation(animation);
		findViewById(R.id.txtMiddle).startAnimation(animation);
		findViewById(R.id.txtBottom).startAnimation(animation);
	}
	
	private class StartAnimationListener implements AnimationListener {

		@Override
		public void onAnimationStart(Animation animation) {
		}

		@Override
		public void onAnimationEnd(Animation animation) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						Thread.sleep(0);
					} 
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					MyNetWorker netWorker = getNetWorker();
					netWorker.init();
				}
			}).start();
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
		}
	}

	@Override
	protected void callAfterDataBack(HemaNetTask arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void callBackForGetDataFailed(HemaNetTask arg0, int arg1) {
		showTextDialog("系统初始化失败，请确定网络参数");
	}

	@Override
	protected void callBackForServerFailed(HemaNetTask netTask, HemaBaseResult result) {

			
	}

	@Override
	protected void callBackForServerSuccess(HemaNetTask netTask,
			HemaBaseResult baseResult) {
		MyHttpInformation infomation = (MyHttpInformation)netTask.getHttpInformation();
		switch (infomation) {
		case INIT:
			HemaArrayResult<SysInitInfo> sResult = (HemaArrayResult<SysInitInfo>)baseResult;
			sysInitInfo = sResult.getObjects().get(0);
			getApplicationContext().setSysInitInfo(sysInitInfo);
			String username = XtomSharedPreferencesUtil.get(this, "username");
			String password = XtomSharedPreferencesUtil.get(this, "password");
			if (!isNull(username) && !isNull(password)) 
			{
				MyNetWorker netWorker = getNetWorker();
				netWorker.clientLogin(username, password);
			}
			else
			{
				Intent intent = new Intent(this, LoginActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.right_in, R.anim.none);
				finish();
			}
			break;
		case CLIENT_LOGIN:
			HemaArrayResult<User> sUser = (HemaArrayResult<User>)baseResult;
			this.user = sUser.getObjects().get(0);
			getApplicationContext().setUser(user);
			new UserDBHelper(mContext).update(user);
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			overridePendingTransition(R.anim.right_in, R.anim.none);
			finish();
			break;

		default:
			break;
		}
		
	}

	@Override
	protected void callBeforeDataBack(HemaNetTask arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void findView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void getExras() {
		IsFromNotice = getIntent().getBooleanExtra("IsFromNotice", false);
	}

	@Override
	protected void setListener() {
		// TODO Auto-generated method stub
		
	}

	
}
