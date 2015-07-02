package com.dal.dalevents.fragment;

import com.dal.dalevents.R;
import com.dal.dalevents.admin.CreateEvent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Create  extends Fragment implements OnClickListener
{
	
	Button start;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		View rootView=inflater.inflate(R.layout.create_start, container,false);
	    start= (Button) rootView.findViewById(R.id.startevent);
	    start.setOnClickListener(this);
		return rootView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		getActivity().finish();
		Intent i=new Intent(getActivity(),CreateEvent.class);
		startActivity(i);
	}

}
