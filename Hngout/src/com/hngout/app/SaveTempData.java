package com.hngout.app;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Application;

public class SaveTempData   {
	 int flag=0;
	//  String [] HngDataWhen;
 public static List<String>  HngDataWhen = new ArrayList<String>();
 public static List<String>  HngDataWhere = new ArrayList<String>();
   public List<String> SaveWhenData(String HngName,String Discription,String StartTime,String EndTime,String isWhenSuggested )
	{
	 HngDataWhen.add(HngName);
	   HngDataWhen.add(Discription);
	   HngDataWhen.add(StartTime);
	   HngDataWhen.add(EndTime);
	   HngDataWhen.add(isWhenSuggested);
	   /* HngDataWhen[0]=HngName;
	    HngDataWhen[1]=Discription;
	    HngDataWhen[2]=StartTime;
	    HngDataWhen[3]=EndTime; */
	   
		
	   System.out.println("done " + HngDataWhen);
	    
	 return HngDataWhen;
	}
   public void SaveWhereData(String locationUid,String isVoted,String isfinal) {
	   
	   HngDataWhere.add(locationUid);
	   HngDataWhere.add(isVoted);  
	   HngDataWhere.add(isfinal);  
	     
	
    }
	
  public void callhttpcon()
  {
	  System.out.println("done " + HngDataWhen);
	  String url="http://api.tagafrnd.com/coreapp/hngout/create/request";
	  String apikey="T6SC5Hd8fPLkwbNudAsviN6njrZyDdrYd7zZJSU0PEU";
  	  System.out.println("done infunction");
	  String hngname= HngDataWhen.get(0).toString();
	  String Discription= HngDataWhen.get(1).toString();
	  String  StartTime= HngDataWhen.get(2).toString();
	  String EndTime= HngDataWhen.get(3).toString();
	  String isWhenSuggested= HngDataWhen.get(4).toString();
	 
	  String locationUid=HngDataWhere.get(0).toString();
	  String isvoted=HngDataWhere.get(1).toString();
	  String isfinal=HngDataWhere.get(2).toString();
	  	
	  System.out.println("done infunction=" +hngname);
	 		// String StartTime= HngDataWhen[2];
	 		//String EndTime= HngDataWhen[3];
	  	  HngDataWhen.clear();
	  	  HngDataWhere.clear();
	        HangoutRequest Hreq =new HangoutRequest();
	 		Hreq.CallAPiFor_CreateHngOut(url,apikey,hngname,Discription,StartTime,EndTime,isWhenSuggested,locationUid,isvoted,isfinal);
  }
  
	 

}
