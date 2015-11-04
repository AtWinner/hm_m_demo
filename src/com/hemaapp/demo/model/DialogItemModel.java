package com.hemaapp.demo.model;

import jp.wasabeef.recyclerview.animators.BaseItemAnimator;


public class DialogItemModel
{
	public String Text;
	public BaseItemAnimator Animator;
	public DialogItemModel(String Text, BaseItemAnimator Animator)
	{
		this.Animator = Animator;
		this.Text = Text;
	}
}