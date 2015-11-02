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
 * �������󹤾���
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
	 * ϵͳ��ʼ��
	 */
	public void init()
	{
		MyHttpInformation information = MyHttpInformation.INIT;
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("lastloginversion", MyUtil.getAppVersion(mContext));// �汾����(Ĭ�ϣ�1.0.0)
		params.put("devicetype", String.valueOf(MyConfig.DEVICETYPE));// ��½���õ�ϵͳ�汾��
		params.put("device_sn", XtomDeviceUuidFactory.get(mContext));// �ͻ���Ӳ������
		MyNetTask task = new InitTask(information, params);
		executeTask(task);
	}
	/**
	 * ��¼
	 * @param username �û���
	 * @param password ����
	 */
	public void clientLogin(String username, String password) {
		MyHttpInformation information = MyHttpInformation.CLIENT_LOGIN;
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("username", username);// �û���¼�� �ֻ��Ż�����
		params.put("password", password); // ��½���� �������˴洢����32λ��MD5���ܴ�
		params.put("devicetype", "2"); // �û���¼�����ֻ����� 1��ƻ�� 2����׿�������������άͳ�ƣ�
		String version = MyUtil.getAppVersion(mContext);
		params.put("lastloginversion", version);// ��½���õ�ϵͳ�汾��
		params.put("submit", "�ύ");
		MyNetTask task = new ClientLoginTask(information, params);
		executeTask(task);
	}

	/**
	 * ��֤�û����Ƿ�Ϸ�
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
	 * �û��˳�
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
	 * ��ȡ���������У��б�
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

