package com.hemaapp.demo.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Scroller;
import android.widget.TextView;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyFragmentActivity;
import com.hemaapp.demo.adapter.MyAdapter;
import com.hemaapp.demo.adapter.RecyclerViewAdapter;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

/**
 * �б�
 * @author Wen
 * @author HuFanglin
 *
 */
public class RecyclerViewActivity extends MyFragmentActivity{
	private final int LENGTH = 10;
	private RecyclerView recyclerView;
	private TextView txtNext, txtTitle; 
	private ViewPager viewPager;
	private MyAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_recyclerview);
		super.onCreate(savedInstanceState);
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
		txtNext = (TextView)findViewById(R.id.txtNext);
		txtNext.setText("�˵�");
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText("RecyclerView");
		viewPager = (ViewPager)findViewById(R.id.viewPager);
		viewPager.setAdapter(new RecyclerViewAdapter(getSupportFragmentManager(), LENGTH));
		recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
		 // ����һ�����Բ��ֹ�����
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // Ĭ����Vertical�����Բ�д
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        // ���ò��ֹ�����
        recyclerView.setLayoutManager(layoutManager);

        // �������ݼ�
        String[] dataset = new String[LENGTH];
        for (int i = 0; i < dataset.length; i++){
            dataset[i] = "item" + i;
        }
        // ����Adapter����ָ�����ݼ�
        adapter = new MyAdapter(dataset, recyclerView, viewPager);
        // ����Adapter
        recyclerView.setAdapter(adapter);
//        recyclerView.setscr
	}

	@Override                                                                      
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		viewPager.addOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				//recyclerView.scrollToPosition(position);
				recyclerView.smoothScrollToPosition(position);
				adapter.changeSelectPage(position);
			}
			
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
				recyclerView.scrollTo(1, 0);
				log_e("positionOffset" + positionOffset +", positionOffsetPixels" + positionOffsetPixels);
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}