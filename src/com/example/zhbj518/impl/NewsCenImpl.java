package com.example.zhbj518.impl;

import java.util.ArrayList;

import com.example.zhbj518.MainActivity;
import com.example.zhbj518.MenuDetailPagerImpl.InteractDetailPagerImpl;
import com.example.zhbj518.MenuDetailPagerImpl.NewsDetailPagerImpl;
import com.example.zhbj518.MenuDetailPagerImpl.PhotoDetailPagerImpl;
import com.example.zhbj518.MenuDetailPagerImpl.TopDetailPagerImpl;
import com.example.zhbj518.base.BaseMenuDetailPager;
import com.example.zhbj518.base.BasePager;
import com.example.zhbj518.beans.NewsData;
import com.example.zhbj518.fragment.LeftMenuFragment;
import com.example.zhbj518.utils.GlobelConnector;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class NewsCenImpl extends BasePager {
	
	NewsData newsData;
	ArrayList<BaseMenuDetailPager> mArrayList;
	
	public NewsCenImpl(Activity activity) {
		super(activity);
	}
	
	@Override
	public void initData() {
		setSlidingMenuEnable(true);						
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
				System.out.println("服务器超时 ！！！！！！！");
				Toast.makeText(mActivity, msg, 0).show();
				error.printStackTrace();
			}
		});
	}

	protected void parseData(String result) {
		Gson gson = new Gson();
		newsData = gson.fromJson(result, NewsData.class);
		setDataToLeftFragment(newsData);
	}
	
	
	public void setDataToLeftFragment(NewsData newsData)
	{//刷新侧边栏数据
		MainActivity mainUi = (MainActivity)mActivity;
		mainUi.getLeftMenuFragment().setNewsData(newsData);	
		
	 //准备四个菜单详情页
		mArrayList = new ArrayList<BaseMenuDetailPager>();
		mArrayList.add(new NewsDetailPagerImpl(mActivity,newsData.data.get(0).children));
		mArrayList.add(new TopDetailPagerImpl(mActivity));
		mArrayList.add(new PhotoDetailPagerImpl(mActivity));
		mArrayList.add(new InteractDetailPagerImpl(mActivity));
	 //默认首页	
		setCurrentMenuDetailPager(0);
	}
	
	public void setCurrentMenuDetailPager(int position)
	{
		BaseMenuDetailPager mPager = mArrayList.get(position);
		flcontent.removeAllViews();
		flcontent.addView(mPager.mRootView);	
		//设置当前页面标题
		tvTitle.setText(newsData.data.get(position).title);
		
		mPager.initData();
	}
	
	
	
	

}
