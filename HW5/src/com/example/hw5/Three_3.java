package com.example.hw5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Three_3 extends Activity {

	String[] mesg;
	ListView lv2;
	
	private void init(){
		lv2=(ListView)findViewById(R.id.listView2);
		mesg=getResources().getStringArray(R.array.msg);//关联数据源
		Log.i("test", mesg.length+"");
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.three_3);
		init();
		
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, 
				android.R.layout.activity_list_item, 
				android.R.id.text1, 
				mesg);
		
		lv2.setAdapter(adapter);
		
		lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				String msg=mesg[position];//得到点击的项内容
				Log.i("test", msg+"");
				Intent intent = new Intent();//传参
				intent.putExtra("msg", msg);
				setResult(RESULT_OK, intent);
//				startActivity(intent);
				finish();
			}
			
		});
	}
}
