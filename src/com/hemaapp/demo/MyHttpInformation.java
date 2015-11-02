package com.hemaapp.demo;

import com.hemaapp.HemaConfig;
import com.hemaapp.MyConfig;
import com.hemaapp.demo.model.SysInitInfo;
import com.hemaapp.hm_FrameWork.HemaHttpInfomation;

/**
 * 网络请求信息枚举类
 */
public enum MyHttpInformation implements HemaHttpInfomation {
	/**
	 * 登录
	 */
	CLIENT_LOGIN(HemaConfig.ID_LOGIN, "client_login", "登录", false),
	// 注意登录接口id必须为HemaConfig.ID_LOGIN
	/**
	 * 后台服务接口根路径
	 */
	SYS_ROOT(0, MyConfig.SYS_ROOT, "后台服务接口根路径", true),
	/**
	 * 系统初始化
	 */
	INIT(1, "index.php/webservice/index/init", "系统初始化", false),
	/**
	 * 验证用户名是否合法
	 */
	CLIENT_VERIFY(2, "client_verify", "验证用户名是否合法", false),
	/**
	 * 申请随机验证码
	 */
	CODE_GET(3, "code_get", "申请随机验证码", false),
	/**
	 * 验证随机码
	 */
	CODE_VERIFY(4, "code_verify", "验证随机码", false),
	/**
	 * 用户注册
	 */
	CLIENT_ADD(5, "client_add", "用户注册", false),
	/**
	 * 上传文件（图片，音频，视频）
	 */
	FILE_UPLOAD(6, "file_upload", "上传文件（图片，音频，视频）", false),
	/**
	 * 重设密码
	 */
	PASSWORD_RESET(7, "password_reset", "重设密码", false),
	/**
	 * 退出登录
	 */
	CLIENT_LOGINOUT(8, "client_loginout", "退出登录", false),

