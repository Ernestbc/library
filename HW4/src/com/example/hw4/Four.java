package com.example.hw4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Four extends Activity {

	ImageView iv;
	SeekBar sb;
	boolean flag;

	int[] image = new int[] { R.drawable.d, R.drawable.e, R.drawable.f,R.drawable.fgn, R.drawable.fr, R.drawable.w };
	int num=0;
	private static final int OK=0011;
	
	private Handler handler=new Handler(){
		public void handleMessage(Message msg){
			switch(msg.what){
			case OK:
				Log.i("test","222");
				iv.setImageResource(image[num++%6]);
				break;
			default:
				break;
			}
		}
	};
	
	class A extends Thread{
		@Override
		public void run() {
			while(true){
				try {
					Log.i("test","111");
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				handler.sendEmptyMessage(OK);
				super.run();
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.four);
		iv=(ImageView)findViewById(R.id.imageView1);
		sb=(SeekBar)findViewById(R.id.seekBar1);
		new A().start();
	}
	
	

//	public void back(View v) {
//		Intent intent = new Intent(Four.this, MainActivity.class);
//		startActivity(intent);
//		finish();
//	}
}
