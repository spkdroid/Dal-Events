package com.dal.dalevents.fragment;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.dal.dalevents.MainActivity;
import com.dal.dalevents.R;
import com.dal.dalevents.ServiceHandler;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;


public class ManageEvents extends Fragment
{
	
	private ProgressDialog pDialog;
	private static String url;
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
	ListView lv;
	
	Uri dl;

	// contacts JSONArray
	JSONArray contacts = null;
	JSONArray download_url=null;

	// Hashmap for ListView
	ArrayList<HashMap<String, String>> contactList;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		View rootView=inflater.inflate(R.layout.eventlist, container,false);
	    
        url = "http://www.spkdroid.com/webapp/eventlist.php";
		contactList = new ArrayList<HashMap<String, String>>();
		lv =(ListView)rootView.findViewById(R.id.eventlist);
		new GetContacts().execute();
		return rootView;	
	}
	

	private class GetContacts extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			pDialog = new ProgressDialog(getActivity());
			pDialog.setMessage("Please wait...");
			pDialog.setCancelable(false);
			pDialog.show();

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
					for (int i = 0; i < jr.length()-1; i++) 
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
						//contact.put(TAG_SIZE, SIZE);
						contact.put(TAG_DURATION,DURATION);
				        // adding contact to contact list
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
			if (pDialog.isShowing())
				pDialog.dismiss();
			/**
			 * Updating parsed JSON data into ListView
			 * */
			ListAdapter adapter = new SimpleAdapter(
					getActivity(), contactList,
					R.layout.list_item, new String[] { TAG_EMAIL,TAG_NAME,TAG_ID,TAG_DURATION,TAG_LOCATION,TAG_DESC,TAG_SIZE}, new int[] { R.id.email,R.id.name,R.id.size,R.id.duration,R.id.location,R.id.description,R.id.time});
		        	lv.setAdapter(adapter);
		}
	}
	
}


