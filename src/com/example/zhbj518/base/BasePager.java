package com.example.zhbj518.base;




import com.example.zhbj518.R;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * 5����ҳ��Ļ���
 * @author Administrator
 *
 */
public class BasePager {
	
	public Activity mActivity;
	public View mRootView;//���ֶ���
	public TextView tvTitle;
	public FrameLayout flcontent;
	
	public BasePager(Activity activity) {
		mActivity = activity;
		initViews();//��ʼ������
	}
	
	public void initViews()
	{
		mRootView = View.inflate(mActivity, R.layout.base_pager, null);
		tvTitle = (TextView) mRootView.findViewById(R.id.tv_title);
		flcontent = (FrameLayout) mRootView.findViewById(R.id.fl_content);
	}
	
	public void initData()
	{
		
	}

	
}
