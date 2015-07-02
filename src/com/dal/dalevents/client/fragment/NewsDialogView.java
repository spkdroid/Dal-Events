package com.dal.dalevents.client.fragment;

import com.dal.dalevents.R;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;
import android.widget.Toast;

public class NewsDialogView extends DialogFragment
{

	ImageView img;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    		View rootView=inflater.inflate(R.layout.newsdialog, container,false);

    		String r=getArguments().getString("imgurl");
    		Toast.makeText(getActivity(),r,Toast.LENGTH_LONG).show();
    		img=(ImageView)rootView.findViewById(R.id.image);
    		return rootView;
	}
	
	
}
