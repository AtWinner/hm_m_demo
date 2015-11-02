/*
 * Copyright (C) 2014 The Android Client Of QK Project
 * 
 *     The BeiJing PingChuanJiaHeng Technology Co., Ltd.
 * 
 * Author:Yang ZiTian
 * You Can Contact QQ:646172820 Or Email:mail_yzt@163.com
 */
package com.hemaapp.demo;

import xtom.frame.XtomObject;
import xtom.frame.util.XtomSharedPreferencesUtil;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;

/**
 * ��λ
 */
public class MyLocation extends XtomObject implements AMapLocationListener,
		OnGeocodeSearchListener {
	private LocationManagerProxy mAMapLocationManager;
	private AMapLocation aMapLocation;
	private GeocodeSearch geocodeSearch;
	private static MyLocation location;

	private MyLocation() {
		MyApplication application = MyApplication.getInstance();
		geocodeSearch = new GeocodeSearch(application);
		geocodeSearch.setOnGeocodeSearchListener(this);
	}

	public static MyLocation getInstance() {
		if (location == null)
			location = new MyLocation();
		return location;
	}

	public void startLocation() {
		if (mAMapLocationManager == null) {
			MyApplication application = MyApplication.getInstance();
			mAMapLocationManager = LocationManagerProxy
					.getInstance(application);
		}
		// mAMapLocManager.setGpsEnable(false);//1.0.2�汾��������������true��ʾ��϶�λ�а���gps��λ��false��ʾ�����綨λ��Ĭ����true
		// Location API��λ����GPS�������϶�λ��ʽ��ʱ�������5000����
		mAMapLocationManager.requestLocationData(
				LocationProviderProxy.AMapNetwork, 5000, 10, this);
	}

	public void stopLocation() {
		if (mAMapLocationManager != null) {
			mAMapLocationManager.removeUpdates(this);
			mAMapLocationManager.destroy();
		}
		mAMapLocationManager = null;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLocationChanged(AMapLocation location) {
		aMapLocation = location;
		Double lat = location.getLatitude();
		Double lng = location.getLongitude();
		MyApplication application = MyApplication.getInstance();
		XtomSharedPreferencesUtil.save(application, "lat", lat.toString());
		XtomSharedPreferencesUtil.save(application, "lng", lng.toString());
		log_i("---------- lat = "+lat.toString());
		log_i("---------- lng = "+lng.toString());
		getAddress(lat, lng);
		sendBroadcast();
		stopLocation();
	}

	public void sendBroadcast() {
		MyApplication application = MyApplication.getInstance();
		String action = application.getPackageName() + ".location";
		log_i("action=" + action);
		Intent intent = new Intent();
		intent.setAction(action);
		// ���� һ������㲥
		application.sendBroadcast(intent);
	}

	// ��������
	private void getAddress(final Double mlat, final Double mLon) {
		LatLonPoint latLonPoint = new LatLonPoint(mlat, mLon);
		RegeocodeQuery query = new RegeocodeQuery(latLonPoint, 200,
				GeocodeSearch.AMAP);// ��һ��������ʾһ��Latlng���ڶ�������ʾ��Χ�����ף�������������ʾ�ǻ�ϵ����ϵ����GPSԭ������ϵ
		geocodeSearch.getFromLocationAsyn(query);// ����ͬ��������������
	}

	/**
	 * @return the aMapLocation
	 */
	public AMapLocation getaMapLocation() {
		return aMapLocation;
	}

	@Override
	public void onGeocodeSearched(GeocodeResult arg0, int arg1) {

	}

	@Override
	public void onRegeocodeSearched(RegeocodeResult result, int arg1) {
		if (result != null && result.getRegeocodeAddress() != null
				&& result.getRegeocodeAddress().getFormatAddress() != null) {
			String address = result.getRegeocodeAddress().getFormatAddress();
			MyApplication application = MyApplication.getInstance();
			XtomSharedPreferencesUtil.save(application, "address", address);
		} else {
			
		}
	}

}
