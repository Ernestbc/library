package com.example.hw7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ThreeStartReceiver extends BroadcastReceiver {

	/**
	 * ���չ㲥
	 */
	@Override
	public void onReceive(Context context, Intent intent) {
		//������յ��Ĺ㲥�ǿ����㲥���Զ�����activity
//		if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
			Intent lll=new Intent(context,MainActivity.class);//�½�activity
			lll.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(lll);//��ʼactivity
			
			Toast.makeText(context, "���������绰����", Toast.LENGTH_SHORT).show();
//		}
	}

}