	/**
	 * 获取支付宝交易签名串
	 */
	ALIPAY(9, "OnlinePay/Alipay/alipaysign_get.php", "获取支付宝交易签名串", false),
	/**
	 * 获取银联交易签名串
	 */
	UNIONPAY(10, "OnlinePay/Unionpay/unionpay_get.php", "获取银联交易签名串", false),
	/**
	 * 用户账户余额付款
	 */
	CLIENT_ACCOUNTPAY(11, "client_accountpay", "用户账户余额付款", false),
	/**
	 * 硬件注册保存
	 */
	DEVICE_SAVE(12, "device_save", "硬件注册保存", false),
	/**
	 * 修改密码
	 */
	PASSWORD_SAVE(13, "password_save", "修改密码", false),
	/**
	 * 获取用户信息
	 */
	CLIENT_GET(14, "client_get", "获取用户信息", false),
	/**
	 * 通知列表
	 */
	NOTICE_LIST(15, "notice_list", "通知列表", false),
	/**
	 * 添加模板
	 */
	TEMPLATE_ADD(16, "template_add", "添加模板", false),
	/**
	 * 修改模板
	 */
	TEMPLATE_SAVE(17, "template_save", "修改模板", false),
	/**
	 * 添加模板
	 */
	TEMPLATE_LIST(18, "template_list", "模板列表", false),
	/**
	 * 验证密保
	 */
	PASSWORD_ASK_CHECK(19, "password_ask_check", "验证密保", false),
	/**
	 * 保存密保
	 */
	PASSWORD_ASK_SAVE(20, "password_ask_save", "保存密保", false),
	/**
	 * 申请配送员
	 */
	DELIVERY_ADD(21, "delivery_add", "申请配送员", false),
	/**
	 * 保存银行卡
	 */
	BANK_SAVE(22, "bank_save", "保存银行卡", false),
	/**
	 * 保存支付宝账户
	 */
	ALI_SAVE(23, "ali_save", "保存支付宝账户", false),
	/**
	 * 新增发货
	 */
	TRANS_ADD(24, "trans_add", "新增发货", false),
	/**
	 * 捎带(订单)列表
	 */
	TRANS_LIST(25, "trans_list", "新增发货", false),
	/**
	 * 捎带(订单)详细
	 */
	TRANS_GET(26, "trans_get", "新增发货", false),
	/**
	 * 网点接单
	 */
	NETWORK_RECEIVE(27, "network_receive", "网点接单", false),
	/**
	 * 起始网点保存价格
	 */
	TRANS_PRICE_SAVE(28, "trans_price_save", "起始网点保存价格", false),
	/**
	 * 通知操作
	 */
	NOTICE_SAVEOPERATE(29, "notice_saveoperate", "通知操作", false),
	/**
	 * 申请提现
	 */
	CASH_ADD(30, "cash_add", "申请提现", false),
	/**
	 * 广告列表
	 */
	AD_LIST(31, "ad_list", "广告列表", false),
	/**
	 * 通用删除
	 */
	REMOVE(32, "remove", "通用删除", false),
	/**
	 * 账户明细
	 */
	FEEACCOUNT_LIST(33, "feeaccount_list", "通用删除", false),
	/**
	 * 意见反馈
	 */
	ADVICE_ADD(34, "advice_add", "意见反馈", false),
	/**
	 * 验证二维码是否有效
	 */
	TRANS_CODE_CHECK(35, "trans_code_check", "验证二维码是否有效", false),
	/**
	 * 密保列表
	 */
	PASSWORD_ASK_LIST(36, "password_ask_list", "密保列表", false),
	/**
	 * 获取站点列表
	 */
	SITE_LIST(37, "site_list", "获取站点列表", false),
	/**
	 * 获取站点列表
	 */
	DELIVERY_ORDER_LIST(38, "delivery_order_list", "获取站点列表", false),
	/**
	 * 确认收货
	 */
	TRANS_RECEIVE(39, "trans_receive", "确认收货", false),
	/**
	 * 配送员接单
	 */
	DELIVERY_RECEIVE(40, "delivery_receive", "配送员接单", false),
	/**
	 * 获取系统通知未读消息数
	 */
	NOTICE_COUNT(41, "notice_count", "获取系统通知未读消息数", false),
	/**
	 * 余额支付接口
	 */
	FEEACCOUNT_REMOVE(42, "feeaccount_remove", "余额支付接口", false),
	/**
	 * 配送员找货时站点的信息
	 */
	DELIVERY_SITE_GET(43, "delivery_site_get", "配送员找货时站点的信息", false),
	/**
	 * 配送员已接单信息
	 */
	DELIVERY_TRANS_GET(44, "delivery_trans_get", "配送员已接单信息", false),
	/**
	 * 银行列表
	 */
	BANK_LIST(45, "bank_list", "银行列表", false),
	/**
	 * 提现列表
	 */
	CASH_LIST(46, "cash_list", "提现列表", false),
	/**
	 * 保存用户
	 */
	CLIENT_SAVE(47, "client_save", "保存用户", false),
	/**
	 * 获取微信交易签名串接口
	 */
	WEIXINPAY_GET(48, "OnlinePay/Weixinpay/weixinpay_get.php", "获取微信交易签名串接口", false),
	/**
	 * 获取城市
	 */
	DISTRICT_LIST(49, "district_list", "获取城市", false),
	
	
	
	
	;

	
	private int id;// 对应NetTask的id
	private String urlPath;// 请求地址
	private String description;// 请求描述
	private boolean isRootPath;// 是否是根路径

	private MyHttpInformation(int id, String urlPath, String description,
			boolean isRootPath) {
		this.id = id;
		this.urlPath = urlPath;
		this.description = description;
		this.isRootPath = isRootPath;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getUrlPath() {
		if (isRootPath)
			return urlPath;

		String path = SYS_ROOT.urlPath + urlPath;

		if (this.equals(INIT))
			return path;

		MyApplication application = MyApplication.getInstance();
		SysInitInfo info = application.getSysInitInfo();
		path = info.getSys_web_service() + urlPath;

		 if (this.equals(ALIPAY))
			 path = info.getSys_plugins() + urlPath;
		
		 if (this.equals(UNIONPAY))
			 path = info.getSys_plugins() + urlPath;
		 
		 if(this.equals(WEIXINPAY_GET))
			 path = info.getSys_plugins() + urlPath;

		return path;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public boolean isRootPath() {
		return isRootPath;
	}

}
