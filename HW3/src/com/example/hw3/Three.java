package com.example.hw3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Three extends Activity {

	TextView tv;
	ImageView iv;
	ListView lv;
	View v;
	int num = -1;

	private void init() {
		tv = (TextView) findViewById(R.id.tvitem3);
		iv = (ImageView) findViewById(R.id.ivitem3);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.three);
		init();

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, 
					View view,
					int position, //����Դ��Ӧ�±���listview��Ӧ�±�
					long id) {
				if (v != null) {
					v.setBackgroundColor(Color.TRANSPARENT);// ͸��ɫ
				}
				/**
				 * �����Ч��
				 */
				v = view;
				num = position;
				view.setBackgroundColor(Color.YELLOW);
				
				//ֱ��set,ˢ��
			}
		});
	}

	// Person person=new Person(String s,int p);

	class Person {
		String name;
		int pic;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getPic() {
			return pic;
		}

		public void setPic(int pic) {
			this.pic = pic;
		}

		public Person(String name, int pic) {
			super();
			this.name = name;
			this.pic = pic;
		}

		public Person() {
			super();
		}
	}

	class A extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	/**
	 * �Ż���
	 */
	/*
	 * class viewHolder{ TextView tv; View view; public viewHolder(View v){
	 * view=v; }
	 * 
	 * public TextView getTextView(){ if(tv==null){
	 * tv=(TextView)findViewById(R.id.); }
	 * 
	 * return tv; } }
	 */

	/**
	 * ���
	 * 
	 * @param v
	 */
	public void add3(View v) {

	}

	/**
	 * ɾ��
	 * 
	 * @param v
	 */
	public void del3(View v) {

	}

	/**
	 * ȫѡ
	 * 
	 * @param v
	 */
	public void selall3(View v) {

	}

	/**
	 * ����
	 * 
	 * @param v
	 */
	public void back3(View v) {
		Intent intent = new Intent(Three.this, MainActivity.class);// ����intent����
		startActivity(intent);// ������activity
		finish();// �رյ�ǰactivity
	}
}
