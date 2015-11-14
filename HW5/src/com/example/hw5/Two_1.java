package com.example.hw5;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Two_1 extends Activity {
	private EditText et2;
	private int num;
	
	private void init(){
		et2=(EditText)findViewById(R.id.et2);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_1);
		init();
		
	}
	
	public void testrp(View v){
		if(et2.getText().length()!=0){
		num=(int) (Math.random()*100);
		Intent intent=new Intent(this,Two_2.class);//类加载
//		Intent intent=new Intent();
//		ComponentName component=new ComponentName(this,Two_2.class);
//		intent.setComponent(component);
		intent.putExtra("name", et2.getText()+"");
		intent.putExtra("num", num);
		startActivity(intent);//启动
		}else{
			Toast.makeText(this, "名字不可为空", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void back(View v) {
		Intent intent=new Intent(this,MainActivity.class);
		startActivity(intent);
		finish();
	}
}
