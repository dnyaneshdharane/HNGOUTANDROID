package com.hngout.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Getin extends Activity implements OnClickListener {
	Intent i;
	Button login,singup,down;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.getin_hng);
	
		login=(Button)findViewById(R.id.login1);
		singup=(Button)findViewById(R.id.singup);
		 down=(Button)findViewById(R.id.download);
		singup.setOnClickListener(this);
		down.setOnClickListener(this);
		login.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.getin_hng, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.login1:
				  i=new Intent(Getin.this,Login.class);
				  startActivity(i);
				 break;
			case R.id.singup:
				 i =new Intent(Getin.this,Singup.class);
					startActivity(i);
				 break;
			 
		}
		
	}
	
	 
}
