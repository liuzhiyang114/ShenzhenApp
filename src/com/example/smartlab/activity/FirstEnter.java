package com.example.smartlab.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;


@SuppressLint("HandlerLeak")
public class FirstEnter extends Activity {

	private final int TIME_UP = 1;
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler()
	{
		public void handleMessage(Message msg)
		{
			if(msg.what == TIME_UP)
			{
				Intent intent = new Intent();
				intent.setClass(FirstEnter.this,ChooseArea.class);
				startActivity(intent);
				overridePendingTransition(R.anim.splash_screen_fade, R.anim.splash_screen_hold);
				FirstEnter.this.finish();
			}
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first);
		new Thread() 
		{
			public void run() 
			{
				try 
				{
					Thread.sleep(2000);
				} 
				catch (Exception e) 
				{

				}
				Message msg = new Message();
				msg.what = TIME_UP;
				handler.sendMessage(msg);
			}
		}.start();
		 
		
            
            
            
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	
}
