package com.hemaapp.demo.activity;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.fragment.ListViewFragment;
import com.hemaapp.demo.view.FadingActionBarHelper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

@SuppressLint("NewApi")
public class HeadListviewActivity extends Activity {
    private View layoutHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_listview);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ListViewFragment())
                    .commit();
        }
        layoutHeader = findViewById(R.id.layoutHeader);
        layoutHeader.setAlpha(0);
    }
    public View getHeader()
    {
    	return layoutHeader;
    }
    
    public int getHeaderHeight()
    {
    	int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        layoutHeader.measure(w, h);
        return layoutHeader.getMeasuredHeight();
    }

}
