package com.hngout.app;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

public class SearchLocation extends Activity implements OnClickListener  {
  EditText SearchLocation;
   Button find;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_location);
		SearchLocation=(EditText)findViewById(R.id.eTSearchloc);
		find=(Button)findViewById(R.id.bnext);
		 find.setOnClickListener(this);
		 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_search_location, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String query =SearchLocation.getText().toString();
		String url="http://api.tagafrnd.com/coreapp/location/search";
		String Apikey="T6SC5Hd8fPLkwbNudAsviN6njrZyDdrYd7zZJSU0PEU"; 
		//String location ="[18.512168,73.902175]";
		//String ClientType ="mobile/android";

		HangoutRequest Hreq =new HangoutRequest();
		Hreq.CallAPiFor_SearchLocation(url,Apikey,query);
		
	}

	 
}
