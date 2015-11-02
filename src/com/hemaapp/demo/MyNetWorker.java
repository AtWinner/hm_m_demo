package com.hemaapp.demo;

import java.util.HashMap;

import xtom.frame.util.XtomDeviceUuidFactory;
import android.content.Context;

import com.hemaapp.MyConfig;
import com.hemaapp.demo.nettask.ClientLoginTask;
import com.hemaapp.demo.nettask.CurrentTask;
import com.hemaapp.demo.nettask.DistrictListTask;
import com.hemaapp.demo.nettask.InitTask;
import com.hemaapp.hm_FrameWork.HemaNetWorker;
/**
 * 网络请求工具类
 * @author Wen
 * @author HuFanglin
 *
 */
public class MyNetWorker extends HemaNetWorker {
	private Context mContext;

	public MyNetWorker(Context mContext) {
		super(mContext);
		this.mContext = mContext;
	}

	@Override
	public void clientLogin() {
	}

	@Override
	public boolean thirdSave() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 系统初始化
	 */
	public void init()
	{
		MyHttpInformation information = MyHttpInformation.INIT;
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("lastloginversion", MyUtil.getAppVersion(mContext));// 版本号码(默认：1.0.0)
		params.put("devicetype", String.valueOf(MyConfig.DEVICETYPE));// 登陆所用的系统版本号
		params.put("device_sn", XtomDeviceUuidFactory.get(mContext));// 客户端硬件串号
		MyNetTask task = new InitTask(information, params);
		executeTask(task);
	}
	/**
	 * 登录
	 * @param username 用户名
	 * @param password 密码
	 */
	public void clientLogin(String username, String password) {
		MyHttpInformation information = MyHttpInformation.CLIENT_LOGIN;
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("username", username);// 用户登录名 手机号或邮箱
		params.put("password", password); // 登陆密码 服务器端存储的是32位的MD5加密串
		params.put("devicetype", "2"); // 用户登录所用手机类型 1：苹果 2：安卓（方便服务器运维统计）
		String version = MyUtil.getAppVersion(mContext);
		params.put("lastloginversion", version);// 登陆所用的系统版本号
		params.put("submit", "提交");
		MyNetTask task = new ClientLoginTask(information, params);
		executeTask(task);
	}

	/**
	 * 验证用户名是否合法
	 * @param username
	 */
	public void clientVerify(String username)
	{
		MyHttpInformation information = MyHttpInformation.CLIENT_VERIFY;
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("username", username);
		MyNetTask task = new CurrentTask(information, params);
		executeTask(task);
	}
	/**
	 * 用户退出
	 * @param token
	 */
	public void clientLoginOut(String token)
	{
		MyHttpInformation information = MyHttpInformation.CLIENT_LOGINOUT;
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("token", token);
		MyNetTask task = new CurrentTask(information, params);
		executeTask(task);
	}
	/**
	 * 获取地区（城市）列表
	 * @param parentid
	 */
	public void districtList(String parentid)
	{
		MyHttpInformation information = MyHttpInformation.DISTRICT_LIST;
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("parentid", parentid);
		MyNetTask task = new DistrictListTask(information, params);
		executeTask(task);
	}
	

}

