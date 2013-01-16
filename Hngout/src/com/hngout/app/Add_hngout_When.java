package com.hngout.app;

import java.sql.Date;
import java.util.Calendar;

import com.hngout.app.R.string;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
 
import android.text.format.Time;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class Add_hngout_When extends Activity implements OnClickListener {

  String chk;
	  Button next,addmoretime;
	  Intent i;
	  EditText hngname,discription,Sday,Stime,Szone,Eday,Etime,Ezone;
	  
	  CheckBox ch1,ch2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_add_hngout);
				
				 next=(Button)findViewById(R.id.bNextWhen);
				 addmoretime=(Button)findViewById(R.id.baddtime);
				 next.setOnClickListener(this);
				 addmoretime.setOnClickListener(this);
				 hngname=(EditText)findViewById(R.id.eThngName);
				 discription=(EditText)findViewById(R.id.eTDis);
				
				 
				 ch1=(CheckBox)findViewById(R.id.chkB1);
				 ch2=(CheckBox)findViewById(R.id.chkB2);
				 Sday=(EditText)findViewById(R.id.eTdate);
				 Stime=(EditText)findViewById(R.id.eTtime);
				 Szone=(EditText)findViewById(R.id.eTtzone);
				 
				 Eday=(EditText)findViewById(R.id.eTEdate);
				 Etime=(EditText)findViewById(R.id.eTEtime);
				 Ezone=(EditText)findViewById(R.id.eTEzone);
				 Time today = new Time(Time.getCurrentTimezone());
				 today.setToNow();
				 Stime.setText(today.format("%k:%M:%S")); 
				 
				 ch1.setOnCheckedChangeListener(new OnCheckedChangeListener(){
							@Override
							public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
								// TODO Auto-generated method stub
										  if(isChecked){
								                 chk  = "true";
								                     
								             }else{
								                  chk = "False";
							
								             }
							}
						 
				 });
			}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		
							case R.id.bNextWhen:
								String HngName= hngname.getText().toString();
								String Discription=discription.getText().toString();
								String  StartTime= (Sday.getText().toString()+" " + Stime.getText().toString()+" " + Szone.getText().toString());
						     	String EndTime=( Eday.getText().toString()+" " + Etime.getText().toString()+" " + Ezone.getText().toString());
						     	 
						     	System.out.println("when"  +StartTime);
								System.out.println("when ck"+chk);
								//((SaveTempData)getApplication()).SaveWhenData(HngName,Discription,StartTime,EndTime,chk);
								SaveTempData STD =new SaveTempData();
								 
								STD.SaveWhenData(HngName,Discription,StartTime,EndTime,chk);
								//System.out.println("done"+data);
								i=new Intent(Add_hngout_When.this,Add_hngout_where.class);
								startActivity(i);
								break;
							
							case R.id.baddtime:
								
								break;
		}
	}
	 
 



}
