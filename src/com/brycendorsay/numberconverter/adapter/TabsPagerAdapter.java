package com.brycendorsay.numberconverter.adapter;

import com.brycendorsay.numberconverter.BinaryFragment;
import com.brycendorsay.numberconverter.HexadecimalFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new BinaryFragment();
		case 1:
			// Games fragment activity
			return new HexadecimalFragment();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 2;
	}

}


