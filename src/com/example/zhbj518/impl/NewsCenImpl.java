package com.example.zhbj518.impl;

import com.example.zhbj518.base.BasePager;
import com.example.zhbj518.beans.NewsData;
import com.example.zhbj518.utils.GlobelConnector;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

public class NewsCenImpl extends BasePager {

	public NewsCenImpl(Activity activity) {
		super(activity);
	}
	
	@Override
	public void initData() {
		setSlidingMenuEnable(true);
		tvTitle.setText("ニュースセンター");
		
		TextView text = new TextView(mActivity);
		text.setTextColor(Color.RED);
		text.setTextSize(30);
		text.setGravity(Gravity.CENTER);
		text.setText("ニュース");
		
		flcontent.addView(text);
		
		getDataFromServer();
	}

	private void getDataFromServer() {
		
		HttpUtils connUtil = new HttpUtils();
		connUtil.send(HttpMethod.GET, GlobelConnector.GLOBEL_URL,new RequestCallBack<String>() {

			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				String result = (String)responseInfo.result;
				 System.out.println("服务器数据进入"+result);
				 
				 parseData(result);
			}

			@Override
			public void onFailure(HttpException error, String msg) {
				Toast.makeText(mActivity, msg, 0).show();
				error.printStackTrace();
			}
		});
	}

	protected void parseData(String result) {
		Gson gson = new Gson();
		NewsData newsData = gson.fromJson(result, NewsData.class);
		
	}

}
