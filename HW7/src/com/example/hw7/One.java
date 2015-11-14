package com.example.hw7;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class One extends Activity implements OnClickListener {
	private Button btnstaticStart;
	private Button btntrendStart;
	private Button btnStop;

	BroadcastReceiver receiver;
	IntentFilter filter;
	private boolean flag = true;
	private boolean w = true;

	private void init() {
		btnstaticStart = (Button) findViewById(R.id.btn11);
		btnStop = (Button) findViewById(R.id.btn12);
		btntrendStart = (Button) findViewById(R.id.btn13);
	}

	private void listener() {
		btnstaticStart.setOnClickListener((OnClickListener) this);
		btnStop.setOnClickListener((OnClickListener) this);
		btntrendStart.setOnClickListener((OnClickListener) this);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.one);
		receiver = new OneReceiver();
		filter = new IntentFilter("trendReceiver");

		init();
		listener();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn11:
			sendBroadcast(new Intent("receiver_one"));//静态注册
			w = false;
			break;
		case R.id.btn13:
			if (flag) {
				registerReceiver(receiver, filter);//注册
				sendBroadcast(new Intent("trendReceiver"));//动态注册
				flag = false;
			} else {
				Toast.makeText(this, "已经激活，请先销毁", 300).show();
			}
			break;
		case R.id.btn12:
			if (flag == false) {
				unregisterReceiver(receiver);//销毁
				Toast.makeText(this, "销毁", 300).show();
				flag = true;
			}else if(w==false){
				Toast.makeText(this, "静态注册激活，不用该销毁", 300).show();
			} else {
				Toast.makeText(this, "请先激活", 300).show();
			}
			break;

		default:
			break;
		}
	}

}
