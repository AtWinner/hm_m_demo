package com.hemaapp.demo.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.adapter.SimpleAdapter;
import com.hemaapp.demo.adapter.SimpleAdapter.OnItemClickListener;
import com.hemaapp.demo.adapter.StaggerAdapter;
import com.hemaapp.demo.util.DividerItemDecoration;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

/**
 * 列表
 * @author Wen
 * @author HuFanglin
 *
 */
public class RecyclerViewActivityStagger extends MyActivity{
	private final int LENGTH = 100;
	private RecyclerView recyclerView;
	private StaggerAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_recylerview_new);
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
		recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        // 创建数据集
        List<String> listDatas = new ArrayList<String>();
        for (int i = 0; i < LENGTH; i++){
        	if(i < 10)
        	{
            	listDatas.add("item0" + i);
        	}
        	else
        	{
            	listDatas.add("item" + i);
        	}
        }
        mAdapter = new StaggerAdapter(this, listDatas);
        recyclerView.setAdapter(mAdapter);
        // 设置布局管理器
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, 
        		StaggeredGridLayoutManager.VERTICAL));
        
	}
	@Override
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void setListener() {
		mAdapter.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemLongClick(View view, int position) {
				mAdapter.removeData(position);
				
			}
			
			@Override
			public void onItemClick(View view, int position) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);  
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		return super.onOptionsItemSelected(item);
	}

}