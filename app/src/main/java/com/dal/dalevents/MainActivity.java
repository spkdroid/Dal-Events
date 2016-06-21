package com.dal.dalevents;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity{
	
	private ProgressDialog pDialogiiia;
	public File file;
	public ProgressBar progressBarSearch;
	  
	private static final String TAG_CONTACTS = "data";
	private static final String TAG_ID = "event_id";
	private static final String TAG_NAME = "event_name";
	private static final String TAG_EMAIL = "event_school";
	private static final String TAG_SIZE="event_time";
	private static final String TAG_DURATION="event_date";
	private static final String TAG_DESC="event_desc";
	private static final String TAG_LOCATION="event_location";
	
	
	private static final String URL_LIST="url_list"; 
	private static final String URL_TAG="url";
	
	private static final String URL_SIZE="size";
	
	private static String SIZE;
	private static String RMI;
	private static String DURATION;

	
	Uri dl;
	ListView l;

	JSONArray contacts = null;
	JSONArray download_url=null;

	ArrayList<HashMap<String, String>> contactList;
	
	private static String url;
	
	public void onCreate(Bundle savedBundle)
	{
		super.onCreate(savedBundle);
		setContentView(R.layout.ram);	
		String g=getIntent().getExtras().getString("ram");
		l=(ListView)findViewById(R.id.ramkumar);
		
	//	url=url+"'"+g+"'";
		
		url="http://www.spkdroid.com/webapp/eventlist.php";
		
		Toast.makeText(getApplicationContext(),url,Toast.LENGTH_LONG).show();
		new GetContacts().execute();
	}
	
	
	private class GetContacts extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			pDialogiiia = new ProgressDialog(MainActivity.this);
			pDialogiiia.setMessage("Please wait...");
			pDialogiiia.setCancelable(false);
			pDialogiiia.show();

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// Creating service handler class instance
			ServiceHandler sh = new ServiceHandler();

			// Making a request to url and getting response
			String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

			Log.d("Response: ", "> " + jsonStr);

			if (jsonStr != null) {
				try {
					JSONArray jr = new JSONArray(jsonStr);
					// Getting JSON Array node
			//		contacts = jsonObj.getJSONArray(TAG_CONTACTS);

					// looping through All Contacts
					for (int i = 0; i<=(jr.length()-1); i++) 
					{
						JSONObject jsonObj=new JSONObject();
						jsonObj=jr.getJSONObject(i);
					//	JSONObject c = contacts.getJSONObject(i);
						String id = jsonObj.getString(TAG_ID);
						String name = jsonObj.getString(TAG_NAME);
						String email = jsonObj.getString(TAG_EMAIL);
						DURATION=jsonObj.getString(TAG_DURATION);
						String location=jsonObj.getString(TAG_LOCATION);
						String description=jsonObj.getString(TAG_DESC);
						String time=jsonObj.getString(TAG_SIZE);
						
				//		download_url=c.getJSONArray(URL_LIST);
				
					//		JSONObject d = download_url.getJSONObject(0);
					//		RMI=d.getString(URL_TAG);
					//		SIZE=d.getString(URL_SIZE);
						
				
						// tmp hashmap for single contact
						HashMap<String, String> contact = new HashMap<String, String>();

						// adding each child node to HashMap key => value
						contact.put(TAG_ID, id);
						contact.put(TAG_NAME, name);
						contact.put(TAG_EMAIL, email);
						contact.put(TAG_DURATION,DURATION);
						contact.put(TAG_LOCATION, location);
						contact.put(TAG_DESC, description);
		                contact.put(TAG_SIZE,time);
						contactList.add(contact);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				Log.e("ServiceHandler", "Couldn't get any data from the url");
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			// Dismiss the progress dialog
			if (pDialogiiia.isShowing())
				pDialogiiia.dismiss();
			/**
			 * Updating parsed JSON data into ListView
			 * */
			ListAdapter adapter = new SimpleAdapter(
					MainActivity.this, contactList,
					R.layout.list_item, new String[] { TAG_EMAIL,TAG_NAME,TAG_ID,TAG_DURATION,TAG_LOCATION,TAG_DESC,TAG_SIZE}, new int[] { R.id.email,R.id.name,R.id.size,R.id.duration,R.id.location,R.id.description,R.id.time});
		        	l.setAdapter(adapter);
		}
	}
	
	

}