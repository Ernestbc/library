package com.example.hw8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class One extends Activity implements OnClickListener {

	// 创建控件对象
	TextView tv21;
	EditText et21;
	Button btnRead;
	Button btnWrite;

	/**
	 * 控件关联方法
	 */
	private void init() {
		et21 = (EditText) findViewById(R.id.editText1);
		btnRead = (Button) findViewById(R.id.btnRead);
		btnWrite = (Button) findViewById(R.id.btnWrite);
		tv21=(TextView)findViewById(R.id.textView1);
	}

	/**
	 * 控件监听方法
	 */
	private void listenner() {
		btnRead.setOnClickListener(this);
		btnWrite.setOnClickListener(this);
	}

	/**
	 * activity创建时
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.one);
		init();
		listenner();
	}

	/**
	 * 控件点击事件
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 点击读按钮时
		case R.id.btnRead:
			load();
			break;
		// 点击写按钮时
		case R.id.btnWrite:
			save();
			break;

		default:
			break;
		}

	}

	/**
	 * 保存方法
	 */
	private void save() {

		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			try {
				File file=Environment.getExternalStorageDirectory();
				FileOutputStream fos = new FileOutputStream(file+"/DCIM/aaa.txt");//规范路径名字符串
				String msg=et21.getText()+"";
				fos.write(msg.getBytes());
				fos.flush();
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * 读取方法
	 */
	private void load() {

		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			try {
				
				File file = new File(Environment.getExternalStorageDirectory()+"/DCIM/aaa.txt");
				
				if(file.exists()){//文件存在
					StringBuffer sb=new StringBuffer();
					FileInputStream fis=new FileInputStream(file);
					BufferedReader br=new BufferedReader(new InputStreamReader(fis));
					String s=null;
					while ((s=br.readLine())!=null) {
						sb.append(s);
					}
					TextView textView = (TextView) findViewById(R.id.textView1);
					textView.setText(sb);
					fis.close();
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}
