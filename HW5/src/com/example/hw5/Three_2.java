package com.example.hw5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Three_2 extends Activity {

	String[] phonenum;
	ListView lv1;
	String msg;
	
	private void init(){
		lv1=(ListView)findViewById(R.id.listView1);
		phonenum=getResources().getStringArray(R.array.phone);//关联数据源
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.three_2);
		init();
		
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, 
				android.R.layout.activity_list_item, 
				android.R.id.text1, 
				phonenum);
		
		lv1.setAdapter(adapter);
		
		lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				String num=phonenum[position];//得到点击的项内容
				Log.i("test", num+"");
				Intent intent = new Intent();//传参
				intent.putExtra("phone", num);
				setResult(Activity.RESULT_OK, intent);
//				startActivity(intent);
				finish();
			}
			
		});
	}
}
