package com.example.hw4;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class Five extends Activity {
	
	TextView t1;
	TextView t2;
	TextView t3;
	TextView t4;
	int[] color=new int[]{Color.BLUE,Color.CYAN,Color.YELLOW,Color.GREEN};
	int c=0;
	private static final int OK=8888;
	
//	class B extends TextView{
//
//		public B(Context context, AttributeSet attrs, int defStyleAttr,int defStyleRes) {
//			super(context, attrs, defStyleAttr, defStyleRes);
//			// TODO Auto-generated constructor stub
//		}
//		
//		TextView t1=(TextView)findViewById(R.id.t1);
//		
//		
//	}
	
	private Handler handler=new Handler(){
		public void handleMessage(Message msg){
			switch(msg.what){
			case OK:
				Drawable a=t1.getBackground();
				t1.setBackgroundDrawable(t2.getBackground());
				t2.setBackgroundDrawable(t3.getBackground());
				t3.setBackgroundDrawable(t4.getBackground());
				t4.setBackgroundDrawable(a);
				
//				t1.setBackgroundColor(color[c%color.length]);
//				t2.setBackgroundColor(color[(c+1)%color.length]);
//				t3.setBackgroundColor(color[(c+2)%color.length]);
//				t4.setBackgroundColor(color[(c+3)%color.length]);
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
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				handler.sendEmptyMessage(OK);
				super.run();
			}
		}
	}
	
	private void init(){
		t1=(TextView)findViewById(R.id.t1);
		t2=(TextView)findViewById(R.id.t2);
		t3=(TextView)findViewById(R.id.t3);
		t4=(TextView)findViewById(R.id.t4);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.five);
		init();
		new A().start();
	}
	
	
}
