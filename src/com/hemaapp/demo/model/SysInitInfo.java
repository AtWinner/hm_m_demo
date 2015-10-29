package com.hemaapp.demo.model;

import org.json.JSONException;
import org.json.JSONObject;

import xtom.frame.XtomObject;
import xtom.frame.exception.DataParseException;

/**
 * 系统初始化信息
 */
public class SysInitInfo extends XtomObject {

	private String sys_web_service;// 后台服务根路径(含版本号)
	// 形如： http://192.168.0.146:8008/group1/wb_qk/index.php/Webservice/V100/
	// 说明：V100是服务器转换处理后的版本号，V100 对应客户端版本是1.0.0

	private String sys_plugins;// 第三方插件根路径形如：http://58.56.89.218:8008/group1/hm_PHP/plugins/
	private String android_must_update;// 安卓强制更新标记0：不强制1：强制（当软件架构进行了较大变动，客户端必须强制用户升级到最新版本）
	private String android_last_version;// 安卓最新版本号 将该信息与安卓本机版本号比对，如果不相等，则提醒在线升级
	private String iphone_must_update;// 苹果强制更新标记0：不强制1：强制（当软件架构进行了较大变动，客户端必须强制用户升级到最新版本）
	private String iphone_last_version;// 苹果最新版本号 将该信息与苹果本机版本号比对，如果不相等，则提醒在线升级
	private String sys_chat_ip;// 聊天服务器IP地址 形如：192.168.0.146
	private String sys_chat_port;// 聊天服务器端口号 形如：5222（一个整数）
	private int sys_pagesize;// 系统规定单页记录数 此参数在系统列表分页时需要用到，默认：20
	private String sys_service_phone;// 我公司统一客服电话 前台客服解疑释惑专用，目前是"0531-67804172"
	private String android_update_url;// 安卓软件更新地址,类似http://192.168.0.146:8008/group1/wb_qk/download/qk.apk
	private String iphone_update_url;// 苹果软件更新地址,类似https://itunes.apple.com/cn/app/biaobiao/id844008952?mt=8
	private String apad_update_url;// 安卓软件更新地址,类似http://192.168.0.146:8008/group1/wb_qk/download/qk_pad.apk
	private String ipad_update_url;// 苹果软件更新地址,类似https://itunes.apple.com/cn/app/biaobiao/id844008952?mt=8
	private String iphone_comment_url;// 苹果软件评论地址 同上
	private String msg_invite;// 邀请下载短信内容

	public SysInitInfo(JSONObject jsonObject) throws DataParseException {
		if (jsonObject != null) {
			try {
				sys_web_service = get(jsonObject, "sys_web_service");
				sys_plugins = get(jsonObject, "sys_plugins");
				android_must_update = get(jsonObject, "android_must_update");
				android_last_version = get(jsonObject, "android_last_version");
				iphone_must_update = get(jsonObject, "iphone_must_update");
				iphone_last_version = get(jsonObject, "iphone_last_version");
				sys_chat_ip = get(jsonObject, "sys_chat_ip");
				sys_chat_port = get(jsonObject, "sys_chat_port");
				if (!jsonObject.isNull("sys_pagesize"))
					sys_pagesize = jsonObject.getInt("sys_pagesize");
				sys_service_phone = get(jsonObject, "sys_service_phone");
				android_update_url = get(jsonObject, "android_update_url");
				iphone_update_url = get(jsonObject, "iphone_update_url");
				apad_update_url = get(jsonObject, "apad_update_url");
				ipad_update_url = get(jsonObject, "ipad_update_url");
				iphone_comment_url = get(jsonObject, "iphone_comment_url");
				msg_invite = get(jsonObject, "msg_invite");

				log_i(toString());
			} catch (JSONException e) {
				throw new DataParseException(e);
			}
		}
	}

