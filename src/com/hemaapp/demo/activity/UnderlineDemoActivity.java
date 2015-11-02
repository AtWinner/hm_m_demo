package com.hemaapp.demo.activity;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.fragment.TestFragment;
import com.hemaapp.demo.viewpagerindicator.PageIndicator;
import com.hemaapp.demo.viewpagerindicator.UnderlinePageIndicator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class UnderlineDemoActivity extends FragmentActivity
{
	private PageIndicator mIndicator;
	private ViewPager viewPager;
	private UnderlinePageIndicator underlinePageIndicator;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_underlines);
		super.onCreate(savedInstanceState);
		viewPager = (ViewPager)findViewById(R.id.viewPager);
		underlinePageIndicator = (UnderlinePageIndicator)findViewById(R.id.underlinePageIndicator);
		viewPager.setAdapter(new mAdapter(getSupportFragmentManager()));
		underlinePageIndicator.setViewPager(viewPager);
	}
	
	private class mAdapter extends FragmentPagerAdapter
	{
	    protected final String[] CONTENT = new String[] { "This", "Is", "A", "Test", "บวบว"};

		public mAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {
			return TestFragment.newInstance(CONTENT[position % CONTENT.length]);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return CONTENT.length;
		}
		
	}
}
