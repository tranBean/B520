package com.example.zhbj518.impl;

import com.example.zhbj518.base.BasePager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

public class NewsCenImpl extends BasePager {

	public NewsCenImpl(Activity activity) {
		super(activity);
	}
	
	@Override
	public void initData() {
		setSlidingMenuEnable(true);
		tvTitle.setText("�˥�`�����󥿩`");
		
		TextView text = new TextView(mActivity);
		text.setTextColor(Color.RED);
		text.setTextSize(30);
		text.setGravity(Gravity.CENTER);
		text.setText("�˥�`��");
		
		flcontent.addView(text);
	}

}
