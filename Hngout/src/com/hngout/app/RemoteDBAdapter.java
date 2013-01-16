package com.hngout.app;

import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.hngout.app.RestClient.RequestMethod;

public class RemoteDBAdapter {
	
 
	//String username =getIntent().getExtras().getString("username");
	//String  password =getIntent().getExtras().getString("password");

	String username=" Test";
	String pasword="1234";
	public String register(String username, String password) throws Exception
	    {
	    
		 System.out.printf("useris",username);
		 
		RestClient c = new  RestClient ("http://api.tagafrnd.com/coreapp/user/login");
	      
		  
	        c.AddHeader("Accept", "application/json");
	        c.AddHeader("Content-type", "application/json");
	        c.AddHeader("Api-Key","T6SC5Hd8fPLkwbNudAsviN6njrZyDdrYd7zZJSU0PEU");
	        c.AddParam("username",username);
	        c.AddParam("password",password);

	        c.Execute(RequestMethod.POST);

	        JSONObject key = new JSONObject(c.getResponse());

	        return key.getString("status");


	    }



	private Intent getIntent() {
		// TODO Auto-generated method stub
		return null;
	}


 


 
 

}
