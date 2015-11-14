package com.example.hw5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class One_1 extends Activity {
	TextView tv1;
	private double a;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.one_1);
		tv1=(TextView)findViewById(R.id.tv1);
//		Intent intent = getIntent();
////		Log.i("test", a+":666");
//		Bundle extras = intent.getExtras();
//		Log.i("test", "222");
//		Person p = (Person) extras.getSerializable("person");
//		tv1.setText(p.getName()+"+"+p.getAge());
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == RESULT_FIRST_USER&& resultCode == Activity.RESULT_OK) {
			a=data.getDoubleExtra("weight", 0);
			if(a!=0.0){
				tv1.setText(a+"");
			}else{
				tv1.setText("");
			}
		}
		
//		Bundle res=data.getBundleExtra("data");
//		Bundle res=data.getExtras();
//		Log.i("test", res + ":111");
//		Person p=(Person)res.getSerializable("person");
//		Log.i("test", p + ":222");
//		tv1.setText(p.getName()+"+"+p.getAge());
		
	}

	public void open(View v) {
//		Intent intent=new Intent(this,One_2.class);//类加载
		Intent intent=new Intent();
    	intent.setAction("One_2");
    	startActivityForResult(intent, RESULT_FIRST_USER);
		startActivity(intent);//启动
		finish();
	}

	public void back(View v) {
		Intent intent=new Intent(this,MainActivity.class);
		startActivity(intent);
//    	intent.setAction("android.intent.action.MAIN");
		finish();
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
	}
	
	@Override
	protected void onStart() {
//		Log.i("test", "start");
		super.onStart();
	}
	
	@Override
	protected void onRestart() {
//		Log.i("test", "restart");
		super.onRestart();
	}
	
	@Override
	protected void onStop() {
//		Log.i("test", "stop");
		super.onStop();
	}


	@Override
	protected void onResume() {
//		Toast.makeText(this, "这是一个删不掉的程序", Toast.LENGTH_SHORT).show();
//		Intent intent=new Intent(this,One_1.class);
//		startActivity(intent);
//		Log.i("test", "resume");
		super.onResume();
	}

	@Override
	protected void onPause() {
//		Log.i("test", "pause");
//		Intent intent=new Intent(this,One_1.class);
//		startActivity(intent);
		super.onPause();
	}

	@Override
	protected void onDestroy() {
//		Log.i("test", "destory");
		super.onDestroy();
	}

}
