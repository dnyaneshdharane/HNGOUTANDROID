package com.hngout.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Add_hngout_where extends Activity implements OnClickListener{

	Button next,back,location;
	Intent i;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_hngout_where);
		next=(Button)findViewById(R.id.bNextWhere);
		back=(Button)findViewById(R.id.bBkwhere);
		next.setOnClickListener(this);
		back.setOnClickListener(this);
		location=(Button)findViewById(R.id.bSearch);
		location.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_add_hngout_where, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bNextWhere:
			String Location =location.getText().toString();
			String isvoted="true";
			String isfinal="true";
			SaveTempData STD =new SaveTempData();
			 STD.SaveWhereData(Location,isvoted,isfinal);
			i=new Intent(Add_hngout_where.this,Add_hngout_who.class);
			startActivity(i);
			break;
		case R.id.bBkwhere:
			i=new Intent(Add_hngout_where.this,Add_hngout_When.class);
			startActivity(i);
			break;
		case R.id.bSearch:
			i=new Intent(Add_hngout_where.this,SearchLocation.class);
			startActivity(i);
			break;
				
		}
	}

}
