package com.hemaapp.demo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 
 */
public class DBHelper extends SQLiteOpenHelper {
	private static final String DBNAME = "demo.db";
	/**
	 * 系统初始化信息
	 */
	protected static final String SYSINITINFO = "sysinfo";
	/**
	 * 当前登录用户信息
	 */
	protected static final String USER = "user";
	/**
	 * 访问城市缓存信息
	 */
	protected static final String VISIT_CITYS = "visit_citys";

	public DBHelper(Context context) {
		super(context, DBNAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sys = "sys_web_service text,sys_plugins text,android_must_update text,android_last_version text,iphone_must_update text,"
				+ "iphone_last_version text,sys_chat_ip text,sys_chat_port text,sys_pagesize text,sys_service_phone text,android_update_url text,"
				+ "iphone_update_url text,apad_update_url text,ipad_update_url text,iphone_comment_url text,msg_invite text";
		String sysSQL = "create table " + SYSINITINFO
				+ " (id integer primary key," + sys + ")";
		// 创建系统初始化信息缓存表
		db.execSQL(sysSQL);
		// 创建当前登录用户信息缓存表
		String user = "id text,username text,email text,password text,nickname text,charindex text,sex text,mobile text,age text,selfsign text,"
				+ "avatar text,birthday text,avatarbig text,backimg text,address text,onlineflag text,validflag text,vestflag text,score text,feeaccount text,"
				+ "transaccount text,lng text,lat text,deviceid text,devicetype text,channelid text,lastloginversion text,lastlogintime text,content text,"
				+ "delflag text,regdate text,ask1_id text,answer1 text,ask2_id text,answer2 text,ask3_id text,answer3 text,aliuser text,bankuser text,bankname text,"
				+ "bankcard text,bankaddress text,transflag text,checkflag text,role text";
		String userSQL = "create table " + USER + " (" + user + ")";
		db.execSQL(userSQL);
		// 创建访问城市缓存表
				String citys = "id text primary key,name text,parentid text,nodepath text,"
						+ "namepath text,charindex text,level text,orderby text";
				String citysSQL = "create table " + VISIT_CITYS + " (" + citys + ")";
				db.execSQL(citysSQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j) {

	}

}
