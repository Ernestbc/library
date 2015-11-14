package com.example.hw6;

import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class TwoService extends Service {

	int c = 0;
	boolean a = true;

	@Override
	public IBinder onBind(Intent intent) {
		// String a=intent.getStringExtra("test");//接收没问题
//		while (c<2) {
			count();
//		}
		return new back();
		// Log.i("test", a+"");
	}

	private int count() {
		c=(int)Math.random()*10;//随机数
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Log.i("test", c+"");

		return c;
	}

	// @Override
	// public int onStartCommand(Intent intent, int flags, int startId) {
	// a=true;
	// return super.onStartCommand(intent, flags, startId);
	// }

	@Override
	public void onDestroy() {
		a = false;
		super.onDestroy();
	}

	class back extends Binder {
		public int getResult() {
			return c;
		}
	}

}
