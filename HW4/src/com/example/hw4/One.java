package com.example.hw4;

import com.example.hw4.R.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class One extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.one);
	}

	public void click1(View v) {

		new AlertDialog.Builder(One.this)
		.setMessage("对话框内容，带仨按钮")
		.setTitle("标题")
		.setPositiveButton("取消", null)
		.setNeutralButton("中间", null)
		.setNegativeButton("确定", null)
		.show();
	}

	public void click2(View v) {
		String[] style={"摇滚","流行","古典"};
		new AlertDialog.Builder(One.this)
		.setItems(style, null)
		.setTitle("风格")
		.show();
	}

	public void click3(View v) {
		String[] style={"男","女","妖"};
		new AlertDialog.Builder(One.this)
		.setSingleChoiceItems(style, style.length, null)
		.setTitle("性别")
		.show();
		
	}

	public void click4(View v) {
		String[] style={"Java","C","PHP"};
		new AlertDialog.Builder(One.this)
		.setMultiChoiceItems(style, null, null)
		.setTitle("选书")
		.setPositiveButton("提交", null)
		.show();
	}

	public void click5(View v) {
		View view=LayoutInflater.from(One.this).inflate(R.layout.one5,null);
		new AlertDialog.Builder(One.this)
		.setTitle("进度条")
		.setView(view)
		.show();
		
	}

	public void click6(View v) {
		View view=LayoutInflater.from(One.this).inflate(R.layout.one6,null);
		new AlertDialog.Builder(One.this)
		.setTitle("进度条")
		.setView(view)
		.show();
	}
	
	public void click7(View v) {
		View view=LayoutInflater.from(One.this).inflate(R.layout.one7,null);
		new AlertDialog.Builder(One.this)
		.setTitle("进度条")
		.setView(view)
		.setPositiveButton("取消", null)
		.setNegativeButton("确定", null)
		.show();
	}

	public void back(View v) {
		Intent intent = new Intent(One.this, MainActivity.class);
		startActivity(intent);
		finish();
	}
}
