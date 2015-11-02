package com.hemaapp.demo.activity;

import java.util.Random;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.VerticalViewPager.PagerAdapter;
import com.hemaapp.demo.VerticalViewPager.VerticalViewPager;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class VerticalViewPagerActivity extends Activity {
	private VerticalViewPager verticalViewPager;
	private Random mRandom = new Random();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_verticalviewpager);
		super.onCreate(savedInstanceState);
		verticalViewPager = (VerticalViewPager) findViewById(R.id.verticalViewPager);
		verticalViewPager.setAdapter(new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View view, Object object) {
				// TODO Auto-generated method stub
				return view == object;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 2;
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				Log.d("", "instantiateItem:" + position);
				TextView tv = new TextView(VerticalViewPagerActivity.this);
				tv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
						LayoutParams.MATCH_PARENT));
				tv.setGravity(Gravity.CENTER);
				tv.setTextSize(30);
				tv.setBackgroundColor(Color.rgb(mRandom.nextInt(255),
						mRandom.nextInt(255), mRandom.nextInt(255)));
				tv.setTextColor(Color.WHITE);
				tv.setText("Pager: " + position);
				container.addView(tv);
				View convertView = LayoutInflater.from(VerticalViewPagerActivity.this).inflate(R.layout.activity_main, null);

				container.addView(convertView);

				return tv;
			} 
			
			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				// TODO Auto-generated method stub
				super.destroyItem(container, position, object);
				container.removeView((View) object);
			}
		});
	}
	
	private class mPagerAdapter extends PagerAdapter
	{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
}
