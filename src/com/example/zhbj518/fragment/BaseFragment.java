package com.example.zhbj518.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

	//方便子类调用
	public Activity mActivity;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		mActivity = getActivity();
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return initViews();
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		initData();
	}
	//初始化布局方法
	public abstract View initViews();
	
	
	//初始化数据
	public void initData()
	{
		
	}
	
}
