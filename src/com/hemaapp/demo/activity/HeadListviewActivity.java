package com.hemaapp.demo.activity;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.fragment.ListViewFragment;
import com.hemaapp.demo.view.FadingActionBarHelper;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

@SuppressLint("NewApi")
public class HeadListviewActivity extends MyActivity implements OnClickListener{
	private ImageView imageQuitActivity;
    private View layoutHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_head_listview);
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ListViewFragment())
                    .commit();
        }
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
	@Override
	protected void callBeforeDataBack(HemaNetTask netTask) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void callAfterDataBack(HemaNetTask netTask) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void callBackForServerSuccess(HemaNetTask netTask,
			HemaBaseResult baseResult) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void callBackForServerFailed(HemaNetTask netTask,
			HemaBaseResult baseResult) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void callBackForGetDataFailed(HemaNetTask netTask, int failedType) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void findView() {
        layoutHeader = findViewById(R.id.layoutHeader);
        imageQuitActivity = (ImageView)findViewById(R.id.imageQuitActivity);
	}
	@Override
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void setListener() {
		imageQuitActivity.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageQuitActivity:
			finish(R.anim.left_in, R.anim.right_out); 
			break;

		default:
			break;
		}
	}
	
	@Override
	protected boolean onKeyBack() {
		finish(R.anim.left_in, R.anim.right_out); 
		return super.onKeyBack();
	}
}
