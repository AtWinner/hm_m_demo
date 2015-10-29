package com.hemaapp.demo.activity;

import com.example.hm_m_demo.R;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class CanvasActivity extends Activity {
    private ImageView mImageView;
    private ImageView mClipedImageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_canvas);
		init();
	}
	
    private void init(){
    	mImageView=(ImageView) findViewById(R.id.imageView);
    	mClipedImageView=(ImageView) findViewById(R.id.clipedImageView);
    	
    	testClip();
    
    }
    
    private void testClip(){
    	Bitmap bitmap=Bitmap.createBitmap(500,500, Config.ARGB_8888);
    	Canvas canvas=new Canvas(bitmap);
    	canvas.drawColor(Color.GREEN);
    	Paint paint=new Paint();
    	paint.setColor(Color.YELLOW);
    	canvas.drawText("��ɫ����ΪCanvas����ǰ������", 100, 250, paint);
    	
    	
    	Rect rect=new Rect(10,95,180,140);
    	canvas.clipRect(rect);
    	canvas.drawColor(Color.YELLOW);
    	paint.setColor(Color.BLACK);
    	//canvas���ú���ƵĶ���ֻ���ڲü�����ķ�Χ�ܲ�����ʾ����
    	canvas.drawText("��ɫ����ΪCanvas���к������", 10, 110, paint);
    	mImageView.setImageBitmap(bitmap);
    	
    	//��ʾ��ȡ���Bitmap:
    	Bitmap newBitmap=Bitmap.createBitmap(bitmap,10,95,170,45);
    	mClipedImageView.setImageBitmap(newBitmap);

    }
	


}
