package com.hemaapp.demo.activity;

import java.util.List;

import xtom.frame.view.XtomRefreshLoadmoreLayout;
import xtom.frame.view.XtomRefreshLoadmoreLayout.OnStartListener;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyFragmentActivity;
import com.hemaapp.demo.fragment.RecyclerViewFragment;
import com.hemaapp.demo.fragment.TestFragment;
import com.hemaapp.demo.fragment.TestFragment2;
import com.hemaapp.demo.fragment.TestFragment3;
import com.hemaapp.demo.fragment.TestFragment4;
import com.hemaapp.demo.view.MySwitchLoadLayout;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

public class FragmentManagerActivity extends MyFragmentActivity implements OnClickListener
{
	private FrameLayout frameLayout;
	private Fragment fragmentContent1, fragmentContent2;
	private MySwitchLoadLayout mySwitchLoadLayout;
	private FragmentTransaction transaction;
	private Button btnPage1, btnPage2, btnPage3, btnPage4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_fragmentmanager);
		super.onCreate(savedInstanceState);
		ChangeFragment(TestFragment.class);

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
		frameLayout = (FrameLayout)findViewById(R.id.frameLayout);
		mySwitchLoadLayout = (MySwitchLoadLayout)findViewById(R.id.mySwitchLoadLayout);
		btnPage1 = (Button)findViewById(R.id.btnPage1);
		btnPage2 = (Button)findViewById(R.id.btnPage2);
		btnPage3 = (Button)findViewById(R.id.btnPage3);
		btnPage4 = (Button)findViewById(R.id.btnPage4);
	}

	@Override
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		btnPage1.setOnClickListener(this);
		btnPage2.setOnClickListener(this);
		btnPage3.setOnClickListener(this);
		btnPage4.setOnClickListener(this);
		
	}
	public void ChangeFragment(Class<? extends Fragment> c) {
		FragmentManager manager = getSupportFragmentManager();
		String tag = c.getName();
		FragmentTransaction transaction = manager.beginTransaction();
		Fragment fragment = manager.findFragmentByTag(tag);

		if (fragment == null) {
			try {
				fragment = c.newInstance();
				// 替换时保留Fragment,以便复用
				transaction.add(R.id.frameLayout, fragment, tag);
			} catch (Exception e) {
			}
		} else {
		}

		// 遍历存在的Fragment,隐藏其他Fragment
		List<Fragment> fragments = manager.getFragments();
		if (fragments != null)
			for (Fragment fm : fragments)
				if (!fm.equals(fragment))
					transaction.hide(fm);
		transaction.show(fragment);
		transaction.commit();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnPage1:
			ChangeFragment(TestFragment.class);
			
			break;
		case R.id.btnPage2:
			ChangeFragment(TestFragment2.class);
			
			break;
		case R.id.btnPage3:
			ChangeFragment(TestFragment3.class);
			
			break;
		case R.id.btnPage4:
			ChangeFragment(TestFragment4.class);
			
			break;

		default:
			break;
		}
		
	}

}
