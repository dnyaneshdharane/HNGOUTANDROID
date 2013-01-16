package com.hngout.app;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Singup extends Activity implements OnClickListener {

	 Button  singUp;
	 EditText username,password,fName,lName,email,gender,dob,nickNmae;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_singup);
	   singUp=(Button)findViewById(R.id.singUP);
	   singUp.setOnClickListener(this);
	   
	   username=(EditText)findViewById(R.id.etUserName);
	   password=(EditText)findViewById(R.id.etPassword);
	   fName=(EditText)findViewById(R.id.etFname);
	   lName=(EditText)findViewById(R.id.etLastName);
	   email=(EditText)findViewById(R.id.etEmail);
	   gender=(EditText)findViewById(R.id.etGender);
	   dob=(EditText)findViewById(R.id.etDOB);
	   nickNmae=(EditText)findViewById(R.id.etNickName);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_singup, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String url="http://api.tagafrnd.com/coreapp/account/signup";
		String apikey="T6SC5Hd8fPLkwbNudAsviN6njrZyDdrYd7zZJSU0PEU";  
		
		String Username= username.getText().toString();	
		String Password=password.getText().toString();
		String FName=password.getText().toString();
		String LName=password.getText().toString();
		String Email=password.getText().toString();
		String Gender=password.getText().toString();
		String Dob=password.getText().toString();
		String NickNmae=password.getText().toString(); 
		
		//new HangoutRequest().execute(url,apikey,Username,Password,FName,LName,Email,Gender, Dob,NickNmae);
		HangoutRequest Hreq =new HangoutRequest();
		Hreq.CallAPiFor_SingUp(url,apikey,Username,Password,FName,LName,Email,Gender, Dob,NickNmae);
		
	}

}
