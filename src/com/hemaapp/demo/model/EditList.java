package com.hemaapp.demo.model;

import xtom.frame.XtomObject;

public class EditList extends XtomObject{
	private String content;
	private boolean isSelect;
	public String getContent() {
		return content;
	}
	public boolean isSelect() {
		return isSelect;
	}
	public void setIsSelect(boolean isSelect)
	{
		this.isSelect = isSelect;
	}
	public EditList(String content, boolean isSelect) {
		super();
		this.content = content;
		this.isSelect = isSelect;
	}
	
}
