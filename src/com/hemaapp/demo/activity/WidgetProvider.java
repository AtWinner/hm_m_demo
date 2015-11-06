package com.hemaapp.demo.activity;

import com.hemaapp.demo.service.WidgetTimerService;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

public class WidgetProvider extends AppWidgetProvider
{
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		//Widget从屏幕移除时
		// TODO Auto-generated method stub
		super.onDeleted(context, appWidgetIds);
		context.stopService(new Intent(context, WidgetTimerService.class));
	}
	
	@Override
	public void onDisabled(Context context) {
		//最后一个被从屏幕移除
		// TODO Auto-generated method stub
		super.onDisabled(context);
		context.startService(new Intent(context, WidgetTimerService.class));
	}
	
	@Override
	public void onEnabled(Context context) {
		//第一个添加到屏幕上执行
		
		// TODO Auto-generated method stub
		super.onEnabled(context);
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
	}
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		//刷新widget时执行
		// TODO Auto-generated method stub
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}
}
