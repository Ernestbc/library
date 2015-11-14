package com.example.hw5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void demo1(View v) {
//		Intent intent=new Intent(MainActivity.this,One_1.class);//显式启动
    	//隐式启动
    	Intent intent=new Intent();
    	intent.setAction("One_1");
		startActivity(intent);
		finish();
	}
	
	public void demo2(View v){
//		Intent intent=new Intent(MainActivity.this,Two_1.class);
		Intent intent=new Intent();
    	intent.setAction("Two_1");
		startActivity(intent);
		finish();
	}
	
	public void demo3(View v){
//		Intent intent=new Intent(MainActivity.this,Three.class);
		Intent intent=new Intent();
    	intent.setAction("Three_1");
		startActivity(intent);
		finish();
	}
    
}
