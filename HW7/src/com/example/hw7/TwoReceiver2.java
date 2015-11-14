package com.example.hw7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TwoReceiver2 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent a=new Intent("receiver_two1");
		a.putExtra("student", new Student("A", 23));
		context.sendBroadcast(a);
		Toast.makeText(context, "我要传值了！", Toast.LENGTH_SHORT).show();
	}
}
