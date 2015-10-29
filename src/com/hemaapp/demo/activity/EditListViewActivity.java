package com.hemaapp.demo.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.adapter.EditListAdapter;
import com.hemaapp.demo.model.EditList;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;

/**
 * 尝试可编辑的列表
 * @author Wen
 * @author HuFanglin
 *
 */
public class EditListViewActivity extends MyActivity{
	private ListView listview;
	private ImageView imageQuitActivity;
	private TextView txtTitle, txtNext;
	private EditListAdapter adapter;
	private List<EditList> listData;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_edit_listview);
		super.onCreate(savedInstanceState);
		listData = new ArrayList<EditList>();
		for(int i = 0; i < 100; i++)
		{
			listData.add(new EditList("It's the testing content of the editable listview. "
					+ "The important thing should be long enough! " + (i + 1), false));
		}
		adapter = new EditListAdapter(mContext, listview, listData);
		listview.setAdapter(adapter);
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
		listview = (ListView)findViewById(R.id.listview);
		imageQuitActivity = (ImageView)findViewById(R.id.imageQuitActivity);
		txtTitle = (TextView)findViewById(R.id.txtTitle); 
		txtTitle.setText("可编辑的列表");
		txtNext = (TextView)findViewById(R.id.txtNext);
		txtNext.setText("编辑");
		
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
				String nextText = adapter.GetEdit() ? "编辑" : "完成";
				txtNext.setText(nextText);
				adapter.SetIsEdit(!adapter.GetEdit());
				for(EditList item : listData)
				{
					item.setIsSelect(false);
				}
				adapter.notifyDataSetChanged();
				
			}
		});
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if(adapter.GetEdit())
				{
					listData.get(position).setIsSelect(!listData.get(position).isSelect());
					adapter.notifyDataSetChanged();
				}
				else
				{
					showTextDialog(position + ""); 
				}
			}
		});
		imageQuitActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish(R.anim.none, R.anim.right_out);
			}
		});
	}
	
	
	@Override
	protected boolean onKeyBack() {
		finish(R.anim.none, R.anim.right_out);
		return super.onKeyBack();
	}
	

}
