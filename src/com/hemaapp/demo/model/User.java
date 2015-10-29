package com.hemaapp.demo.model;

import org.json.JSONException;
import org.json.JSONObject;

import xtom.frame.exception.DataParseException;

import com.hemaapp.hm_FrameWork.HemaUser;

/**
 * 用户信息(注意User信息必须继承HemaUser,并且User中不用再包含token字段)
 */
public class User extends HemaUser {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8412756093515557415L;
	private String id;
	private String username;
	private String email;
	private String password;
	private String nickname;
	private String charindex;
	private String sex;
	private String mobile;
	private String age;
	private String selfsign;
	private String avatar;
	private String birthday;
	private String avatarbig;
	private String backimg;
	private String address;
	private String onlineflag;
	private String validflag;
	private String vestflag;
	private String score;
	private String feeaccount;
	private String transaccount;
	private String lng;
	private String lat;
	private String deviceid;
	private String devicetype;
	private String channelid;
	private String lastloginversion;
	private String lastlogintime;
	private String content;
	private String delflag;
	private String regdate;
	private String ask1_id;
	private String answer1;
	private String ask2_id;
	private String answer2;
	private String ask3_id;
	private String answer3;
	private String aliuser;
	private String bankuser;
	private String bankname;
	private String bankcard;
	private String bankaddress;
	private String transflag;
	private String checkflag;
	private String role;
	


	public User(JSONObject jsonObject) throws DataParseException {
		super(jsonObject);
		if (jsonObject != null) {
			try {
				id = get(jsonObject, "id");
				username = get(jsonObject, "username");
				email = get(jsonObject, "email");
				password = get(jsonObject, "password");
				nickname = get(jsonObject, "nickname");
				charindex = get(jsonObject, "charindex");
				sex = get(jsonObject, "sex");
				mobile = get(jsonObject, "mobile");
				age = get(jsonObject, "age");
				selfsign = get(jsonObject, "selfsign");
				avatar = get(jsonObject, "avatar");
				birthday = get(jsonObject, "birthday");
				avatarbig = get(jsonObject, "avatarbig");
				backimg = get(jsonObject, "backimg");
				address = get(jsonObject, "address");
				onlineflag = get(jsonObject, "onlineflag");
				validflag = get(jsonObject, "validflag");
				vestflag = get(jsonObject, "vestflag");
				score = get(jsonObject, "score");
				feeaccount = get(jsonObject, "feeaccount");
				transaccount = get(jsonObject, "transaccount");
				lng = get(jsonObject, "lng");
				lat = get(jsonObject, "lat");
				deviceid = get(jsonObject, "deviceid");
				devicetype = get(jsonObject, "devicetype");
				channelid = get(jsonObject, "channelid");
				lastloginversion = get(jsonObject, "lastloginversion");
				lastlogintime = get(jsonObject, "lastlogintime");
				content = get(jsonObject, "content");
				delflag = get(jsonObject, "delflag");
				regdate = get(jsonObject, "regdate");
				ask1_id = get(jsonObject, "ask1_id");
				answer1 = get(jsonObject, "answer1");
				ask2_id = get(jsonObject, "ask2_id");
				answer2 = get(jsonObject, "answer2");
				ask3_id = get(jsonObject, "ask3_id");
				answer3 = get(jsonObject, "answer3");
				aliuser = get(jsonObject, "aliuser");
				bankuser = get(jsonObject, "bankuser");
				bankname = get(jsonObject, "bankname");
				bankcard = get(jsonObject, "bankcard");
				bankaddress = get(jsonObject, "bankaddress");
				transflag = get(jsonObject, "transflag");
				checkflag = get(jsonObject, "checkflag");
				role = get(jsonObject, "role");
				log_i(toString());
			} catch (JSONException e) {
				throw new DataParseException(e);
			}
		}
	}


	public User(String id, String username,
			String email, String password, String nickname, String charindex,
			String sex, String mobile, String age, String selfsign,
			String avatar, String birthday, String avatarbig, String backimg,
			String address, String onlineflag, String validflag,
			String vestflag, String score, String feeaccount, String lng,
			String lat, String deviceid, String devicetype, String channelid,
			String lastloginversion, String lastlogintime, String content,
			String delflag, String regdate, String ask1_id, String answer1,
			String ask2_id, String answer2, String ask3_id, String answer3,
			String aliuser, String bankuser, String bankname, String bankcard,
			String bankaddress, String transflag, String checkflag,
			String token, String role)
	{
		super(token);
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.charindex = charindex;
		this.sex = sex;
		this.mobile = mobile;
		this.age = age;
		this.selfsign = selfsign;
		this.avatar = avatar;
		this.birthday = birthday;
		this.avatarbig = avatarbig;
		this.backimg = backimg;
		this.address = address;
		this.onlineflag = onlineflag;
		this.validflag = validflag;
		this.vestflag = vestflag;
		this.score = score;
		this.feeaccount = feeaccount;
		this.lng = lng;
		this.lat = lat;
		this.deviceid = deviceid;
		this.devicetype = devicetype;
		this.channelid = channelid;
		this.lastloginversion = lastloginversion;
		this.lastlogintime = lastlogintime;
		this.content = content;
		this.delflag = delflag;
		this.regdate = regdate;
		this.ask1_id = ask1_id;
		this.answer1 = answer1;
		this.ask2_id = ask2_id;
		this.answer2 = answer2;
		this.ask3_id = ask3_id;
		this.answer3 = answer3;
		this.aliuser = aliuser;
		this.bankuser = bankuser;
		this.bankname = bankname;
		this.bankcard = bankcard;
		this.bankaddress = bankaddress;
		this.transflag = transflag;
		this.checkflag = checkflag;
		this.role = role;
	}


