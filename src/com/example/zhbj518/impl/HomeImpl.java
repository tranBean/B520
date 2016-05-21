package com.example.zhbj518.impl;

import com.example.zhbj518.base.BasePager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

public class HomeImpl extends BasePager {

	public HomeImpl(Activity activity) {
		super(activity);
		
	}
	
	@Override
	public void initData() {
		tvTitle.setText("¥¹¥Þ©`¥È–|¾©");
		
		TextView text = new TextView(mActivity);
		text.setTextColor(Color.RED);
		text.setTextSize(30);
		text.setGravity(Gravity.CENTER);
		text.setText("¥Û©`¥à¥Ú©`¥¸");
		
		flcontent.addView(text);
	}

}
