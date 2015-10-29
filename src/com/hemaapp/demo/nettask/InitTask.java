package com.hemaapp.demo.nettask;

import java.util.HashMap;

import org.json.JSONObject;

import com.hemaapp.demo.MyHttpInformation;
import com.hemaapp.demo.MyNetTask;
import com.hemaapp.demo.model.SysInitInfo;
import com.hemaapp.hm_FrameWork.result.HemaArrayResult;

import xtom.frame.exception.DataParseException;

/**
 * 系统初始化
 */
public class InitTask extends MyNetTask {

	public InitTask(MyHttpInformation information,
			HashMap<String, String> params) {
		super(information, params);
	}

	public InitTask(MyHttpInformation information,
			HashMap<String, String> params, HashMap<String, String> files) {
		super(information, params, files);
	}

	@Override
	public Object parse(JSONObject jsonObject) throws DataParseException {
		return new Result(jsonObject);
	}

	private class Result extends HemaArrayResult<SysInitInfo> {

		public Result(JSONObject jsonObject) throws DataParseException {
			super(jsonObject);
		}

		@Override
		public SysInitInfo parse(JSONObject jsonObject)
				throws DataParseException {
			return new SysInitInfo(jsonObject);
		}

	}
}
