package com.example.hw5;

import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Three_1 extends Activity {

	EditText et3_1;
	EditText et3_2;
	private String phonenum;
	private String msg;
	int c = 0;

	private void init() {
		et3_1 = (EditText) findViewById(R.id.et3_1);
		et3_2 = (EditText) findViewById(R.id.et3_2);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.three_1);
		init();

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == RESULT_FIRST_USER
				&& resultCode == Activity.RESULT_OK) {
			if (data.getStringExtra("phone") == null) {
				et3_1.setText(phonenum);
			} else {
				phonenum = data.getStringExtra("phone");
				et3_1.setText(phonenum);
			}
			if (data.getStringExtra("msg") == null) {
				et3_2.setText(msg);
			} else {
				msg = data.getStringExtra("msg");
				et3_2.setText(msg);
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	/**
	 * 选号码
	 * 
	 * @param v
	 */
	public void choosenum(View v) {
		Intent intent = new Intent("Three_2");
		startActivityForResult(intent, RESULT_FIRST_USER);
	}

	/**
	 * 选消息
	 * 
	 * @param v
	 */
	public void choosemsg(View v) {
		Intent intent = new Intent("Three_3");
		startActivityForResult(intent, RESULT_FIRST_USER);
	}

	/**
	 * 发消息
	 * 
	 * @param v
	 */
	public void sendmsg(View v) {
		if (phonenum != null && msg != null) {
			while (c < 5) {
				SmsManager smsManager = SmsManager.getDefault();
				if (msg.length() > 70) {// 短信大于70字符自动分割
					List<String> contents = smsManager.divideMessage(msg);
					for (String sms : contents) {
						smsManager.sendTextMessage(phonenum, null, sms, null,
								null);
						// 再写一遍

					}
				} else {
					smsManager.sendTextMessage(phonenum, null, msg, null, null);

					try {
						ContentValues values = new ContentValues();
						values.put("address", phonenum);
						values.put("body", msg);
						this.getContentResolver().insert(
								Uri.parse("content://sms/sent"), values);
						c++;
						Toast.makeText(this, "短信已发送，请查看发件箱", Toast.LENGTH_SHORT).show();
						int randomnum = (int) (Math.random() * 10);
						try {
							Thread.sleep(randomnum*60000);
							Log.i("test", randomnum+"");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		} else {
			Toast.makeText(this, "电话与短信内容不可为空", Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * 返回
	 * 
	 * @param v
	 */
	public void back(View v) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
		finish();
	}
}
