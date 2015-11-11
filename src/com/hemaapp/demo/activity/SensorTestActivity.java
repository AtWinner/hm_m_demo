package com.hemaapp.demo.activity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import cn.pedant.SweetAlert.SweetAlertDialog;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.util.FileHelper;

import android.app.Activity;
import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;

public class SensorTestActivity extends Activity implements SensorEventListener {
	private TextView textView, textViewX, textViewY, textViewZ;
	private SensorManager sensorManager;
	private Vibrator vibrator;
	private ToggleButton toggleButton;
	private String logString = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_sensor);
		super.onCreate(savedInstanceState);
		textView = (TextView) findViewById(R.id.textView);
		textViewX = (TextView) findViewById(R.id.textViewX);
		textViewY = (TextView) findViewById(R.id.textViewY);
		textViewZ = (TextView) findViewById(R.id.textViewZ);
		toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
		toggleButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					logString = "";
				} else {
					// writeFileSdcard("sensorLog.txt", logString);
					String fileName = "sensorLog.txt";
					FileHelper fileHelper = new FileHelper(
							SensorTestActivity.this);
					fileHelper.deleteSDFile(fileName);
					try {
						fileHelper.createSDFile(fileName);
						fileHelper.writeSDFile(logString, fileName);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
						SweetAlertDialog dialog = new SweetAlertDialog(SensorTestActivity.this, SweetAlertDialog.SUCCESS_TYPE);
						dialog.setTitleText("已经写入日志");
						dialog.setContentText(fileName);
						dialog.show();
					}
				}
			}
		});
	}

	@Override
	protected void onPause() {
		super.onPause();
		sensorManager.unregisterListener(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		sensorManager.registerListener(this,
				sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		int sensorType = event.sensor.getType();
		// values[0]:X轴，values[1]：Y轴，values[2]：Z轴
		float[] values = event.values;Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String time=format.format(date);
		if (sensorType == Sensor.TYPE_ACCELEROMETER && toggleButton.isChecked()) {
			logString += "(" + values[0] + "," + values[1] + "," + values[2]
					+ ")" + time +" \n";
			textViewX.setText("X:" + values[0]);
			textViewY.setText("Y:" + values[1]);
			textViewZ.setText("Z:" + values[2]);
			Log.e("sensor (x, y, z) ", values[0] + "," + values[1] + ","
					+ values[2]);
			if ((Math.abs(values[0]) > 17 || Math.abs(values[1]) > 17 || Math
					.abs(values[2]) > 17)) {
				textView.setText("摇一摇成功!!!");
				// 摇动手机后，再伴随震动提示~~
				vibrator.vibrate(500);
			}
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// 当传感器精度改变时回调该方法
	}
}
