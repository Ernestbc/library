package com.example.hw3;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class One extends Activity {

	ListView listView;
	List<String> dataone=new ArrayList<String>();
	
	private int judge(int num){
		int picid;
		if(num<=3){
			picid=R.drawable.p_1;
		}else if(num>3&&num<5){
			picid=R.drawable.p_2;
		}else{
			picid=R.drawable.p_3;
		}
		return picid;
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.one);
		
		String[] arr=getResources().getStringArray(R.array.onelist);
		
		for(int i=0;i<arr.length;i++){
			dataone.add(arr[i]);
		}
		
		listView=(ListView)findViewById(R.id.listView1);
		listView.setAdapter(new A());
	}
	
	class A extends BaseAdapter{
		
		/**
		 * 项数
		 */
		@Override
		public int getCount() {
			return dataone.size();
		}
		
		/**
		 * 返回项视图
		 */
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		
		/**
		 * 返回项id
		 */
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		
		/**
		 * 返回项view
		 */
		public View getView(int position, View convertView, ViewGroup parent) {
			// 布局文件解析成view
			LayoutInflater inflater=getLayoutInflater();
//			LayoutInflater.from(One.this).inflate(R.layout.oneitem);
			View view = null;
			if(view==null){
			view=inflater.inflate(R.layout.oneitem, parent,false);
			}
			//查找到相应的控件
			TextView tv=(TextView) view.findViewById(R.id.tvone);
			ImageView iv=(ImageView)view.findViewById(R.id.ivone);
			//设置显示的内容
			tv.setText(dataone.get(position));
			iv.setImageResource(judge(dataone.get(position).length()));
			return view;
		}
		
		/**
		 * 优化类
		 * @author MBENBEN
		 *
		 */
		class better1{
			
		}
		
	}
}
