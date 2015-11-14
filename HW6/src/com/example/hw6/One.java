package com.example.hw6;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class One extends Activity {
	boolean b=true;
	OneService.back binder;
	Timer timer = new Timer();
	
	TimerTask task = new TimerTask() {
		
		@Override
		public void run() {
			Log.i("test", ""+binder.getM());
		}
	};
	
	ServiceConnection conn=new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			binder=(OneService.back) service;
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.one);
	}

	public void start(View v) {
		Intent intent=new Intent("oneservice");
//		intent.putExtra("test", "111");//传值没问题
//		startService(intent);
		bindService(intent, conn, BIND_AUTO_CREATE);
		timer.schedule(task, 0, 1000);
		
		
	}

	public void stop(View v) {
		unbindService(conn);
//		Intent intent=new Intent("oneservice");
//		stopService(intent);
	}
	
	
}
