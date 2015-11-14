package com.example.hw7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 接收广播
 * @author MBENBEN
 *
 */
public class OneReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "开始广播", 300).show();
	}

}
