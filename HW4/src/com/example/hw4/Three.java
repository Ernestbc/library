package com.example.hw4;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Three extends Activity {
	ListView lv3;
	TextView tv3;
	RatingBar rBar;
	List<String> name=new ArrayList<String>();
	
	private void init(){
		lv3=(ListView)findViewById(R.id.listView1);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.three);
		init();
//		String[] s=getResources().getStringArray(R.array.namelist);
		//list作为数据的存储
		ArrayList<Model> list=new ArrayList<Model>();
		//循环添加入list
//		for(int i=0;i<s.length;i++){
//			list.add(new Model(i));
//		}
	}

	//根据List的位置，获得具体的list元素
	private Model getIt(int position){
		return null;
	}

	/**
	 * 作为泛型,填充数据源
	 * @author MBENBEN
	 *
	 */
	class Model{
		String text;
		float rating=2.0f;
		
		public Model(String text) {
			super();
			this.text = text;
		}

		@Override
		public String toString() {
			if(rating>2.0){
				return text.toUpperCase();
			}else{
				return text.toLowerCase();
			}
		}
	}
	
	/**
	 * 数据源
	 * @author MBENBEN
	 *
	 */
	private class Item{
		View v;
		RatingBar rb=null;
		TextView tv=null;
		
		public Item(View v) {
			this.v = v;
		}

		public RatingBar getBr() {
			if(rb==null){
				rb=(RatingBar)findViewById(R.id.rBar3);
			}
			return rb;
		}

		public TextView getTv() {
			if(tv==null){
				tv=(TextView)findViewById(R.id.tv3);
			}
			return tv;
		}
	}
	
	/**
	 * 初始化数据源(填充数据源)
	 * @param v
	 */
	void fill(){
		
	}
	
//	private class RatingAdapter extends ArrayAdapter<Model>{
//		//
////		RatingAdapter(ArrayList<Model> list){
////			
////		}
//		
//		public View getView(){
//			
//			return lv3;
//		}
//	}
	
	
	
	
	
	public void back(View v) {
		Intent intent = new Intent(Three.this, MainActivity.class);
		startActivity(intent);
		finish();
	}
}