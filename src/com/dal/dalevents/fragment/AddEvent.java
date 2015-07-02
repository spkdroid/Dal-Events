package com.dal.dalevents.fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.dal.dalevents.R;
import com.dal.dalevents.admin.AddDescription;

public class AddEvent extends Fragment implements OnClickListener {
	
	private static final int TIME_DIALOG_ID = 0;

	private int hour;

	private int minute;

	EditText eventname;

	Spinner department,venue;

	Button time,date,next;

	TextView time_txt,date_txt;

	private int year=2015;

	private int month=02;

	private int day=28;

	private String sysdate;

	Date d;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		View rootView=inflater.inflate(R.layout.admin_login, container,false);
	   
		
         eventname=(EditText)rootView.findViewById(R.id.editText1);
		
		time=(Button)rootView.findViewById(R.id.selecttimebutton);
		date=(Button)rootView.findViewById(R.id.calendarselectbutton);
        next=(Button)rootView.findViewById(R.id.next);
        
        department=(Spinner)rootView.findViewById(R.id.departmentlist);
        venue=(Spinner)rootView.findViewById(R.id.venuelist);
        
        time_txt=(TextView)rootView.findViewById(R.id.time);
        date_txt=(TextView)rootView.findViewById(R.id.calendar);
        
         time.setOnClickListener(this);
         date.setOnClickListener(this);
         next.setOnClickListener(this);
        
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         String sysdate= formatter.format(new Date());
         
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         try {
			d=sdf.parse(time_txt.getText().toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return rootView;	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v==time)
		{
			Toast.makeText(getActivity(),"Enter Event Name",Toast.LENGTH_LONG).show();
			getActivity().showDialog(0);
		}
		if(v==date)
		{
			getActivity().showDialog(1);
		}
		
		if(v==next)
		{
			boolean f=true;
			if(eventname.getText().toString().length()>0)
			{
				f=false;
			}
			else
			{
				Toast.makeText(getActivity(),"Enter Event Name",Toast.LENGTH_LONG).show();
			}
			
			if(!time_txt.getText().toString().equals("Select Time"))
			{
				f=false;
			}
			else
			{
				Toast.makeText(getActivity(),"Enter Time",Toast.LENGTH_LONG).show();
			}
			
		
//			Intent i =new Intent(getApplicationContext(),AddDescription.class);
	//		i.putExtra("eventname",eventname.getText().toString());
		//	i.putExtra("time",time_txt.getText().toString());
	//		i.putExtra("date",date_txt.getText().toString());
	//		i.putExtra("department",department.getSelectedItem().toString());
	//		i.putExtra("venue",venue.getSelectedItem().toString());
	//		startActivity(i);
			
		}
	
		
		
	}

	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		switch (id) {
		case 0:
			return new TimePickerDialog(getActivity(),timePickerListener, hour, minute,false);
		case 1:
			  return new DatePickerDialog(getActivity(), datePickerListener,year, month,day);
		}
		return null;
	}
	

	private TimePickerDialog.OnTimeSetListener timePickerListener = 
            new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int selectedHour,int selectedMinute) {
			hour = selectedHour;
			minute = selectedMinute;
			time_txt.setText(new StringBuilder().append(pad(hour)).append(":").append(pad(minute)));
		}
	
	};
	
	
	private DatePickerDialog.OnDateSetListener datePickerListener 
    = new DatePickerDialog.OnDateSetListener() {

// when dialog box is closed, below method will be called.
public void onDateSet(DatePicker view, int selectedYear,int selectedMonth, int selectedDay) {

year = selectedYear;
month = selectedMonth;
day = selectedDay;

// set selected date into textview
date_txt.setText(new StringBuilder().append(month + 1).append("-").append(day).append("-").append(year).append(" "));

}


};

private static String pad(int c) {
	if (c >= 10)
	   return String.valueOf(c);
	else
	   return "0" + String.valueOf(c);
}

}
