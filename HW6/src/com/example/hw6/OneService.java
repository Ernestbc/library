package com.example.hw6;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class OneService extends Service {

	int c = 0;
	boolean a = true;

	@Override
	public void onCreate() {
		super.onCreate();
		count();
		
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// String a=intent.getStringExtra("test");//接收没问题
			
			return new back();
		// Log.i("test", a+"");
	}

	private int count() {
		c++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Log.i("test", c+"");

		return c;
	}

	@Override
	public void onDestroy() {
		a = false;
		super.onDestroy();
	}

	public class back extends Binder {
		int m = c;

		public int getM() {
			return m;
		}

		public void setM(int m) {
			this.m = m;
		}
		
	}

}
