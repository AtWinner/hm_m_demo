/*
 * Copyright (C) 2015 The Android Client Of QK Project
 * 
 *     The BeiJing PingChuanJiaHeng Technology Co., Ltd.
 * 
 * Author:Yang ZiTian
 * You Can Contact QQ:646172820 Or Email:mail_yzt@163.com
 */
package com.hemaapp.demo;

import xtom.frame.XtomActivityManager;
import xtom.frame.net.XtomNetWorker;
import android.content.Context;
import android.content.Intent;

import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.HemaNetTaskExecuteListener;
import com.hemaapp.hm_FrameWork.HemaNetWorker;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

/**
 * ��������ִ�м���
 */
public abstract class MyNetTaskExecuteListener extends
		HemaNetTaskExecuteListener {

	public MyNetTaskExecuteListener(Context context) {
		super(context);
	}

	@Override
	public boolean onAutoLoginFailed(HemaNetWorker netWorker,
			HemaNetTask netTask, int failedType, HemaBaseResult baseResult) {
		switch (failedType) {
		case 0:// ����������ʧ��
			int error_code = baseResult.getError_code();
			switch (error_code) {
			case 102:// �������
//				XtomActivityManager.finishAll();
//				Intent it = new Intent(mContext, LoginActivity.class);
//				mContext.startActivity(it);
				return true;
			default:
				break;
			}
		case XtomNetWorker.FAILED_HTTP:// �����쳣
		case XtomNetWorker.FAILED_DATAPARSE:// �����쳣
		case XtomNetWorker.FAILED_NONETWORK:// ������
			break;
		}
		return false;
	}

}
