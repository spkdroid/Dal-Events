package com.dal.dalevents.client;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dal.dalevents.client.fragment.AllEvent;
import com.dal.dalevents.client.fragment.FilterEvent;
import com.dal.dalevents.client.fragment.NewsFeed;
import com.dal.dalevents.client.fragment.Research;
import com.dal.dalevents.client.fragment.Search;
import com.dal.dalevents.client.fragment.Sports;
import com.dal.dalevents.client.fragment.StudentLife;
import com.dal.dalevents.client.fragment.TestNews;
import com.dal.dalevents.client.fragment.Today;
import com.dal.dalevents.fragment.Create;
import com.dal.dalevents.fragment.ManageEvents;
import com.dal.dalevents.fragment.TodayEvent;

public class ClientTabsPagerAdapter extends FragmentPagerAdapter {

	public ClientTabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
        	return new NewsFeed();
        case 1:
        	return new StudentLife();
        case 2:
        	return new Research();
        case 3:
        	return new Sports();
        case 4:
            return new AllEvent();
        case 5:    
            return new Today();
        case 6:
            return new Search();       
        case 7:
        	return new FilterEvent();
        }
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 8;
    }
	
}
