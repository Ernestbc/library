package com.example.hw7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TwoReceiver1 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals("receiver_two1")) {
			Student s = (Student) intent.getSerializableExtra("student");
			Toast.makeText(context, s + "", Toast.LENGTH_SHORT).show();
		}
	}

}
