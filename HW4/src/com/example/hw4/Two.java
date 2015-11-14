package com.example.hw4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Two extends Activity {
	
	private EditText et;
	private ProgressBar pb;
	private TextView tv;
	
	private boolean Flag=true;
	private boolean order=true;
	private static final int OK=123;
	int progress=0;
	int p;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		et=(EditText)findViewById(R.id.et2);
		pb=(ProgressBar)findViewById(R.id.progressBar2);
		tv=(TextView)findViewById(R.id.tv2);
		pb.setProgress(80);
	}
	
	public void startMethod(View v){
		if(et.getText()!=null){
			p=Integer.parseInt(et.getText()+"");
			pb.setMax(p);
			Flag=true;
			new startT().start();
		}else{
			
		}
		
	}
	
	public void stopMethod(View v) {
		Flag = false;
	}
	
	
	
	class startT extends Thread{

		@Override
		public void run() {
			while(Flag){
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					handler.sendEmptyMessage(OK);
				}
			}
			super.run();
		}
	}
	
	private Handler handler=new Handler(){
		public void a(Message msg){
			switch(msg.what){
			case OK:
				if(progress==pb.getMax()){
					order=false;
				}
				if(progress==0){
					order=true;
				}
				if(order){
					pb.setProgress(progress);
					tv.setText(progress+"%");
					progress++;
				}else{
					pb.setProgress(progress);
					tv.setText(progress+"%");
					progress--;
				}
				break;
			default:
				break;
			}
		}
	};
	
	public void sureMethod(View v) {
		if(et.getText()!=null){
			progress=p;
			if(progress>100||progress<0){
				
			}else{
				pb.setProgress(progress);
				tv.setText(progress+"");
			}
		}
	}
	

	/*EditText et;
	TextView tv;
	ProgressBar pBar;

	int progress = 0;
	private static final int OK = 111;// 消息标识
	boolean FLAG = true;
	boolean order;

	// handler对象用户发送消息，解决消息
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case OK:
				if (progress == 100) {
					order = false;
				}
				if (progress == 0) {
					order = true;
				}
				if (order) {
					pBar.setProgress(progress);
					tv.setText(progress + "%");
					progress++;
				} else {
					pBar.setProgress(progress);
					tv.setText(progress + "%");
					progress--;
				}
				break;
			default:
				break;
			}
		}
	};

	private void init() {
		et = (EditText) findViewById(R.id.et2);
		tv = (TextView) findViewById(R.id.tv2);
		pBar = (ProgressBar) findViewById(R.id.progressBar2);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		init();
	}

	*//**
	 * 启动方法
	 *//*
	public void startMethod(View v) {
		FLAG=true;
		new startThread().start();//开辟一个子线程
	}

	class startThread extends Thread {

		@Override
		public void run() {
			while (FLAG) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				handler.sendEmptyMessage(OK);// 发送消息通知主线程进行界面操作
			}
			super.run();
		}
	}

	*//**
	 * 停止方法
	 *//*
	public void stopMethod(View v) {
		FLAG = false;
	}

	*//**
	 * 确定方法
	 *//*
	public void sureMethod(View v) {

		if (et.getText() != null) {
			try {
				progress = Integer.valueOf(et.getText() + "");
			} catch (NumberFormatException e) {
				Toast.makeText(this, getString(R.string.plsinputsth),
						Toast.LENGTH_SHORT).show();
				pBar.setProgress(0);
				tv.setText("0%");
			}
			if (progress > 100) {
				Toast.makeText(this, getString(R.string.plsinputnum),
						Toast.LENGTH_SHORT).show();
				pBar.setProgress(0);
				tv.setText("0%");
			} else {
				pBar.setProgress(progress);
				tv.setText(progress + "%");
			}
		}
	}

	public void back(View v) {
		Intent intent = new Intent(Two.this, MainActivity.class);
		startActivity(intent);
		finish();
	}*/
}
