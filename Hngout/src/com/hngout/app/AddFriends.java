package com.hngout.app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AddFriends extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_friends);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_add_friends, menu);
		return true;
	}

}
