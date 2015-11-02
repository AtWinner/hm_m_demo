package com.hemaapp.demo.nettask;

import java.util.HashMap;

import org.json.JSONObject;

import xtom.frame.exception.DataParseException;

import com.hemaapp.demo.MyHttpInformation;
import com.hemaapp.demo.MyNetTask;
import com.hemaapp.demo.model.DistrictInfor;
import com.hemaapp.hm_FrameWork.result.HemaPageArrayResult;

/**
 * 获取地区（城市）列表信息
 * */
public class DistrictListTask extends MyNetTask{

	public DistrictListTask(MyHttpInformation information,
			HashMap<String, String> params) {
		super(information, params);
	}
	
	public DistrictListTask(MyHttpInformation information,
			HashMap<String, String> params, HashMap<String, String> files) {
		super(information, params, files);
	}

	@Override
	public Object parse(JSONObject jsonObject) throws DataParseException {
		return new Result(jsonObject);
	}

	private class Result extends HemaPageArrayResult<DistrictInfor> {

		public Result(JSONObject jsonObject) throws DataParseException {
			super(jsonObject);
		}

		@Override
		public DistrictInfor parse(JSONObject jsonObject) throws DataParseException {
			return new DistrictInfor(jsonObject);
		}

	}
}
