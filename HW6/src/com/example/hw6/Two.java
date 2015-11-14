package com.example.hw6;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class Two extends Activity {
	View v;
	int color;
	
	ServiceConnection conn=new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			TwoService.back binder=(TwoService.back)service;
			color=binder.getResult();
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		v=(View)findViewById(R.layout.two);

	}

	public void start2() {

		Intent intent=new Intent("oneservice");
		bindService(intent, conn, BIND_AUTO_CREATE);
	}

	public void set2() {

		switch(color){
		case 1:
			v.setBackgroundColor(Color.RED);
			break;
		case 2:
			v.setBackgroundColor(Color.GREEN);
			break;
		case 3:
			v.setBackgroundColor(Color.BLUE);
			break;
		default:
			break;
		}
	}

	public void stop2() {

		unbindService(conn);
		
	}

}
