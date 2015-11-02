package com.hemaapp.demo.model;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

import xtom.frame.XtomObject;
import xtom.frame.exception.DataParseException;

/**
 * ������Ϣ
 * */
public class DistrictInfor extends XtomObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id; //����id
	private String name; //��������
	private String parentid; //����������
	private String nodepath; //�ڵ�����·����
	private String namepath; //�ڵ�����·����
	private String charindex; //����ƴ������ĸ����
	private String level; //�ڵ�㼶
	private String orderby; //�������ȼ�
	
	private String checkflag; //0��1��
	private boolean isChecked = false;
	
	public DistrictInfor(JSONObject jsonObject) throws DataParseException {
		if(jsonObject!=null){
			try {
				id = get(jsonObject, "id");
				name = get(jsonObject, "name");
				parentid = get(jsonObject, "parentid");
				nodepath = get(jsonObject, "nodepath");
				namepath = get(jsonObject, "namepath");
				charindex = get(jsonObject, "charindex");
				level = get(jsonObject, "level");
				orderby = get(jsonObject, "orderby");
				checkflag = get(jsonObject, "checkflag");

				log_i(toString());
			} catch (JSONException e) {
				throw new DataParseException(e);
			}
		}
	}
	
	public String getCheckflag() {
		return checkflag;
	}

	public DistrictInfor(String id, String name, String parentid, String nodepath, 
			String namepath, String charindex, String level, String orderby) {
		this.id = id;
		this.name = name;
		this.parentid = parentid;
		this.nodepath = nodepath;
		this.namepath = namepath;
		this.charindex = charindex;
		this.level = level;
		this.orderby = orderby;
	}

	@Override
	public String toString() {
		return "DistrictInfor [id=" + id + ", name=" + name + ", parentid="
				+ parentid + ", nodepath=" + nodepath + ", namepath="
				+ namepath + ", charindex=" + charindex + ", level=" + level
				+ ", orderby=" + orderby + ", checkflag=" + checkflag + "]";
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getParentid() {
		return parentid;
	}

	public String getNodepath() {
		return nodepath;
	}

	public String getNamepath() {
		return namepath;
	}

	public String getCharindex() {
		return charindex;
	}

	public String getLevel() {
		return level;
	}

	public String getOrderby() {
		return orderby;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
}
