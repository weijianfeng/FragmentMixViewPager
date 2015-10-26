package com.example.ui;

import com.example.R;
import com.example.fragment.Fragment1;
import com.example.fragment.Fragment2;
import com.example.fragment.Fragment3;
import com.example.viewpagerfragment.ViewPagerFragment1;


public enum MainTab {

	NO1(0, R.string.no1, R.drawable.tab_icon,
	        ViewPagerFragment1.class),

	NO2(1, R.string.no2, R.drawable.tab_icon,
	        Fragment1.class),

	NO3(3, R.string.no3, R.drawable.tab_icon,
	        Fragment2.class),

	NO4(4, R.string.no4, R.drawable.tab_icon,
	        Fragment3.class);

	private int idx;
	private int resName;
	private int resIcon;
	private Class<?> clz;

	private MainTab(int idx, int resName, int resIcon, Class<?> clz) {
		this.idx = idx;
		this.resName = resName;
		this.resIcon = resIcon;
		this.clz = clz;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getResName() {
		return resName;
	}

	public void setResName(int resName) {
		this.resName = resName;
	}

	public int getResIcon() {
		return resIcon;
	}

	public void setResIcon(int resIcon) {
		this.resIcon = resIcon;
	}

	public Class<?> getClz() {
		return clz;
	}

	public void setClz(Class<?> clz) {
		this.clz = clz;
	}
}
