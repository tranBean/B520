package com.example.zhbj518;

import com.example.zhbj518.fragment.ContentFragment;
import com.example.zhbj518.fragment.LeftMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

public class MainActivity extends SlidingFragmentActivity {
	private static final String FRAGMENT_LEFT_MENU = "fragment_left_menu";
	private static final String FRAGMENT_CONTENT_MENU = "fragment_content_menu";
	
	
	@Override
	public  void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		setBehindContentView(R.layout.slidingmenu_left);//���ò����
		
		SlidingMenu slidingMenu = getSlidingMenu();//��ȡ�����
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//ȫ������
		slidingMenu.setBehindOffset(200);//����Ԥ�����
		
		initFragment();
	}

	private void initFragment() {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transct = fm.beginTransaction();
		
		transct.replace(R.id.fl_left_frg, new LeftMenuFragment(), FRAGMENT_LEFT_MENU);
		transct.replace(R.id.fl_cont_frg, new ContentFragment(), FRAGMENT_CONTENT_MENU);
		
		transct.commit();//�ύ����
	}
}
