package com.example.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.LauncherActivity.ListItem;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Two extends Activity {
	ListView listView;
	ListItem listItem;
	EditText editText1;
	EditText editText2;
	EditText editText3;
	View v;
	int num=-1;
	
	private void init(){
		listView=(ListView)findViewById(R.id.listView2);
//		listItem=(ListItem)findViewById(R.id.);
		editText1=(EditText)findViewById(R.id.etname);
		editText2=(EditText)findViewById(R.id.etsex);
		editText3=(EditText)findViewById(R.id.etage);
	}

//	List<Person> data=new ArrayList<Person>();
	SimpleAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		init();
//		fill();
//		adapter=new SimpleAdapter
//				(Two.this, //������
//				data, //����ԴList<Map>
//				R.layout.twoitem, //���
//				new String []{"num","name","sex","age"}, //�ֶ���
//				new int[]{R.id.textView1,R.id.textView2,R.id.textView3,R.id.textView4});//�ؼ�id
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, //
					View view,//�������Ľ���
					int position, //item��λ��
					long id) {//��id
				if(v!=null){
					v.setBackgroundColor(Color.TRANSPARENT);//͸��ɫ
				}
				/**
				 * �����Ч��
				 */
					v=view;
					num=position;
					view.setBackgroundColor(Color.YELLOW);
				
			}
		});
	}
	
//	Person map=new Person();
//	
//	void fill(){
//		
//		for(int i=0;i<data.;i++){
//			
//		}
//		
//		map=new Person();
//		map.put("name", "A");
//		map.put("sex", "��");
//		map.put("age", "23");
//		data.add(map);
//		
//		map=new Person();
//		map.put("name", "B");
//		map.put("sex", "Ů");
//		map.put("age", "12");
//		data.add(map);
//		
//	}
	
	public void refMethod(View v) {
		adapter.notifyDataSetChanged();//ˢ������
	}
	
//	public void delMethod(View v) {
//		data.remove();
//	}
	
//	public void addMethod(View v) {
//		String c1=editText1.getText()+"";
//		String c2=editText2.getText()+"";
//		String c3=editText3.getText()+"";
//		map=new HashMap<String, String>();
//		if(c1.equals("")){
//			editText1.setError("����Ϊ��");
//		}else if(c2.equals("")){
//			editText2.setError("����Ϊ��");
//		}else if(c3.equals("")){
//			editText3.setError("����Ϊ��");
//		}else{
//			map.put("name", c1);
//			map.put("sex", c2);
//			map.put("age", c3);
//			data.add(map);
//		}
//		
//		//֪ͨadapter���ݸ���
//		adapter.notifyDataSetChanged();
//	}
	
	
}
