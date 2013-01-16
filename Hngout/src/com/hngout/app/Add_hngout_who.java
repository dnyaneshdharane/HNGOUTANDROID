package com.hngout.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Add_hngout_who extends Activity implements OnClickListener{
	Button next,back;
	Intent i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_hngout_who);
		next=(Button)findViewById(R.id.bNextWho);
		back=(Button)findViewById(R.id.bBackwho);
		next.setOnClickListener(this);
		back.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_add_hngout_who, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bNextWho:
			 SaveTempData Savehng =new SaveTempData();
			 Savehng.callhttpcon();
			break;
		case R.id.bBackwho:
			i=new Intent(Add_hngout_who.this,Add_hngout_where.class);
			startActivity(i);
			break;
		}
	}

}