	public SysInitInfo(String sys_web_service, String sys_plugins,
			String android_must_update, String android_last_version,
			String iphone_must_update, String iphone_last_version,
			String sys_chat_ip, String sys_chat_port, int sys_pagesize,
			String sys_service_phone, String android_update_url,
			String iphone_update_url, String apad_update_url,
			String ipad_update_url, String iphone_comment_url, String msg_invite) {
		super();
		this.sys_web_service = sys_web_service;
		this.sys_plugins = sys_plugins;
		this.android_must_update = android_must_update;
		this.android_last_version = android_last_version;
		this.iphone_must_update = iphone_must_update;
		this.iphone_last_version = iphone_last_version;
		this.sys_chat_ip = sys_chat_ip;
		this.sys_chat_port = sys_chat_port;
		this.sys_pagesize = sys_pagesize;
		this.sys_service_phone = sys_service_phone;
		this.android_update_url = android_update_url;
		this.iphone_update_url = iphone_update_url;
		this.apad_update_url = apad_update_url;
		this.ipad_update_url = ipad_update_url;
		this.iphone_comment_url = iphone_comment_url;
		this.msg_invite = msg_invite;
	}

	@Override
	public String toString() {
		return "SysInitInfo [sys_web_service=" + sys_web_service
				+ ", sys_plugins=" + sys_plugins + ", android_must_update="
				+ android_must_update + ", android_last_version="
				+ android_last_version + ", iphone_must_update="
				+ iphone_must_update + ", iphone_last_version="
				+ iphone_last_version + ", sys_chat_ip=" + sys_chat_ip
				+ ", sys_chat_port=" + sys_chat_port + ", sys_pagesize="
				+ sys_pagesize + ", sys_service_phone=" + sys_service_phone
				+ ", android_update_url=" + android_update_url
				+ ", iphone_update_url=" + iphone_update_url
				+ ", apad_update_url=" + apad_update_url + ", ipad_update_url="
				+ ipad_update_url + ", iphone_comment_url="
				+ iphone_comment_url + ", msg_invite=" + msg_invite + "]";
	}

	/**
	 * @return the sys_web_service
	 */
	public String getSys_web_service() {
		return sys_web_service;
	}

	/**
	 * @return the sys_plugins
	 */
	public String getSys_plugins() {
		return sys_plugins;
	}

	/**
	 * @return the android_must_update
	 */
	public String getAndroid_must_update() {
		return android_must_update;
	}

	/**
	 * @return the android_last_version
	 */
	public String getAndroid_last_version() {
		return android_last_version;
	}

	/**
	 * @return the iphone_must_update
	 */
	public String getIphone_must_update() {
		return iphone_must_update;
	}

	/**
	 * @return the iphone_last_version
	 */
	public String getIphone_last_version() {
		return iphone_last_version;
	}

	/**
	 * @return the sys_chat_ip
	 */
	public String getSys_chat_ip() {
		return sys_chat_ip;
	}

	/**
	 * @return the sys_chat_port
	 */
	public String getSys_chat_port() {
		return sys_chat_port;
	}

	/**
	 * @return the sys_pagesize
	 */
	public int getSys_pagesize() {
		return sys_pagesize;
	}

	/**
	 * @return the sys_service_phone
	 */
	public String getSys_service_phone() {
		return sys_service_phone;
	}

	/**
	 * @return the android_update_url
	 */
	public String getAndroid_update_url() {
		return android_update_url;
	}

	/**
	 * @return the iphone_update_url
	 */
	public String getIphone_update_url() {
		return iphone_update_url;
	}

	/**
	 * @return the apad_update_url
	 */
	public String getApad_update_url() {
		return apad_update_url;
	}

	/**
	 * @return the ipad_update_url
	 */
	public String getIpad_update_url() {
		return ipad_update_url;
	}

	/**
	 * @return the iphone_comment_url
	 */
	public String getIphone_comment_url() {
		return iphone_comment_url;
	}

	/**
	 * @return the msg_invite
	 */
	public String getMsg_invite() {
		return msg_invite;
	}

}
