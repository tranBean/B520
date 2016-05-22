package com.example.zhbj518.impl;

import com.example.zhbj518.base.BasePager;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SettingImpl extends BasePager {

	public SettingImpl(Activity activity) {
		super(activity);
	}
	
	@Override
	public void initData() {
		ibMenu.setVisibility(View.GONE);
		setSlidingMenuEnable(false);
		tvTitle.setText("»ùµAÔOÖÃ");
		
		TextView text = new TextView(mActivity);
		text.setTextColor(Color.RED);
		text.setTextSize(30);
		text.setGravity(Gravity.CENTER);
		text.setText("ÔOÖÃ");
		
		flcontent.addView(text);
	}

}
