package com.hngout.app;

import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class HangoutRequest extends Activity {
	public static String St;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	public    HttpApiCall CallAPiFor_login(String url,String apikey, String Username,String Password){
				
					
		 // new  HttpApiCall().execute(url,apikey,Username,Password);
		  
			HttpApiCall HAP =new HttpApiCall();
		  HAP.execute(url,apikey,Username,Password);
		  return HAP;
	}
	public void CallAPiFor_SingUp(String url,String apikey,String Username,String Password,String FName, String LName,String Email,String Gender,String Dob,String NickNmae){
		 
			
			new  HttpApiCall().execute(url,apikey,Username,Password,FName,LName,Email,Gender, Dob,NickNmae);
		} 
	public void CallAPiFor_CreateHngOut(String url,String apikey,String hngname,String Discription,String StartTime,String EndTime,String isWhenSuggested,String locationUid,String isvoted,String isfinal){
		 
			
		   new  HttpApiCall().execute(url,apikey,hngname,Discription,StartTime,EndTime,isWhenSuggested,locationUid,isvoted,isfinal);
		 
	} 
	public HttpApiCall CallAPiFor_SearchLocation(String url,String apikey,String query){
		 
		
		 HttpApiCall hac =  new  HttpApiCall();
	     hac.execute(url,apikey,query);
	     return hac;
	} 
	
	private class HttpApiCall extends AsyncTask<String, Integer, String> {
 	//private AsyncTaskCompleteListener<String> callback;
 	 
 	/*public HttpApiCall (Context context, AsyncTaskCompleteListener<String> cb) {
       this.context = context;
        this.callback = cb;
 	 }*/
			 String result;
	
	
			@Override
		   
		    protected void onPreExecute() {
	
		      super.onPreExecute();
	
		    //   displayProgressBar("Downloading...");
	
		    }
	
	
		    @SuppressWarnings("finally")
			@Override
	
		    protected String doInBackground(String... params) {
	
		      //String url=params[0];
	
		   
	
		    HttpClient httpClient = new DefaultHttpClient();
	
		   
	
	        ClientConnectionManager mgr = httpClient.getConnectionManager();
	
	        HttpParams params1 = httpClient.getParams();
	
	        httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(params1, mgr.getSchemeRegistry()), params1);
	
	       //  String [] resultarray;
	
		    HttpPost request = new HttpPost(params[0]);
	
		    request.addHeader("Api-Key", params[1]);
		    request.addHeader("Client-Type","mobile/android");
	
		    request.addHeader("Content-Type", "application/json");
		    
		    if(params[0]=="http://api.tagafrnd.com/coreapp/user/login"){
		    	
		    	try {
	
		    				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	
		    	            nameValuePairs.add(new BasicNameValuePair("username",params[2])); 
		    	            nameValuePairs.add(new BasicNameValuePair("password",params[3])); 
		    	            JSONObject json = new JSONObject();
	    	                json.put("username",params[2]);
	    	                json.put("password",params[3]);
	    	                StringEntity se = new StringEntity(json.toString());
	    	                request.setEntity(se);
		    	            HttpResponse response = httpClient.execute(request);
		    	            HttpEntity entity = response.getEntity();
		    	            //covert 
		    	            result =EntityUtils.toString(entity);
		    	            Log.e("HTTP", "Response = " +result);
    	          
		    	            // some response object
	    	         
		    	            JSONObject jData = new JSONObject(result);
		    	            JSONObject response1 = jData.getJSONObject("response");
		    	            String key = response1.getString("apiKey");  
		    	            String User= response1.getString("username");
		    	            System.out.println(" user is  = "+User);
		    	            System.out.println(" api-key  = "+key );
	           
				    	     St=jData.getString("status");
				    	     System.out.println("Status is  = "+St);
				    	     Log.e("HTTP","Status is  = "+St);
		    	     
		    	    	    //return St;
		    	        
		    	      
		    	       
		    	    	} catch (Exception e) {
	
		    	    					Log.e("HTTP", "Error in http connection " + e.toString());
		    	    		}
				    		finally{
				    				return  St;
				    		}
			     
		    }
		   
		    if(params[0]=="http://api.tagafrnd.com/coreapp/account/signup")
		    {
		    	
		    			
			    	try {
		
			    	    		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		
			    	            nameValuePairs.add(new BasicNameValuePair("username",params[2])); 
			    	            nameValuePairs.add(new BasicNameValuePair("password",params[3])); 
			    	            nameValuePairs.add(new BasicNameValuePair("firstName",params[4]));
			    	            nameValuePairs.add(new BasicNameValuePair("lastName",params[5]));
			    	            nameValuePairs.add(new BasicNameValuePair("emailAddress",params[6]));
			    	            nameValuePairs.add(new BasicNameValuePair("gender",params[7]));
			    	            nameValuePairs.add(new BasicNameValuePair("dob",params[8]));
			    	            nameValuePairs.add(new BasicNameValuePair("nickname",params[9]));
			    	            	    	                   
			    	            JSONObject json = new JSONObject();
		
			    	                json.put("username",params[2]);
			    	                json.put("password",params[3]);
	   		    	                json.put("firstName",params[4]);
			    	                json.put("lastName",params[5]);
			    	                json.put("emailAddress",params[6]);
			    	                json.put("gender",params[7]);
			    	                json.put("dob",params[8]);
			    	                json.put("nickname",params[9]);
			    	                
			    	                
			    	                StringEntity se = new StringEntity(json.toString());
		
			    	                request.setEntity(se);
				    	            HttpResponse response = httpClient.execute(request);
		
			    	                HttpEntity entity = response.getEntity();
			    	                //covert 
				    	            Log.e("HTTP", "Response = " + EntityUtils.toString(entity));
			    	          
			    	      } catch (Exception e) {
	
			    	    	  			Log.e("HTTP", "Error in http connection " + e.toString());
			    	      	}
		    }
		    
		//create hangout here    
		    if(params[0]=="http://api.tagafrnd.com/coreapp/hngout/create/request")
			    {
			    	try {
		
			    			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		    	            nameValuePairs.add(new BasicNameValuePair("hngoutName",params[2])); 
		    	            nameValuePairs.add(new BasicNameValuePair("hngoutDescription",params[3])); 
		    	            nameValuePairs.add(new BasicNameValuePair("startTime",params[4])); 
		    	            nameValuePairs.add(new BasicNameValuePair("endTime",params[5])); 
		    	            nameValuePairs.add(new BasicNameValuePair("isWhenSuggested",params[6])); 
		    	            nameValuePairs.add(new BasicNameValuePair("locationUid",params[7])); 
		    	            nameValuePairs.add(new BasicNameValuePair("isVoted",params[8]));
		    	            nameValuePairs.add(new BasicNameValuePair("isFinal",params[9])); 
		    	            JSONObject wen =new JSONObject();
			    	        wen.put("startTime",params[4]);
			    	        wen.put("endTime",params[5]);
			    	        
			    	        JSONArray ja =new JSONArray();
			    	        		ja.put(wen);
			    	        		
	    	        		 
	    	        		JSONObject wer =new JSONObject();
			    	        wer.put("locationUid",params[7] );
			    	        wer.put("isVoted",params[8]);
			    	        wer.put("isFinal",params[9]);
			    	        
			    	        
			    	        JSONArray jawer =new JSONArray();
			    	        		jawer.put(wer);
	    	      
			    	        JSONObject json = new JSONObject();
			                json.put("hngoutName",params[2]);
			                json.put("hngoutDescription",params[3]);
			                json.put("isWhenSuggested",params[6]);
			                json.put("when",ja); 
			                json.put( "isWhereSuggested", "false");
			                json.put("where",jawer);
			                StringEntity se = new StringEntity(json.toString());
			                System.out.println("hhttre is"+json.toString());
			                request.setEntity(se);
		    	            HttpResponse response = httpClient.execute(request);
		    	            HttpEntity entity = response.getEntity();
		    	            //covert 
		    	            Log.e("HTTP", "Response = " + EntityUtils.toString(entity));
			    	     	    	              	    	        	
			    		}catch (Exception e) {
		
			    	            Log.e("HTTP", "Error in http connection " + e.toString());
			    	     }
			    }
		       //Call to search location
		    	if(params[0]=="http://api.tagafrnd.com/coreapp/location/search"){
		          //  request.addHeader("Client-Type", params[2]);
		         
		    		
		    		try {
	
		    				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	
		    	            nameValuePairs.add(new BasicNameValuePair("query",params[2])); 
		    	            nameValuePairs.add(new BasicNameValuePair("location","[18.512168,73.902175]")); 
		    	             
		    	            JSONArray loc =new JSONArray();
	    	        		loc.put("18.512168");
	    	        		loc.put("73.902175");
		    	            
		    	            JSONObject json = new JSONObject();
		    	            json.put("searchType","query");
		    	            json.put("query",params[2]);
	    	                json.put("location",loc);
	    	                StringEntity se = new StringEntity(json.toString());
	    	                request.setEntity(se);
	    	                System.out.println("hhttre is"+json.toString());
		    	            HttpResponse response = httpClient.execute(request);
		    	            HttpEntity entity = response.getEntity();
		    	            //covert 
		    	            result =EntityUtils.toString(entity);
		    	            Log.e("HTTP", "Response = " +result);
    	          
		    	            // some response object
	    	         
		    	            JSONObject jData = new JSONObject(result);
		    	            JSONObject response1 = jData.getJSONObject("response");
		    	           // String key = response1.getString("apiKey");  
		    	            //String User= response1.getString("username");
		    	           
		    	     
		    	    	    //return St;
		    	        
		    	      
		    	       
		    	    		} catch (Exception e) {
	
		    	    					Log.e("HTTP", "Error in http connection " + e.toString());
		    	    		}
				    		finally{
				    				return   result;
				    		}
			     
		    }

	      return "All Done!";

	    }


	    @Override

	    protected void onProgressUpdate(Integer... values) {

	      super.onProgressUpdate(values);

	      //updateProgressBar(values[0]);

	    }


	    @Override

	 protected void onPostExecute(String result1) {

	      super.onPostExecute(result1);
	      // 	Login lg=new Login();
	      	//lg.onTaskComplete(result1); 
	      
	      System.out.println("Result"+result1);
	      // dismissProgressBar();
	       

	    }
	    
	    
	  
	   
	  
 }
	

  
 }
	
 
