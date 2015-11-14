package com.example.hw5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Two_2 extends Activity {
	TextView tv2;
	ProgressBar pb;
	private boolean isExit = false;

	private void init() {
		tv2 = (TextView) findViewById(R.id.tv2_2);
		pb = (ProgressBar) findViewById(R.id.progressBar1);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_2);
		init();
		Intent intent = getIntent();
		String name = intent.getStringExtra("name");
		int num = intent.getIntExtra("num", 0);
		tv2.setText("测试结果是：\n" + name + "：您的RP值为：" + num);
		pb.setProgress(num);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			QuitApp();
			return false;
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}

	/**
	 * 退出app方法
	 */
	private void QuitApp() {
		if(isExit){
			Intent intent=new Intent(this,MainActivity.class);
			startActivity(intent);
			finish();
			System.exit(0);
		}else{
			isExit=true;
			Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
			handler.sendEmptyMessageDelayed(0, 1000);
		}
	}
	
	//开线程处理
	Handler handler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
//			isExit=false;
		}
		
	};

}
