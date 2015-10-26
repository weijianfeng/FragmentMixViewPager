package com.example.ui;

import com.example.R;
import com.example.base.OnTabReselectListener;
import com.example.widget.MyFragmentTabHost;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;

public class MainActivity extends ActionBarActivity implements
		OnTabChangeListener, OnTouchListener {

	public MyFragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		mTabHost = (MyFragmentTabHost) findViewById(R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		if (android.os.Build.VERSION.SDK_INT > 10) {
			mTabHost.getTabWidget().setShowDividers(0);
		}

		initTabs();

		mTabHost.setCurrentTab(0);
		mTabHost.setOnTabChangedListener(this);
	}

	private void initTabs() {
		MainTab[] tabs = MainTab.values();
		final int size = tabs.length;
		for (int i = 0; i < size; i++) {
			MainTab mainTab = tabs[i];
			TabSpec tab = mTabHost.newTabSpec(getString(mainTab.getResName()));
			View indicator = LayoutInflater.from(getApplicationContext())
					.inflate(R.layout.tab_indicator, null);
			TextView title = (TextView) indicator.findViewById(R.id.tab_title);
			Drawable drawable = this.getResources().getDrawable(
					mainTab.getResIcon());
			title.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null,
					null);

			title.setText(getString(mainTab.getResName()));
			tab.setIndicator(indicator);
			tab.setContent(new TabContentFactory() {

				@Override
				public View createTabContent(String tag) {
					return new View(MainActivity.this);
				}
			});
			mTabHost.addTab(tab, mainTab.getClz(), null);

			mTabHost.getTabWidget().getChildAt(i).setOnTouchListener(this);
		}
	}

	@Override
	public void onTabChanged(String tabId) {
		final int size = mTabHost.getTabWidget().getTabCount();
		for (int i = 0; i < size; i++) {
			View v = mTabHost.getTabWidget().getChildAt(i);
			if (i == mTabHost.getCurrentTab()) {
				v.setSelected(true);
			} else {
				v.setSelected(false);
			}
		}
		supportInvalidateOptionsMenu();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		super.onTouchEvent(event);
		boolean consumed = false;
		// use getTabHost().getCurrentTabView to decide if the current tab is
		// touched again
		if (event.getAction() == MotionEvent.ACTION_DOWN
				&& v.equals(mTabHost.getCurrentTabView())) {
			// use getTabHost().getCurrentView() to get a handle to the view
			// which is displayed in the tab - and to get this views context
			Fragment currentFragment = getCurrentFragment();
			if (currentFragment != null
					&& currentFragment instanceof OnTabReselectListener) {
				OnTabReselectListener listener = (OnTabReselectListener) currentFragment;
				listener.onTabReselect();
				consumed = true;
			}
		}
		return consumed;
	}

	private Fragment getCurrentFragment() {
		return getSupportFragmentManager().findFragmentByTag(
				mTabHost.getCurrentTabTag());
	}
}
