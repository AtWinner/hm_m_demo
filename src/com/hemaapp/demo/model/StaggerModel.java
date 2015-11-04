package com.hemaapp.demo.model;

import xtom.frame.XtomObject;
/**
 * 瀑布流简单模型
 * @author Wen
 * @author HuFanglin
 *
 */
public class StaggerModel extends XtomObject 
{
	private String url;
	private String name;
	public String getUrl() {
		return url;
	}
	public String getName() {
		return name;
	}
	public StaggerModel(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}
	
}
