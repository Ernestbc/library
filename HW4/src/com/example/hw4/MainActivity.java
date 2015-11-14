package com.example.hw4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void demo1(View v) {
		Log.w("test", "i'm the first");
		Intent intent=new Intent(MainActivity.this,One.class);
		startActivity(intent);
		finish();
	}
	
	public void demo2(View v){
		Log.d("test", "i'm the second");
		Intent intent=new Intent(MainActivity.this,Two.class);
		startActivity(intent);
		finish();
	}
	
	public void demo3(View v){
		Log.d("test", "i'm the third");
		Intent intent=new Intent(MainActivity.this,Three.class);
		startActivity(intent);
		finish();
	}
	
	public void demo4(View v){
		Log.d("test", "i'm the forth");
		Intent intent=new Intent(MainActivity.this,Five.class);
		startActivity(intent);
		finish();
	}
    
}
