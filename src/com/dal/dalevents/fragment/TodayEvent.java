package com.dal.dalevents.fragment;

import com.dal.dalevents.R;
import com.dal.dalevents.admin.CreateEvent;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

public class TodayEvent extends Fragment {

	CalendarView cal;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		View rootView=inflater.inflate(R.layout.event_date, container,false);
		
		cal=(CalendarView) rootView.findViewById(R.id.calanderview);
		cal.setOnDateChangeListener(new OnDateChangeListener()
		{
			@Override
			public void onSelectedDayChange(CalendarView view, int year,
					int month, int dayOfMonth) {

				DialogView dd;
				android.app.FragmentManager fm=getActivity().getFragmentManager();
			
				FragmentTransaction ft=fm.beginTransaction();
				Bundle args=new Bundle();
				String c_mon;
				String c_day;
				
				month=month+1;
				if(month<10)
				{
				c_mon="0"+month;	
				}
				else
				{
			    c_mon=month+"";
				}
				
				if(dayOfMonth<10)
				{
				c_day="0"+dayOfMonth;	
				}
				else
				{
					c_day=dayOfMonth+"";
				}
				args.putString("date",year+"-"+c_mon+"-"+c_day);
				dd=new DialogView();
				dd.setArguments(args);
				ft.commit();
			//	dd.show(fm,"Ram");
			}
		});
		return rootView;
	}

}
