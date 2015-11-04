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
import com.hemaapp.demo.adapter.StaggerAdapter;
import com.hemaapp.demo.adapter.StaggerAdapter.OnItemClickListener;
import com.hemaapp.demo.model.StaggerModel;
import com.hemaapp.demo.util.DividerItemDecoration;
import com.hemaapp.demo.view.MyStaggerRecyclerView;
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
	private MyStaggerRecyclerView recyclerView;
	private StaggerAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_recylerview_stagger);
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
		recyclerView = (MyStaggerRecyclerView)findViewById(R.id.recyclerview);

        // 创建数据集
        List<StaggerModel> listDatas = new ArrayList<StaggerModel>();
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/keep-calm-and-carry-on_143411.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/keep-calm-and-carry-on_143376.jpg","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/keep-calm-and-carry-on_1423461.jpg","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/keep-calm-and-carry-on_083060.jpg","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/bag0.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/bag1.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/bag2.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/bag3.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852512050.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852512138.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852512201.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852512386.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852512400.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852512493.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852512536.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852512648.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852512695.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852512700.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852512758.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852512867.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852512938.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852512958.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852512987.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852513031.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852513058.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852513332.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852513389.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852513415.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852513699.png","item00"));
    	listDatas.add(new StaggerModel("http://7tszkm.com1.z0.glb.clouddn.com/201510130852513998.png","item00"));
    	
        for (int i = 0; i < LENGTH; i++){
            	listDatas.add(new StaggerModel("http://p3.pstatp.com/large/9144/2820388969","item" + i));
        	
        }
        mAdapter = new StaggerAdapter(this, listDatas, recyclerView);
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