package com.hemaapp.demo.activity;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FadeInAnimator;
import jp.wasabeef.recyclerview.animators.FadeInDownAnimator;
import jp.wasabeef.recyclerview.animators.FadeInLeftAnimator;
import jp.wasabeef.recyclerview.animators.FadeInRightAnimator;
import jp.wasabeef.recyclerview.animators.FadeInUpAnimator;
import jp.wasabeef.recyclerview.animators.FlipInBottomXAnimator;
import jp.wasabeef.recyclerview.animators.FlipInLeftYAnimator;
import jp.wasabeef.recyclerview.animators.FlipInRightYAnimator;
import jp.wasabeef.recyclerview.animators.FlipInTopXAnimator;
import jp.wasabeef.recyclerview.animators.LandingAnimator;
import jp.wasabeef.recyclerview.animators.OvershootInLeftAnimator;
import jp.wasabeef.recyclerview.animators.OvershootInRightAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInBottomAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInLeftAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInRightAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInTopAnimator;
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInRightAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.adapter.SimpleAdapter;
import com.hemaapp.demo.adapter.SimpleAdapter.OnItemClickListener;
import com.hemaapp.demo.dialog.MyListViewDialog;
import com.hemaapp.demo.model.DialogItemModel;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

/**
 * 列表
 * @author Wen
 * @author HuFanglin
 *
 */
public class RecyclerViewActivityNew extends MyActivity {
	private final int LENGTH = 100;
	private RecyclerView recyclerView;
	private SimpleAdapter mAdapter;
	private List<DialogItemModel> listData ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_recylerview_new);
		super.onCreate(savedInstanceState);
		findView();
		setListener();
	}
	
	
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
        mAdapter = new SimpleAdapter(this, listDatas);
        recyclerView.setAdapter(mAdapter);
		 // 创建一个线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, 
        		LinearLayoutManager.VERTICAL, false);
        // 设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new FadeInLeftAnimator());
		
	}
	protected void setListener() 
	{
		
		mAdapter.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemLongClick(View view, int position) {
				
			}
			
			@Override
			public void onItemClick(View view, int position) {
				
			}
		});
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);  
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch (id) {
		case R.id.action_Add:
			mAdapter.addData(1);
			break;
		case R.id.action_Delete:
			mAdapter.removeData(1);
			break;
		case R.id.action_Change:
			changeItemAnimator();
			break;
		case R.id.action_GridView:
	        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
			break;
		case R.id.action_ListView:
	        recyclerView.setLayoutManager(new LinearLayoutManager(this));
			break;
		case R.id.action_Staggered:
			break;
		case R.id.action_HorizontalGridView:
	        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, 
	        		StaggeredGridLayoutManager.HORIZONTAL));
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void changeItemAnimator()
	{
		listData = new ArrayList<DialogItemModel>();
		listData.add(new DialogItemModel("FadeInAnimator", new FadeInAnimator()));
		listData.add(new DialogItemModel("FadeInDownAnimator", new FadeInDownAnimator()));
		listData.add(new DialogItemModel("FadeInLeftAnimator", new FadeInLeftAnimator()));
		listData.add(new DialogItemModel("FadeInDownAnimator", new FadeInDownAnimator()));
		listData.add(new DialogItemModel("FadeInRightAnimator", new FadeInRightAnimator()));
		listData.add(new DialogItemModel("FadeInUpAnimator", new FadeInUpAnimator()));
		listData.add(new DialogItemModel("FlipInBottomXAnimator", new FlipInBottomXAnimator()));
		listData.add(new DialogItemModel("FlipInLeftYAnimator", new FlipInLeftYAnimator()));
		listData.add(new DialogItemModel("FlipInRightYAnimator", new FlipInRightYAnimator()));
		listData.add(new DialogItemModel("FlipInTopXAnimator", new FlipInTopXAnimator()));
		listData.add(new DialogItemModel("LandingAnimator", new LandingAnimator()));
		listData.add(new DialogItemModel("OvershootInLeftAnimator", new OvershootInLeftAnimator()));
		listData.add(new DialogItemModel("OvershootInRightAnimator", new OvershootInRightAnimator()));
		listData.add(new DialogItemModel("ScaleInAnimator", new ScaleInAnimator()));
		listData.add(new DialogItemModel("ScaleInBottomAnimator", new ScaleInBottomAnimator()));
		listData.add(new DialogItemModel("ScaleInLeftAnimator", new ScaleInLeftAnimator()));
		listData.add(new DialogItemModel("ScaleInRightAnimator", new ScaleInRightAnimator()));
		listData.add(new DialogItemModel("ScaleInTopAnimator", new ScaleInTopAnimator()));
		listData.add(new DialogItemModel("SlideInDownAnimator", new SlideInDownAnimator()));
		listData.add(new DialogItemModel("SlideInLeftAnimator", new SlideInLeftAnimator()));
		listData.add(new DialogItemModel("SlideInRightAnimator", new SlideInRightAnimator()));
		listData.add(new DialogItemModel("SlideInUpAnimator", new SlideInUpAnimator()));
		final MyListViewDialog dialog = new MyListViewDialog(mContext, listData);
		dialog.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				recyclerView.setItemAnimator(listData.get(position).Animator);
				dialog.cancel();
			}
		});
		dialog.show();
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
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}
}

