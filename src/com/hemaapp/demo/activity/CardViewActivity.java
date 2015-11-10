package com.hemaapp.demo.activity;

import cn.pedant.SweetAlert.SweetAlertDialog;

import com.example.hm_m_demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.View.OnClickListener;

public class CardViewActivity extends Activity{

	private CardView card_view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_cardview);
		super.onCreate(savedInstanceState);
		init();
	}
	
	private void init()
	{
		card_view = (CardView)findViewById(R.id.card_view);
		card_view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				SweetAlertDialog dialog = new SweetAlertDialog(CardViewActivity.this, SweetAlertDialog.NORMAL_TYPE);
				dialog.setTitle("บวบว");
				dialog.show();
				
			}
		});
	}
	
}
