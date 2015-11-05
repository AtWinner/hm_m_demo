package com.hemaapp.demo.activity;

import com.example.hm_m_demo.R;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MActionBarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_helloworld);
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setCustomView(R.layout.header_quit_text_text);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}
}
