package com.dal.dalevents;

import com.dal.dalevents.client.fragment.AllEvent;
import com.dal.dalevents.client.fragment.NewsFeed;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class HomeActivity extends FragmentActivity implements OnClickListener {

	Button newsButton,eventButton;
	AlertDialog.Builder alertDialog ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homescreen);
	
	
		newsButton=(Button)findViewById(R.id.news);
		eventButton=(Button)findViewById(R.id.event);
		
		newsButton.setOnClickListener(this);
		eventButton.setOnClickListener(this);
	    alertDialog = new AlertDialog.Builder(this);
	      
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==newsButton)
		{
	        		    NewsFeed ne=new NewsFeed();
					    FragmentManager fragmentManager =getSupportFragmentManager();
					    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
					    fragmentTransaction.replace(android.R.id.content, ne);
					    fragmentTransaction.commit();
		}
		if(v==eventButton)
		{

		    AllEvent ne=new AllEvent();
		    FragmentManager fragmentManager =getSupportFragmentManager();
		    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		    fragmentTransaction.replace(android.R.id.content, ne);
		    fragmentTransaction.commit();
		
		}
	}
}
