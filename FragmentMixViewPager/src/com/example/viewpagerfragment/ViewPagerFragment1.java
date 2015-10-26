package com.example.viewpagerfragment;

import android.support.v4.app.Fragment;
import android.view.View;

import com.example.adapter.ViewPageFragmentAdapter;
import com.example.base.BaseViewPagerFragment;
import com.example.base.OnTabReselectListener;
import com.example.fragment.ChildFragment1;
import com.example.fragment.ChildFragment2;
import com.example.fragment.ChildFragment3;

public class ViewPagerFragment1 extends BaseViewPagerFragment implements
		OnTabReselectListener {

	protected void onSetupTabAdapter(ViewPageFragmentAdapter adapter) {
		String[] title = { "Child1", "Child2", "Child3" };
		adapter.addTab(title[0], "tag_1", ChildFragment1.class, null);
		adapter.addTab(title[1], "tag_2", ChildFragment2.class, null);
		adapter.addTab(title[2], "tag_3", ChildFragment3.class, null);
	}

	@Override
	public void onClick(View v) {

	}

	@Override
	public void initView(View view) {

	}

	@Override
	public void initData() {

	}

	@Override
	public void onTabReselect() {
		try {
			int currentIndex = mViewPager.getCurrentItem();
			Fragment currentFragment = getChildFragmentManager().getFragments()
					.get(currentIndex);
			if (currentFragment != null
					&& currentFragment instanceof OnTabReselectListener) {
				OnTabReselectListener listener = (OnTabReselectListener) currentFragment;
				listener.onTabReselect();
			}
		} catch (NullPointerException e) {
		}
	}

}
