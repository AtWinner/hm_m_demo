package com.hemaapp.demo.adapter;

import com.hemaapp.demo.fragment.RecyclerViewFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class RecyclerViewAdapter extends FragmentPagerAdapter {
	private FragmentManager fm;
	private int Count;
	
	public RecyclerViewAdapter(FragmentManager fm, int Count) {
		super(fm);
		this.Count = Count;
	}

	@Override
	public Fragment getItem(int position) {
		return new RecyclerViewFragment();
	}

	@Override
	public int getCount() {
		return Count;
	}

}
