package com.example.zhbj518;

import java.util.ArrayList;

import com.example.zhbj518.utils.PrefUtils;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class GuideActivity extends Activity
{
	private static final int[] mImageIds 
			= new int[] {R.drawable.guide_1,R.drawable.guide_2
										   ,R.drawable.guide_3};
	private ViewPager vpGuide;
	private ArrayList<ImageView> mImageViewList;
	private LinearLayout llpointGroup;
	private int pointWidth;
	private View vredpoint;
	private Button btnguide;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		vpGuide = (ViewPager) findViewById(R.id.vp_guide);
		llpointGroup = (LinearLayout) findViewById(R.id.ll_point_group);
		vredpoint = findViewById(R.id.v_redpoint);
		btnguide = (Button) findViewById(R.id.btn_guide);
		
		initViews();
		vpGuide.setAdapter(new GuideAdapter());
		vpGuide.setOnPageChangeListener(new GuidePagerListener());
		btnguide.setOnClickListener(new StartButton());
	}
	
	class StartButton implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			//upgade
			PrefUtils.setBoolean(GuideActivity.this, "is_show_user_guide", true);
			startActivity(new Intent().setClass(GuideActivity.this, MainActivity.class));
			finish();
		}
		
	}
	
	class GuidePagerListener implements OnPageChangeListener
	{

		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			System.out.println(position+"  "+positionOffset+"  "+positionOffsetPixels);
			int len = (int) (pointWidth * positionOffset) + position * pointWidth;
			RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) vredpoint.getLayoutParams();
			params.leftMargin = len;
			vredpoint.setLayoutParams(params);
			
		}

		@Override
		public void onPageSelected(int position) {
			if(position != mImageIds.length-1)
			{
				btnguide.setVisibility(Button.INVISIBLE);
			}else
			{
				btnguide.setVisibility(Button.VISIBLE);
			}
		}

		@Override
		public void onPageScrollStateChanged(int state) {
			
		}

	}
	
	private void initViews()
	{
		mImageViewList = new ArrayList<ImageView>();
		//鍔犺浇涓変釜寮曞椤甸潰
		for(int i=0;i<mImageIds.length;i++)
		{
			ImageView image = new ImageView(this);
			image.setBackgroundResource(mImageIds[i]);//璁剧疆寮曞椤�3涓〉闈�
			mImageViewList.add(image);
		}
		
		//鍔犺浇涓変釜灏忕伆鐐�
		for(int i=0;i<mImageIds.length;i++)
		{
			View point = new View(this);
			point.setBackgroundResource(R.drawable.shape_point_gray);//璁剧疆寮曞椤�3涓〉闈�
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
			if(i>0)
			{
				params.leftMargin = 10;
			}
			point.setLayoutParams(params);//璁剧疆鍦嗙偣澶у皬
			
			llpointGroup.addView(point);//灏嗗渾鐐规坊鍔犱釜绾挎�у竷灞�
		}
		
		llpointGroup.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			

			@Override
			public void onGlobalLayout() {
				llpointGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				
				pointWidth = llpointGroup.getChildAt(1).getLeft() 
						- llpointGroup.getChildAt(0).getLeft();
				//System.out.println("pointWidth = "+ pointWidth);
			}
		});
	}


	class GuideAdapter extends PagerAdapter
	{

		@Override
		public int getCount()
		{
			return mImageIds.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1)
		{
			return arg0 == arg1;
		}
		@Override
		public Object instantiateItem(ViewGroup container, int position)
		{
			container.addView(mImageViewList.get(position));
			return mImageViewList.get(position);
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object)
		{
			container.removeView((View)object);
		}
		
	}
}
