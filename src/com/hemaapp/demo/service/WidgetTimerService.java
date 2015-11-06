package com.hemaapp.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.activity.WidgetProvider;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;
import android.widget.TextView;

public class WidgetTimerService extends Service {
	public Timer timer;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				updateViews();
				
			}
		}, 0, 1000);
	}
	private void updateViews()
	{
		String time = sdf.format(new Date());
		RemoteViews rv = new RemoteViews(getPackageName(), R.layout.widget);
//		TextView textView = (TextView)r
		rv.setTextViewText(R.id.textView, time);
		AppWidgetManager manager = AppWidgetManager.getInstance(this);
		
		ComponentName cn = new ComponentName(this, WidgetProvider.class);
		manager.updateAppWidget(cn, rv);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		timer = null;
	}
}
