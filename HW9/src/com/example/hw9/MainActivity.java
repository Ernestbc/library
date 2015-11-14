package com.example.hw9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener{
	
	Button btn1;
	Button btn2;
	Button btn3;
	
	private void init(){
		btn1=(Button)findViewById(R.id.Button1);
		btn2=(Button)findViewById(R.id.Button2);
		btn3=(Button)findViewById(R.id.Button3);
	}
	
	private void listener(){
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        listener();
    }

	@Override
	public void onClick(View v) {
		Intent intent=new Intent();
		switch (v.getId()) {
		case R.id.Button1:
			intent.setAction("one");
			startActivity(intent);
			finish();
			break;
		case R.id.Button2:
			intent.setAction("two");
			startActivity(intent);
			finish();
			break;
		case R.id.Button3:
			intent.setAction("three");
			startActivity(intent);
			finish();
			break;

		default:
			break;
		}
		
	}

    
}
