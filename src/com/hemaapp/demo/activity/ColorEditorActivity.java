package com.hemaapp.demo.activity;

import com.example.hm_m_demo.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ColorEditorActivity extends Activity implements OnClickListener{
	
	char [] colorChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	
	private View colorView;
	private EditText decimalR, decimalG, decimalB, hexaDecimal;
	private Button decimalButton, hexadecimalButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_coloreditor);
		decimalR = (EditText)findViewById(R.id.decimalR);
		decimalG = (EditText)findViewById(R.id.decimalG);
		decimalB = (EditText)findViewById(R.id.decimalB);
		hexaDecimal = (EditText)findViewById(R.id.hexaDecimal);
		decimalButton = (Button)findViewById(R.id.decimalButton);
		decimalButton.setOnClickListener(this);
		hexadecimalButton = (Button)findViewById(R.id.hexadecimalButton);
		hexadecimalButton.setOnClickListener(this);
		colorView = findViewById(R.id.colorView);
	
	}

	@Override
	public void onClick(View v) {
		String RRR, GGG, BBB;
		int RR, GG, BB;
		switch (v.getId()) {
		case R.id.decimalButton:
			RRR = decimalR.getEditableText().toString();
			GGG = decimalG.getEditableText().toString();
			BBB = decimalB.getEditableText().toString();
			RR = isNull(RRR) ? 0 : Integer.parseInt(RRR);
			GG = isNull(GGG) ? 0 : Integer.parseInt(GGG);
			BB = isNull(RRR) ? 0 : Integer.parseInt(BBB);
			colorView.setBackgroundColor(Color.rgb(RR, GG, BB));
			break;
		case R.id.hexadecimalButton:
			clickHexaDecimal();
			break;
		}
	}
	
	private boolean isNull(String string)
	{
		if(string == null)
			return true;
		if("".equals(string))
			return true;
		return false;
	}
	/**
	 * 16进制
	 */
	private void clickHexaDecimal()
	{
		String colorString = hexaDecimal.getEditableText().toString().trim().toUpperCase();
		if(isNull(colorString))
		{
			colorView.setBackgroundColor(Color.BLACK);
			return;
		}
		int length = colorString.length();
		if(length != 3 && length != 4 && length != 6 && length != 8)
		{
			showToast("格式不对");
			return;
		}
		char [] realColor = colorString.toCharArray();
		for(int i = 0; i < length; i++)
		{
			boolean isIllegal = true;
			for(int j =0; j < colorChar.length; j++)
			{
				if(realColor[i] == colorChar[j])
				{
					isIllegal = false;
					break;
				}
			}
			if(isIllegal)
			{//非法
				showToast("格式不对");
				return;
			}
		}
		
		
		int alpha = 0;
		int RR = 0;
		int GG = 0;
		int BB = 0;
		
		switch (length) {
		case 3:
			for(int j =0; j < colorChar.length; j++)
			{
				if(realColor[0] == colorChar[j])
				{
					RR = j * 17;
					break;
				}
			}

			for(int j =0; j < colorChar.length; j++)
			{
				if(realColor[1] == colorChar[j])
				{
					GG = j * 17;
					break;
				}
			}

			for(int j =0; j < colorChar.length; j++)
			{
				if(realColor[2] == colorChar[j])
				{
					BB = j * 17;
					break;
				}
			}
			colorView.setBackgroundColor(Color.rgb(RR, GG, BB));
			break;
		case 4:
			for(int j =0; j < colorChar.length; j++)
			{
				if(realColor[0] == colorChar[j])
				{
					alpha = j * 17;
					break;
				}
			}
			
			for(int j =0; j < colorChar.length; j++)
			{
				if(realColor[1] == colorChar[j])
				{
					RR = j * 17;
					break;
				}
			}

			for(int j =0; j < colorChar.length; j++)
			{
				if(realColor[2] == colorChar[j])
				{
					GG = j * 17;
					break;
				}
			}

			for(int j =0; j < colorChar.length; j++)
			{
				if(realColor[3] == colorChar[j])
				{
					BB = j * 17;
					break;
				}
			}
			colorView.setBackgroundColor(Color.argb(alpha, RR, GG, BB));
			
			break;
		case 6:
			RR = Integer.parseInt(realColor[0] + realColor[1] +"", 16);
			GG = Integer.parseInt(realColor[2] + realColor[3] +"", 16);
			BB = Integer.parseInt(realColor[4] + realColor[5] +"", 16);
			colorView.setBackgroundColor(Color.rgb(RR, GG, BB));
			break;
		case 8:
			alpha = Integer.parseInt(realColor[0] + realColor[1] +"", 16);
			RR = Integer.parseInt(realColor[2] + realColor[3] +"", 16);
			GG = Integer.parseInt(realColor[4] + realColor[5] +"", 16);
			BB = Integer.parseInt(realColor[6] + realColor[7] +"", 16);
			colorView.setBackgroundColor(Color.argb(alpha, RR, GG, BB));
			
			break;

		default:
			break;
		}
	}
	
	private void showToast(String text)
	{
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
}
