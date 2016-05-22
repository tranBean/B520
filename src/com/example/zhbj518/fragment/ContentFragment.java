package com.example.zhbj518.fragment;

import java.util.ArrayList;

import com.example.zhbj518.R;
import com.example.zhbj518.base.BasePager;
import com.example.zhbj518.impl.GovaffImpl;
import com.example.zhbj518.impl.HomeImpl;
import com.example.zhbj518.impl.NewsCenImpl;
import com.example.zhbj518.impl.SettingImpl;
import com.example.zhbj518.impl.SmartSerImpl;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class ContentFragment extends BaseFragment {
	
	@ViewInject(R.id.rg_group)
	private RadioGroup rgGroup;
	
	@ViewInject(R.id.vp_content)
	private ViewPager mViewPager;
	
	private ArrayList<BasePager> mPagerList;
	
	@Override
	public View initViews() {
		View conFrgView = View.inflate(mActivity, R.layout.fragment_content, null);
		ViewUtils.inject(this, mActivity);
		rgGroup = (RadioGroup) conFrgView.findViewById(R.id.rg_group);
		mViewPager = (ViewPager) conFrgView.findViewById(R.id.vp_content);
		return conFrgView;
	}
	
	@Override
	public void initData() {
		rgGroup.check(R.id.rb_home);
		
		mPagerList = new ArrayList<BasePager>();
		//初始化5个子页面
		/*for(int i=0;i<5;i++)
		{
			BasePager mPager = new BasePager(mActivity);
			mPagerList.add(mPager);
		}*/
		mPagerList.add(new HomeImpl(mActivity));
		mPagerList.add(new NewsCenImpl(mActivity));
		mPagerList.add(new SmartSerImpl(mActivity));
		mPagerList.add(new GovaffImpl(mActivity));
		mPagerList.add(new SettingImpl(mActivity));
		
		mViewPager.setAdapter(new ContentAdapter());
		
		rgGroup.setOnCheckedChangeListener(new OnCheckedChangeListener(
				) {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_home:
					mViewPager.setCurrentItem(0, false);
					break;
				case R.id.rb_news:
					mViewPager.setCurrentItem(1, false);
					break;
				case R.id.rb_smart:
					mViewPager.setCurrentItem(2, false);
					break;
				case R.id.rb_govaff:
					mViewPager.setCurrentItem(3, false);
					break;
				case R.id.rb_set:
					mViewPager.setCurrentItem(4, false);
					break;
				default:
					break;
				}
			}
		});
		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				mPagerList.get(arg0).initData();
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		mPagerList.get(0).initData();
	}
	
	class ContentAdapter extends PagerAdapter
	{

		@Override
		public int getCount() {
			return mPagerList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			BasePager mPager = mPagerList.get(position);
			container.addView(mPager.mRootView);
			//mPager.initData();//初始化数据....
			return mPager.mRootView;
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View)object);
		}
	}

}
