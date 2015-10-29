package com.hemaapp.demo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.adapter.MyAdapter;
import com.hemaapp.demo.view.MyRecyclerView;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

/**
 * �б�
 * @author Wen
 * @author HuFanglin
 *
 */
public class RecyclerViewActivity extends MyActivity{
	private RecyclerView recyclerView;
	private TextView txtNext, txtTitle; 
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
		txtNext.setText("�˵�����");
		txtTitle = (TextView)findViewById(R.id.txtTitle);
		txtTitle.setText("RecyclerView");
		recyclerView = (RecyclerView)findViewById(R.id.recyclerview_vertical);
		 // ����һ�����Բ��ֹ�����
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // Ĭ����Vertical�����Բ�д
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        // ���ò��ֹ�����
        recyclerView.setLayoutManager(layoutManager);

        // �������ݼ�
        String[] dataset = new String[100];
        for (int i = 0; i < dataset.length; i++){
            dataset[i] = "item" + i;
        }
        // ����Adapter����ָ�����ݼ�
        MyAdapter adapter = new MyAdapter(dataset);
        // ����Adapter
        recyclerView.setAdapter(adapter);
	}

	@Override                                                                      
	protected void getExras() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setListener() {
		txtNext.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PopupMenu menu = new PopupMenu(mContext, txtNext);
				menu.getMenuInflater().inflate(R.menu.popup_menu, menu.getMenu());
				menu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem arg0) {
						// TODO Auto-generated method stub
						return true;
					}
				});
				menu.show();
			}
		});
		
	}

}
