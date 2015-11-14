package com.example.hw7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ThreeStartReceiver extends BroadcastReceiver {

	/**
	 * 接收广播
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		//如果接收到的广播是开机广播，自动启动activity
//		if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
			Intent lll=new Intent(context,MainActivity.class);//新建activity
			lll.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(lll);//开始activity
			
			Toast.makeText(context, "开启监听电话功能", Toast.LENGTH_SHORT).show();
//		}
	}

}
