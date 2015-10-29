/*
 * Copyright (C) 2014 The Android Client Of Demo Project
 * 
 *     The BeiJing PingChuanJiaHeng Technology Co., Ltd.
 * 
 * Author:Yang ZiTian
 * You Can Contact QQ:646172820 Or Email:mail_yzt@163.com
 */
package com.hemaapp.demo.result;

import org.json.JSONException;
import org.json.JSONObject;

import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

import xtom.frame.XtomObject;
import xtom.frame.exception.DataParseException;

/**
 * 最基本的服务器返回结果
 */
public class MyBaseResult extends HemaBaseResult {
	private boolean success;// 服务器处理状态
	private String msg;// 服务器返回的描述信息
	private int error_code;// 当status==0时，会有一个对应的error_code。详见错误编码表

	/**
	 * 实例化一个最基本的服务器返回结果
	 * 
	 * @param jsonObject
	 *            一个JSONObject实例
	 * @throws DataParseException
	 *             数据解析异常
	 */
	public MyBaseResult(JSONObject jsonObject) throws DataParseException {
		super(jsonObject);
		if (jsonObject != null) {
			try {
				success = jsonObject.getBoolean("success");
				msg = get(jsonObject, "msg");
				if (!jsonObject.isNull("error_code")) {
					error_code = jsonObject.getInt("error_code");
				}
			} catch (JSONException e) {
				throw new DataParseException(e);
			}
		}
	}

	/**
	 * @return 服务器执行状态
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @return 服务器返回的描述信息
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 获取error_code值
	 * 
	 * @return 一个整数(当status==0时，会有一个对应的error_code。详见错误编码表)
	 */
	public int getError_code() {
		return error_code;
	}

}