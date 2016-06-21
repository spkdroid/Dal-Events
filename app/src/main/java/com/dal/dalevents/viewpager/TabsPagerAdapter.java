package com.dal.dalevents.viewpager;

import com.dal.dalevents.fragment.AddEvent;
import com.dal.dalevents.fragment.Create;
import com.dal.dalevents.fragment.ManageEvents;
import com.dal.dalevents.fragment.TodayEvent;

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
           return new ManageEvents();
        case 1:
            return new TodayEvent();       
        case 2:
        	return new Create(); 
        case 3:
   //     	return new TagEditor();
        case 4:
    //    	return new Plugin();
        }
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
}