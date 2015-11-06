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
		//Widget����Ļ�Ƴ�ʱ
		// TODO Auto-generated method stub
		super.onDeleted(context, appWidgetIds);
		context.stopService(new Intent(context, WidgetTimerService.class));
	}
	
	@Override
	public void onDisabled(Context context) {
		//���һ��������Ļ�Ƴ�
		// TODO Auto-generated method stub
		super.onDisabled(context);
		context.startService(new Intent(context, WidgetTimerService.class));
	}
	
	@Override
	public void onEnabled(Context context) {
		//��һ����ӵ���Ļ��ִ��
		
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
		//ˢ��widgetʱִ��
		// TODO Auto-generated method stub
		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}
}
