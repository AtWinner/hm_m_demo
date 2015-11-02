package com.hemaapp.demo.db;

import java.util.ArrayList;

import com.hemaapp.demo.model.DistrictInfor;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


/**
 * 访问城市缓存信息 数据库帮助类
 */
public class VisitCitysDBHelper extends DBHelper {

	private String tableName = VISIT_CITYS;

	String columns = "id,name,parentid,nodepath,namepath,charindex,level,orderby";

	String updateColumns = "id=?,name=?,parentid=?,nodepath=?,namepath=?,charindex=?,level=?,orderby=?";

	/**
	 * 实例化系统初始化信息数据库帮助类
	 * 
	 * @param context
	 */
	public VisitCitysDBHelper(Context context) {
		super(context);
	}

	public boolean insertOrUpdate(DistrictInfor district) {
		if (isExist(district)) {
			delete(district);
			return update(district);
		} else {
			return insert(district);
		}
	}

	public boolean reInsert(DistrictInfor district) {
		if (isExist(district))
			delete(district);
		return insert(district);
	}

	/**
	 * 插入一条记录
	 * 
	 * @return 是否成功
	 */
	public boolean insert(DistrictInfor district) {
		String sql = "insert into " + tableName + " (" + columns
				+ ") values (?,?,?,?,?,?,?,?)";

		Object[] bindArgs = new Object[] { district.getId(),
				district.getName(), district.getParentid(),
				district.getNodepath(), district.getNamepath(),
				district.getCharindex(), district.getLevel(),
				district.getOrderby() };

		SQLiteDatabase db = getWritableDatabase();
		boolean success = true;
		try {
			db.execSQL(sql, bindArgs);
		} catch (SQLException e) {
			success = false;
		}
		db.close();
		return success;
	}

	/**
	 * 更新
	 * 
	 * @return 是否成功
	 */
	public boolean update(DistrictInfor district) {
		String id = district.getId();
		String conditions = " where id='" + id + "'";
		String sql = "update " + tableName + " set " + updateColumns
				+ conditions;
		Object[] bindArgs = new Object[] { district.getId(),
				district.getName(), district.getParentid(),
				district.getNodepath(), district.getNamepath(),
				district.getCharindex(), district.getLevel(),
				district.getOrderby() };
		SQLiteDatabase db = getWritableDatabase();
		boolean success = true;
		try {
			db.execSQL(sql, bindArgs);
		} catch (SQLException e) {
			success = false;
		}
		db.close();
		return success;
	}

	public boolean isExist(DistrictInfor district) {
		String id = district.getId();
		String sql = ("select * from " + tableName + " where id='" + id + "'");
		SQLiteDatabase db = getWritableDatabase();
		Cursor cursor = db.rawQuery(sql, null);
		boolean exist = cursor.getCount() > 0;
		cursor.close();
		db.close();
		return exist;
	}

	/**
	 * 清空
	 */
	public void clear() {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL("delete from " + tableName);
		db.close();
	}

	/**
	 * 删除
	 */
	public boolean delete(DistrictInfor district) {
		boolean success;
		String id = district.getId();
		String conditions = " where id='" + id + "'";
		String sql = "delete from " + tableName + conditions;
		SQLiteDatabase db = getWritableDatabase();
		try {
			db.execSQL(sql);
			success = true;
		} catch (Exception e) {
			success = false;
		}
		db.close();
		return success;
	}

	/**
	 * 判断表是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		SQLiteDatabase db = getWritableDatabase();
		Cursor cursor = db.rawQuery("select * from " + tableName, null);
		boolean empty = 0 == cursor.getCount();
		cursor.close();
		db.close();
		return empty;
	}

	public ArrayList<DistrictInfor> select() {
		String sql = "select " + columns + " from " + tableName;
		SQLiteDatabase db = getWritableDatabase();
		ArrayList<DistrictInfor> list = new ArrayList<DistrictInfor>();
		Cursor cursor = db.rawQuery(sql, null);
		if (cursor != null && cursor.getCount() > 0) {
			cursor.moveToFirst();
			for (int i = 0; i < cursor.getCount(); i++) {
				DistrictInfor video = new DistrictInfor(cursor.getString(0),
						cursor.getString(1), cursor.getString(2),
						cursor.getString(3), cursor.getString(4),
						cursor.getString(5), cursor.getString(6),
						cursor.getString(7));
				list.add(video);
				cursor.moveToNext();
			}
		}
		if (cursor != null)
			cursor.close();
		db.close();
		return list;
	}

}
