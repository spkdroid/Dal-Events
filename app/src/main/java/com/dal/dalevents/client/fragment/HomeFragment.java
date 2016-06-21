package com.dal.dalevents.client.fragment;

import com.dal.dalevents.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {

	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		View rootView=inflater.inflate(R.layout.homescreen, container,false);
		return rootView;
	}
	
}
