package com.example.zhbj518.impl;

import com.example.zhbj518.base.BasePager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

public class SmartSerImpl extends BasePager {

	public SmartSerImpl(Activity activity) {
		super(activity);
	}
	
	@Override
	public void initData() {
		tvTitle.setText("���ީ`�ȥ��`�ӥ�");
		
		TextView text = new TextView(mActivity);
		text.setTextColor(Color.RED);
		text.setTextSize(30);
		text.setGravity(Gravity.CENTER);
		text.setText("���`�ӥ�");
		
		flcontent.addView(text);
	}

}
