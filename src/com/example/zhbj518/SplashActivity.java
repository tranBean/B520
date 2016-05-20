package com.example.zhbj518;

import com.example.zhbj518.utils.PrefUtils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

public class SplashActivity extends Activity
{

	private RelativeLayout rlroot;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		rlroot = (RelativeLayout)findViewById(R.id.rl_root);
		
		//璋冪敤涓�涓姩鐢绘柟娉�
		startAnima();
	}

	private void startAnima()
	{	
		AnimationSet set = new AnimationSet(false);
		//鏃嬭浆
		RotateAnimation rotate = new RotateAnimation(0, 360
				, Animation.RELATIVE_TO_SELF, 0.5f
				, Animation.RELATIVE_TO_SELF, 0.5f);
		rotate.setDuration(1000);
		rotate.setFillAfter(true);
		//缂╂斁
		ScaleAnimation scale = new ScaleAnimation(0, 1, 0, 1
				, Animation.RELATIVE_TO_SELF, 0.5f
				, Animation.RELATIVE_TO_SELF, 0.5f);
		scale.setDuration(1000);
		scale.setFillAfter(true);
		//娓愬彉
		AlphaAnimation alpha = new AlphaAnimation(0, 1);
		alpha.setDuration(2000);
		alpha.setFillAfter(true);
		
		set.addAnimation(rotate);
		set.addAnimation(scale);
		set.addAnimation(alpha);
		
		rlroot.startAnimation(set);
		
		//璁剧疆鍔ㄧ敾鐩戝惉
		set.setAnimationListener(new AnimationListener()
		{
			
			@Override
			public void onAnimationStart(Animation animation)
			{
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation)
			{
				
			}
			//褰撳姩鐢荤粨鏉熸椂 璺宠浆activity
			@Override
			public void onAnimationEnd(Animation animation)
			{
				jumpNextPager();
				
			}
		});
	}

	protected void jumpNextPager() {
		
		boolean userGuide = PrefUtils.getBoolean(this, "is_show_user_guide", false);//false ---> No
		
		if(!userGuide)
		{
			startActivity(new Intent().setClass(SplashActivity.this, GuideActivity.class));
			
		}else
		{
			startActivity(new Intent().setClass(SplashActivity.this, MainActivity.class));
		}
		
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
