package com.hemaapp.demo.activity;

import xtom.frame.util.XtomSharedPreferencesUtil;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.MyHttpInformation;
import com.hemaapp.demo.MyUtil;
import com.hemaapp.demo.db.UserDBHelper;
import com.hemaapp.demo.model.User;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaArrayResult;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

/**
 * 登录界面
 * @author Wen
 * @author HuFanglin
 *
 */
public class LoginActivity extends MyActivity implements OnClickListener
{
	private EditText editPhone, editPwd;
	private TextView txtRegister, txtForgetPwd;
	private Button btnConfirm;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_login);
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void findView() {
		editPhone = (EditText)findViewById(R.id.editPhone);
		editPwd = (EditText)findViewById(R.id.editPwd);
		txtRegister = (TextView)findViewById(R.id.txtRegister);
		txtForgetPwd = (TextView)findViewById(R.id.txtForgetPwd);
		txtForgetPwd.setText(Html.fromHtml("<u>忘记密码</u>？"));
		btnConfirm = (Button)findViewById(R.id.btnConfirm);
		
	}

	@Override
	protected void setListener() {
		txtRegister.setOnClickListener(this);
		txtForgetPwd.setOnClickListener(this);
		btnConfirm.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch(v.getId())
		{
		case R.id.txtRegister:
		case R.id.txtForgetPwd:
			break;
		case R.id.btnConfirm:
			clickConfirm();
			break;
		}
	}

	
	/**
	 * 点击确定按钮
	 */
	private void clickConfirm()
	{
		String phoneNumber = editPhone.getEditableText().toString();
		String password = editPwd.getEditableText().toString();
		if(!MyUtil.checkPhoneNumber(phoneNumber))
		{//验证手机号是否合法
			showTextDialog("手机号格式不正确！请重输");
			return;
		}
		if(password.length() < 6 || password.length() > 16)
		{
			showTextDialog("请输入6-16位密码");
			return;
		}
		showProgressDialog("登录中，请稍后");
		getNetWorker().clientVerify(phoneNumber);
	}
	
	@Override
	protected void callAfterDataBack(HemaNetTask arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void callBackForGetDataFailed(HemaNetTask arg0, int arg1) {
		cancelProgressDialog();
		
	}

	@Override
	protected void callBackForServerFailed(HemaNetTask netTask, HemaBaseResult result) {
		MyHttpInformation information = (MyHttpInformation)netTask.getHttpInformation();
		switch(information)
		{
		case CLIENT_VERIFY:
		case CLIENT_LOGIN:
			cancelProgressDialog();
			showTextDialog(result.getMsg());
		}
		
	}

	@Override
	protected void callBackForServerSuccess(HemaNetTask netTask,
			HemaBaseResult baseResult) {
		MyHttpInformation information = (MyHttpInformation)netTask.getHttpInformation();
		switch(information)
		{
		case CLIENT_VERIFY:
		{
			String phoneNumber = editPhone.getEditableText().toString();
			String password = editPwd.getEditableText().toString();
			getNetWorker().clientLogin(phoneNumber, password);
		}
			break;
		case CLIENT_LOGIN:
			HemaArrayResult<User> sUser = (HemaArrayResult<User>)baseResult;
			getApplicationContext().setUser(sUser.getObjects().get(0));
			cancelProgressDialog();
			String username = netTask.getParams().get("username");
			String password = netTask.getParams().get("password");
			XtomSharedPreferencesUtil.save(mContext, "username", username);
			XtomSharedPreferencesUtil.save(mContext, "password", password);
			UserDBHelper helper = new UserDBHelper(mContext);
			helper.insert(sUser.getObjects().get(0));
			Intent intent = new Intent(LoginActivity.this, MainActivity.class);
			startActivity(intent);
			overridePendingTransition(R.anim.right_in, R.anim.none);
			this.finish();
			break;
		}
		
	}

	@Override
	protected void callBeforeDataBack(HemaNetTask arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}

    @Override
    protected boolean onKeyBack() {
    	finish(R.anim.none, R.anim.right_out);
		return super.onKeyBack();
    }
    
}
