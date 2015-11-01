package com.example.base;

import com.example.R;
import com.example.adapter.ViewPageFragmentAdapter;
import com.example.widget.PagerSlidingTabStrip;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 带有导航条的基类
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年11月6日 下午4:59:50
 * 
 */
public abstract class BaseViewPagerFragment extends BaseFragment {

	protected PagerSlidingTabStrip mTabStrip;
	protected ViewPager mViewPager;
	protected ViewPageFragmentAdapter mTabsAdapter;

	// protected EmptyLayout mErrorLayout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.base_viewpage_fragment, null);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		mTabStrip = (PagerSlidingTabStrip) view
				.findViewById(R.id.pager_tabstrip);

		mViewPager = (ViewPager) view.findViewById(R.id.pager);

		// mErrorLayout = (EmptyLayout) view.findViewById(R.id.error_layout);

		mTabsAdapter = new ViewPageFragmentAdapter(getChildFragmentManager(),
				mTabStrip, mViewPager);
		setScreenPageLimit();
		onSetupTabAdapter(mTabsAdapter);
		// if (savedInstanceState != null) {
		// int pos = savedInstanceState.getInt("position");
		// mViewPager.setCurrentItem(pos, true);
		// }
	}
    
	/**
	 * 需要子类进行重写，设置viewpager的缓存页数
	 */
	protected void setScreenPageLimit() {
	}

	// @Override
	// public void onSaveInstanceState(Bundle outState) {
	// //No call for super(). Bug on API Level > 11.
	// if (outState != null && mViewPager != null) {
	// outState.putInt("position", mViewPager.getCurrentItem());
	// }
	// //super.onSaveInstanceState(outState);
	// }

	protected abstract void onSetupTabAdapter(ViewPageFragmentAdapter adapter);
}