	public String getId() {
		return id;
	}


	public String getUsername() {
		return username;
	}


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}


	public String getNickname() {
		return nickname;
	}


	public String getCharindex() {
		return charindex;
	}


	public String getSex() {
		return sex;
	}


	public String getMobile() {
		return mobile;
	}


	public String getAge() {
		return age;
	}


	public String getSelfsign() {
		return selfsign;
	}


	public String getAvatar() {
		return avatar;
	}


	public String getBirthday() {
		return birthday;
	}


	public String getAvatarbig() {
		return avatarbig;
	}


	public String getBackimg() {
		return backimg;
	}


	public String getAddress() {
		return address;
	}


	public String getOnlineflag() {
		return onlineflag;
	}


	public String getValidflag() {
		return validflag;
	}


	public String getVestflag() {
		return vestflag;
	}


	public String getScore() {
		return score;
	}


	public String getFeeaccount() {
		return feeaccount;
	}

	public String getTransaccount()
	{
		return transaccount;
	}
	
	public String getLng() {
		return lng;
	}


	public String getLat() {
		return lat;
	}


	public String getDeviceid() {
		return deviceid;
	}


	public String getDevicetype() {
		return devicetype;
	}


	public String getChannelid() {
		return channelid;
	}


	public String getLastloginversion() {
		return lastloginversion;
	}


	public String getLastlogintime() {
		return lastlogintime;
	}


	public String getContent() {
		return content;
	}


	public String getDelflag() {
		return delflag;
	}


	public String getRegdate() {
		return regdate;
	}


	public String getAsk1_id() {
		return ask1_id;
	}


	public String getAnswer1() {
		return answer1;
	}


	public String getAsk2_id() {
		return ask2_id;
	}


	public String getAnswer2() {
		return answer2;
	}


	public String getAsk3_id() {
		return ask3_id;
	}


	public String getAnswer3() {
		return answer3;
	}


	public String getAliuser() {
		return aliuser;
	}


	public String getBankuser() {
		return bankuser;
	}


	public String getBankname() {
		return bankname;
	}


	public String getBankcard() {
		return bankcard;
	}


	public String getBankaddress() {
		return bankaddress;
	}


	public String getTransflag() {
		return transflag;
	}


	public String getCheckflag() {
		return checkflag;
	}


	public String getRole() {
		return role;
	}
	
	public void setUserName(String UserName)
	{
		username = UserName;
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email
				+ ", password=" + password + ", nickname=" + nickname
				+ ", charindex=" + charindex + ", sex=" + sex + ", mobile="
				+ mobile + ", age=" + age + ", selfsign=" + selfsign
				+ ", avatar=" + avatar + ", birthday=" + birthday
				+ ", avatarbig=" + avatarbig + ", backimg=" + backimg
				+ ", address=" + address + ", onlineflag="
				+ onlineflag + ", validflag=" + validflag + ", vestflag="
				+ vestflag + ", score=" + score + ", feeaccount=" + feeaccount
				+ ", lng=" + lng + ", lat=" + lat + ", deviceid=" + deviceid
				+ ", devicetype=" + devicetype + ", channelid=" + channelid
				+ ", lastloginversion=" + lastloginversion + ", lastlogintime="
				+ lastlogintime + ", content=" + content + ", delflag="
				+ delflag + ", regdate=" + regdate + ", ask1_id=" + ask1_id
				+ ", answer1=" + answer1 + ", ask2_id=" + ask2_id
				+ ", answer2=" + answer2 + ", ask3_id=" + ask3_id
				+ ", answer3=" + answer3 + ", aliuser=" + aliuser
				+ ", bankuser=" + bankuser + ", bankname=" + bankname
				+ ", bankcard=" + bankcard + ", bankaddress=" + bankaddress
				+ ", transflag=" + transflag + ", checkflag=" + checkflag
				+ ", role=" + role+ "]";
	}




}
