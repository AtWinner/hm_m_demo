package com.hemaapp.demo.dialog;


import com.example.hm_m_demo.R;

import xtom.frame.XtomObject;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


public class MyTwoVertivalButtonDialog extends XtomObject {
	private Context context;
	private Dialog mDialog;
	private Button btnUp;
	private Button btnBottom;
	private OnButtonListener buttonListener;

	public MyTwoVertivalButtonDialog(Context context) {
		this.context = context;
		mDialog = new Dialog(context, R.style.dialog);
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.dialog_vertical_two_botton, null);
		btnUp = (Button) view.findViewById(R.id.btnUp);
		btnUp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (buttonListener != null)
					buttonListener.onUpButtonClick(MyTwoVertivalButtonDialog.this);
			}
		});
		btnBottom = (Button) view.findViewById(R.id.btnBottom);
		btnBottom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (buttonListener != null)
					buttonListener.onBottomButtonClick(MyTwoVertivalButtonDialog.this);
			}
		});
		mDialog.setCancelable(true);
		mDialog.setContentView(view);
	}
	/**
	 * 设置是否可以取消
	 * @param cancelable
	 */
	public void setCancelable(boolean cancelable)
	{
		mDialog.setCancelable(cancelable);
	}
	
	public void setUpButtonText(String text) {
		btnUp.setText(text);
	}

	public void setUpButtonText(int textID) {
		btnUp.setText(textID);
	}

	public void setBottomButtonText(String text) {
		btnBottom.setText(text);
	}

	public void setBottomButtonText(int textID) {
		btnBottom.setText(textID);
	}

	public void setBottomButtonTextColor(int color) {
		btnBottom.setTextColor(color);
	}

	public void show() {
		mDialog.show();

		WindowManager windowManager = ((Activity)context).getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		WindowManager.LayoutParams lp = mDialog.getWindow().getAttributes();
		lp.width = (int)(display.getWidth() * 10 / 11); //设置宽度
		mDialog.getWindow().setAttributes(lp);
	}

	public void cancel() {
		mDialog.cancel();
	}

	public OnButtonListener getButtonListener() {
		return buttonListener;
	}

	public void setButtonListener(OnButtonListener buttonListener) {
		this.buttonListener = buttonListener;
	}

	public interface OnButtonListener {
		public void onUpButtonClick(MyTwoVertivalButtonDialog dialog);

		public void onBottomButtonClick(MyTwoVertivalButtonDialog dialog);
	}

}
