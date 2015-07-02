package com.dal.dalevents.viewpager;



import com.dal.dalevents.R;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DalEvents extends FragmentActivity implements TabListener
{
	


	  private ViewPager viewPager;
	    private TabsPagerAdapter mAdapter;
	    private android.app.ActionBar actionBar;
	    
	    private String[] tabs = { "Manage","Event by Date","Add Event"};
	
	public void onCreate(Bundle savedBundle)
	{
		super.onCreate(savedBundle);
	    setContentView(R.layout.dalevents);	
	    
        // enable ActionBar app icon to behave as action to toggle nav drawer
       // getActionBar().setDisplayHomeAsUpEnabled(true);
       // getActionBar().setHomeButtonEnabled(true);
       getActionBar().setIcon(R.drawable.ic_launcher);
	    
	  viewPager = (ViewPager) findViewById(R.id.adminpager);
      actionBar = getActionBar();
      mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

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
