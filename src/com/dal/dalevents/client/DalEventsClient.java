package com.dal.dalevents.client;

import com.dal.dalevents.R;
import com.dal.dalevents.viewpager.TabsPagerAdapter;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;

public class DalEventsClient extends FragmentActivity implements TabListener{

	
   	    private ViewPager viewPager;
	    private ClientTabsPagerAdapter mAdapter;
	    private android.app.ActionBar actionBar;
	    private String[] tabs = { "Recent News","Student Life","Research","Sports","Up coming Events","Today Events","Event by Date","Filter Events"};
	
	    public void onCreate(Bundle savedBundle)
		{
			super.onCreate(savedBundle);
		    setContentView(R.layout.dalevents);	
	
		    getActionBar().setIcon(R.drawable.ic_launcher);
		    
		  viewPager = (ViewPager) findViewById(R.id.adminpager);
	      actionBar = getActionBar();
	      mAdapter = new ClientTabsPagerAdapter(getSupportFragmentManager());

	      viewPager.setAdapter(mAdapter);
	      actionBar.setHomeButtonEnabled(false);
	      actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        

	      // Adding Tabs
	      for (String tab_name : tabs) {
	          actionBar.addTab(actionBar.newTab().setText(tab_name)
	                  .setTabListener(this));
	      }
	      viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
	      	 
	          @Override
	          public void onPageSelected(int position) {
	              // on changing the page
	              // make respected tab selected
	              actionBar.setSelectedNavigationItem(position);
	          }
	       
	          @Override
	          public void onPageScrolled(int arg0, float arg1, int arg2) {
	          }
	       
	          @Override
	          public void onPageScrollStateChanged(int arg0) {
	          }
	      });

	}
	    
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
