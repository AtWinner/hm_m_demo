package com.hemaapp.demo;

import java.util.HashMap;

import com.hemaapp.hm_FrameWork.HemaNetTask;

/**
 * 网络请求任务
 */
public abstract class MyNetTask extends HemaNetTask {
	/**
	 * 实例化网络请求任务
	 * 
	 * @param information
	 *            网络请求信息
	 * @param params
	 *            任务参数集(参数名,参数值)
	 */
	public MyNetTask(MyHttpInformation information,
			HashMap<String, String> params) {
		this(information, params, null);
	}

	/**
	 * 实例化网络请求任务
	 * 
	 * @param information
	 *            网络请求信息
	 * @param params
	 *            任务参数集(参数名,参数值)
	 * @param files
	 *            任务文件集(参数名,文件的本地路径)
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
