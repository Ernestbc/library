package com.example.hw7;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	
	//�����ؼ�����
	private Button btn1;
	private Button btn2;
	private Button btn3;
	
	
	
	SharedPreferences preferences;
	SharedPreferences.Editor editor;
	
	EditText et1;
	EditText et2;
	private Button btn4;
	private Button btn5;

	/**
	 * �����ؼ�����
	 */
	private void init() {
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		
		
		
		et1=(EditText)findViewById(R.id.editText1);
		et2=(EditText)findViewById(R.id.editText2);
		btn4 = (Button) findViewById(R.id.button);
		btn5 = (Button) findViewById(R.id.button666);
	}

	/**
	 * �����ؼ�����
	 */
	private void listener() {
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		
//		tm.listen(new ThreePhoneListener(), PhoneStateListener.LISTEN_CALL_STATE);
	}

	//������ǰactivity
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		listener();
		
		/*
		 * ��������������
		 */
		preferences = getSharedPreferences("count", MODE_WORLD_READABLE);
		editor=preferences.edit();
		int count=preferences.getInt("count",0);
		Toast.makeText(this, "������"+count+"��", Toast.LENGTH_SHORT).show();
		editor.putInt("count", ++count);
		
//		String name=preferences.getString("", defValue);
		
		editor.commit();//������
		
	}

	//����¼�����
	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.btn1://��ʼ��1��
			intent.setAction("action_one");
			startActivity(intent);
			finish();
			break;
		case R.id.btn2://��ʼ��2��
			intent.setAction("action_two");
			startActivity(intent);
			finish();
			break;
		case R.id.btn3://��ʼ��3��
			sendBroadcast(new Intent("start"));//��̬ע��
			break;
		default:
			break;
		}
	}
    
}
