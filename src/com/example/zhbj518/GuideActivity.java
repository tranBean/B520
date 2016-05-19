package com.example.zhbj518;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GuideActivity extends Activity
{
	private static final int[] mImageIds 
			= new int[] {R.drawable.guide_1,R.drawable.guide_2
										   ,R.drawable.guide_3};
	private ViewPager vpGuide;
	private ArrayList<ImageView> mImageViewList;
	private LinearLayout llpointGroup;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		vpGuide = (ViewPager) findViewById(R.id.vp_guide);
		llpointGroup = (LinearLayout) findViewById(R.id.ll_point_group);
		
		
		initViews();
		vpGuide.setAdapter(new GuideAdapter());
	}
	
	private void initViews()
	{
		mImageViewList = new ArrayList<ImageView>();
		//加载三个引导页面
		for(int i=0;i<mImageIds.length;i++)
		{
			ImageView image = new ImageView(this);
			image.setBackgroundResource(mImageIds[i]);//设置引导页3个页面
			mImageViewList.add(image);
		}
		
		//加载三个小灰点
		for(int i=0;i<mImageIds.length;i++)
		{
			View point = new View(this);
			point.setBackgroundResource(R.drawable.shape_point_gray);//设置引导页3个页面
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
			if(i>0)
			{
				params.leftMargin = 10;
			}
			point.setLayoutParams(params);//设置圆点大小
			
			llpointGroup.addView(point);//将圆点添加个线性布局
		}
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
