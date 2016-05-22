package com.example.zhbj518.base;




import com.example.zhbj518.MainActivity;
import com.example.zhbj518.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * 5个子页面的基类
 * @author Administrator
 *
 */
public class BasePager {
	
	public Activity mActivity;
	public View mRootView;//布局对象
	public TextView tvTitle;
	public FrameLayout flcontent;
	public ImageButton ibMenu;
	
	public BasePager(Activity activity) {
		mActivity = activity;
		initViews();//初始化布局
	}
	
	public void initViews()
	{
		mRootView = View.inflate(mActivity, R.layout.base_pager, null);
		tvTitle = (TextView) mRootView.findViewById(R.id.tv_title);
		flcontent = (FrameLayout) mRootView.findViewById(R.id.fl_content);
		ibMenu = (ImageButton) mRootView.findViewById(R.id.ib_menu);
	}
	
	public void initData()
	{
		
	}
	
	public void setSlidingMenuEnable(boolean enable)
	{
		MainActivity mainUi = (MainActivity)mActivity;
		SlidingMenu slidingMenu = mainUi.getSlidingMenu();
		
		if(enable)
		{
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		}else
		{
			slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
		}
	}

	
}
