package com.example.zhbj518.fragment;

import java.util.ArrayList;

import com.example.zhbj518.MainActivity;
import com.example.zhbj518.R;
import com.example.zhbj518.base.BasePager;
import com.example.zhbj518.beans.NewsData;
import com.example.zhbj518.beans.NewsData.NewsMenuData;
import com.example.zhbj518.impl.NewsCenImpl;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class LeftMenuFragment extends BaseFragment {
	
	
	@ViewInject(R.id.lv_list)
	public ListView lvList;
	private ArrayList<NewsMenuData> dataList;
	private MenuAdapter mMenuAdapter;
	private int mCurrnetPager;
	
	@Override
	public View initViews() {
		
		View lefFrgView = View.inflate(mActivity, R.layout.fragment_left, null);
		ViewUtils.inject(this, lefFrgView);
		
		return lefFrgView;
	}
	
	public void setNewsData(NewsData newsData)
	{
		dataList = newsData.data;
		mMenuAdapter = new MenuAdapter();
		lvList.setAdapter(mMenuAdapter);
	}
	
	@Override
	public void initData() {
		
	    lvList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				mCurrnetPager = position;
				mMenuAdapter.notifyDataSetChanged();
				
				setCurrentMenuDetailPager(position);
				
				toggleSlidingMenu();
			}
		});
	
	}
	
	protected void toggleSlidingMenu() {
		MainActivity mainUi = (MainActivity) mActivity;
		SlidingMenu slidingMenu = mainUi.getSlidingMenu();
		slidingMenu.toggle();
	}

	protected void setCurrentMenuDetailPager(int position) {
		
		MainActivity mainUi = (MainActivity) mActivity;
		ContentFragment contentFragment = mainUi.getContentFragment();
		NewsCenImpl newscent = (NewsCenImpl)contentFragment.mPagerList.get(1);
		newscent.setCurrentMenuDetailPager(position);
		
	}

	/**
	 * ²à±ßÀ¸Êý¾ÝÊÊÅäÆ÷
	 * @author Administrator
	 *
	 */
	class MenuAdapter extends BaseAdapter
	{

		@Override
		public int getCount() {
			return dataList.size();
		}

		@Override
		public NewsMenuData getItem(int position) {
			return dataList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			View view = View.inflate(mActivity, R.layout.list_menu_item, null);
			TextView text = (TextView) view.findViewById(R.id.tv_title);
			
			NewsMenuData newsMenuData = dataList.get(position);
			text.setText(newsMenuData.title);
			
			if(mCurrnetPager == position)
			{//ÏÔÊ¾ºìÉ«
				text.setEnabled(true);
			}else
			{//ÏÔÊ¾°×É«
				text.setEnabled(false);
			}
			return view;
		}
		
	}

}
