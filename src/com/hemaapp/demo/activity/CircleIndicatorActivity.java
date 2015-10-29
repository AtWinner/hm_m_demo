package com.hemaapp.demo.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.view.CircleIndicator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class CircleIndicatorActivity extends Activity
{
    private List<View> viewList;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_circle_indicator);
		super.onCreate(savedInstanceState);
		initData();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);

        circleIndicator = (CircleIndicator) findViewById(R.id.indicator);
        circleIndicator.setViewPager(viewPager);
	}

    private void initData(){
        viewList = new ArrayList<View>();
        Random random = new Random();
        for(int i=0;i<5;i++){
            View view = new View(this);
            view.setBackgroundColor(0xff000000| random.nextInt(0x00ffffff));
            viewList.add(view);
        }
    }

    PagerAdapter pagerAdapter = new PagerAdapter() {

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {

            return arg0 == arg1;
        }

        @Override
        public int getCount() {

            return viewList.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position,
                                Object object) {
            container.removeView(viewList.get(position));

        }

        @Override
        public int getItemPosition(Object object) {

            return super.getItemPosition(object);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return "title";
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));

            return viewList.get(position);
        }

    };
}
