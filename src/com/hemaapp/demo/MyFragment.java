package com.hemaapp.demo;

import xtom.frame.XtomActivityManager;
import xtom.frame.net.XtomNetWorker;
import xtom.frame.util.XtomSharedPreferencesUtil;
import android.content.Intent;

import com.hemaapp.demo.model.User;
import com.hemaapp.hm_FrameWork.HemaFragment;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.HemaNetWorker;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

public abstract class MyFragment extends HemaFragment {

	@Override
	protected HemaNetWorker initNetWorker() {
		return new MyNetWorker(getActivity());
	}
	@Override
	public MyNetWorker getNetWorker() {
		return (MyNetWorker)super.getNetWorker();
	}
	@Override
	public boolean onAutoLoginFailed(HemaNetWorker netWorker,
			HemaNetTask netTask, int failedType, HemaBaseResult baseResult) {
		switch (failedType) {
		case 0:// 服务器处理失败
			int error_code = baseResult.getError_code();
			switch (error_code) {
			case 102:// 密码错误
				XtomActivityManager.finishAll();
//				Intent it = new Intent(getActivity(), LoginActivity.class);
//				startActivity(it);
				return true;
			default:
				break;
			}
		case XtomNetWorker.FAILED_HTTP:// 网络异常
		case XtomNetWorker.FAILED_DATAPARSE:// 数据异常
		case XtomNetWorker.FAILED_NONETWORK:// 无网络
			break;
		}
		return false;
	}

	// ------------------------下面填充项目自定义方法---------------------------
	/**
	 * 获取系统类别
	 * 
	 * @return
	 */
	public String getSystype() {
		MyApplication application = MyApplication.getInstance();
		User user = application.getUser();
		if (user != null) {
			String key = "systype_" + user.getId();
			return XtomSharedPreferencesUtil.get(getActivity(), key);
		}
		return null;
	}

	/**
	 * 保存系统类别
	 * 
	 * @param systype
	 */
	public void saveSystype(String systype) {
		MyApplication application = MyApplication.getInstance();
		User user = application.getUser();
		if (user != null) {
			String key = "systype_" + user.getId();
			XtomSharedPreferencesUtil.save(getActivity(), key, systype);
		}
	}
}
