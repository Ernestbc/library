package com.example.hw5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class One_2 extends Activity {

	EditText et1;
	RadioGroup rg;
	private double height;
	private double weight;

	private int OK;

	private void init() {
		et1 = (EditText) findViewById(R.id.et1);
		rg = (RadioGroup) findViewById(R.id.radioGroup1);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.one_2);
//		getIntent();//������ǰintent
		init();

		rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.radio0:
					OK = 1;
					break;
				case R.id.radio1:
					OK = 2;
					break;
				default:
					OK=0;
					break;
				}
			}
		});
	}

	public void calculate(View v) {
		if (et1.getText().length() != 0) {
			if (OK!=0) {
				try {
					height = Double.valueOf(et1.getText() + "");
//					Log.i("test", height + ":555");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}

				if (OK == 1) {
					weight = (height - 80) * 0.7;
					Log.i("test", weight + ":111");
				} else if (OK == 2) {
					weight = (height - 70) * 0.6;
					Log.i("test", weight + ":222");
				}
				//�ش�����
				Intent intent = new Intent(this, One_1.class);
				intent.putExtra("weight", weight);
				
				//������
//				Person p=new Person("lalala",13);
//				Bundle extras=new Bundle();
//				extras.putSerializable("person", p);
//				Log.i("test", p+"");
//				intent.putExtras(extras);
//				intent.putExtra("data",);
				setResult(Activity.RESULT_OK, intent);
				startActivity(intent);
				
				finish();//û��finish()�����޷�����
			} else {
				Toast.makeText(this, "�Ա𲻿�Ϊ��", Toast.LENGTH_SHORT).show();
			}
		} else {
			Toast.makeText(this, "��߲���Ϊ��", Toast.LENGTH_SHORT).show();
		}

	}
}
