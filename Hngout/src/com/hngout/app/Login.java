package com.hngout.app;

//import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends Activity implements OnClickListener{

	Button login;
	EditText username,password;
	TextView check;
	String url="http://api.tagafrnd.com/coreapp/user/login";
     String result = "";  
    String deviceId = "xxxxx" ;  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	  login=(Button)findViewById(R.id.Blogin);
	  login.setOnClickListener(this);
	  username=(EditText)findViewById(R.id.etUserName);
	  password=(EditText)findViewById(R.id.etPassword);
	  check =(TextView)findViewById(R.id.check);
			 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
				// TODO Auto-generated method st
			String Username= username.getText().toString();	
			String Password=password.getText().toString();
			String url="http://api.tagafrnd.com/coreapp/user/login";
			String apikey="T6SC5Hd8fPLkwbNudAsviN6njrZyDdrYd7zZJSU0PEU"; 
			  //new HangoutRequest().execute(url,apikey,Username,Password);
 			//String Str;
			HangoutRequest Hreq =new HangoutRequest();
		   Hreq.CallAPiFor_login(url,apikey,Username,Password);
	      
	
		}
	/*public void moveOn(String result)
	{
		System.out.println("welcome");
		 if(result=="OK"){
			 Intent i =new Intent(Login.this,Add_hngout_When.class);
		        startActivity(i);
		 }*/
	 
		 

		 
	       
}

	 
	

	
