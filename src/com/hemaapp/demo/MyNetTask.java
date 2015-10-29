package com.hemaapp.demo;

import java.util.HashMap;

import com.hemaapp.hm_FrameWork.HemaNetTask;

/**
 * ������������
 */
public abstract class MyNetTask extends HemaNetTask {
	/**
	 * ʵ����������������
	 * 
	 * @param information
	 *            ����������Ϣ
	 * @param params
	 *            ���������(������,����ֵ)
	 */
	public MyNetTask(MyHttpInformation information,
			HashMap<String, String> params) {
		this(information, params, null);
	}

	/**
	 * ʵ����������������
	 * 
	 * @param information
	 *            ����������Ϣ
	 * @param params
	 *            ���������(������,����ֵ)
	 * @param files
	 *            �����ļ���(������,�ļ��ı���·��)
	 */
	public MyNetTask(MyHttpInformation information,
			HashMap<String, String> params, HashMap<String, String> files) {
		super(information, params, files);
	}

	@Override
	public MyHttpInformation getHttpInformation() {
		return (MyHttpInformation) super.getHttpInformation();
	}

}
