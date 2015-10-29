/*
 * Copyright (C) 2014 The Android Client Of Demo Project
 * 
 *     The BeiJing PingChuanJiaHeng Technology Co., Ltd.
 * 
 * Author:Yang ZiTian
 * You Can Contact QQ:646172820 Or Email:mail_yzt@163.com
 */
package com.hemaapp;

import android.graphics.Color;

/**
 * 该项目配置信息
 */
public class MyConfig {
	/**
	 * 是否开发环境
	 */
	public static final boolean IS_DEVELOPMENT = true;
	/**
	 * 设备类型
	 *  1:苹果；2:安卓； 
	 *  接口路由使用，必须传此参数  
	 */
	public static final int DEVICETYPE = 2;
	/**
	 * 是否打印信息开关
	 */
	public static final boolean DEBUG = true;
	/**
	 * 是否启用友盟统计
	 */
	public static final boolean UMENG_ENABLE = false;
	/**
	 * 网络请求连接超时时限(单位:毫秒)
	 */
	public static final int TIMEOUT_HTTP = 20000;
	/**
	 * 网络请求尝试次数
	 */
	public static final int TRYTIMES_HTTP = 1;
	/**
	 * 图片压缩的最大宽度
	 */
	public static final int IMAGE_WIDTH = 640;
	/**
	 * 图片压缩的最大高度
	 */
	public static final int IMAGE_HEIGHT = 3000;
	/**
	 * 图片压缩的失真率
	 */
	public static final int IMAGE_QUALITY = 100;
	/**
	 * 银联支付环境--"00"生产环境,"01"测试环境
	 */
	public static final String UNIONPAY_TESTMODE = "00";
	/**
	 * 微信appid
	 */
	public static final String APPID_WEIXIN = "wx0789d6863bfbdca0";
	
	/**
	 * 后台服务接口根路径
	 */
	public static final String SYS_ROOT = "http://124.128.23.74:8008/group4/hm_rrg/";
//	public static final String SYS_ROOT = "http://124.128.23.74:8008/group4/hm_gtsd/";
//	public static final String SYS_ROOT = "http://192.168.2.146:8008/group4/hm_gtsd/";
	/**
	 * 配送员（捎带者）
	 */
	public static final int USER_IDENTIFY_CURSOR = 0;
	/**
	 * 收货人
	 */
	public static final int USER_IDENTIFY_RECIVIER = 1;
	/**
	 * 网点
	 */
	public static final int USER_IDENTIFY_SITE = 2;
	/**
	 * 网点B
	 */
	public static final int USER_IDENTIFY_SITE_B = 3;
	/**
	 * 发货人
	 */
	public static final int USER_IDENTIFY_SENDER = 4;
	/**
	 * 主色调
	 */
	public static final int Main_Blue = Color.rgb(0, 161, 216);
	/**
	 * 修改登录密码
	 */
	public static final int CHANGE_LOGIN_PWD = 10;
	/**
	 * 修改支付密码
	 */
	public static final int CHANGE_PAY_PWD = 20;
	/**
	 * 找回支付密码
	 */
	public static final int FIND_PAY_PWD = 30;
	/**
	 * 扫描绑定二维码
	 */
	public static final int CODE_BIND = 0;
	/**
	 * 扫描二维码收货收货人
	 */
	public static final int CODE_GET = 1;
	/**
	 * 扫描二维码网点接单
	 */
	public static final int CODE_SITE = 2;
	/**
	 * 扫描二维码配送员接货
	 */
	public static final int CODE_CURSOR = 3;
	/**
	 * 发货扫码
	 */
	public static final int CODE_SEND = 4;
}
