package com.example.hw8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Two extends Activity {

	private RadioGroup rg1;
	private RadioGroup rg2;
	private RadioButton rgbs15, rgbs30, rgbs45, rgcor, rgcog, rgcob;

	private TextView tv;

	int bs;
	int co;

	private void init() {
		rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
		rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
		tv = (TextView) findViewById(R.id.textView2);
		rgbs15 = (RadioButton) findViewById(R.id.radio15sp);
		rgbs30 = (RadioButton) findViewById(R.id.radio30sp);
		rgbs45 = (RadioButton) findViewById(R.id.radio45sp);
		rgcor = (RadioButton) findViewById(R.id.radiored);
		rgcog = (RadioButton) findViewById(R.id.radiogreen);
		rgcob = (RadioButton) findViewById(R.id.radioblue);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		init();

		radioChoose listener = new radioChoose();

		rg1.setOnCheckedChangeListener(listener);
		rg2.setOnCheckedChangeListener(listener);

		
		tv.setTextSize(bs);
		tv.setTextColor(co);
	}

	@Override
	protected void onStart() {
		try {
			InputStream is1 = openFileInput("size");
			InputStream is2 = openFileInput("color");
			StringBuffer sb1 = new StringBuffer();
			StringBuffer sb2 = new StringBuffer();
			int c = 0;
			while ((c = is1.read()) != -1) {
				sb1.append((char) c);
			}
			while ((c = is2.read()) != -1) {
				sb2.append((char) c);
			}
			bs=Integer.parseInt(sb1+"");
			co=Integer.parseInt(sb2+"");
			tv.setTextSize(bs);
			tv.setTextColor(co);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		switch (bs) {
		case 15:
			rgbs15.setChecked(true);
			break;
		case 30:
			rgbs30.setChecked(true);
			break;
		case 45:
			rgbs45.setChecked(true);
			break;

		default:
			break;
		}

		switch (co) {
		case Color.RED:
			rgcor.setChecked(true);
			break;
		case Color.GREEN:
			rgcog.setChecked(true);
			break;
		case Color.BLUE:
			rgcob.setChecked(true);
			break;

		default:
			break;
		}

		super.onStart();
	}

	@Override
	protected void onStop() {

		super.onStop();
	}

	class radioChoose implements OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {

			switch (checkedId) {
			case R.id.radio15sp:
				tv.setTextSize(15);
				bs = 15;
				save1();
				break;
			case R.id.radio30sp:
				tv.setTextSize(30);
				bs = 30;
				save1();
				break;
			case R.id.radio45sp:
				tv.setTextSize(45);
				bs = 45;
				save1();
				break;

			case R.id.radiored:
				tv.setTextColor(Color.RED);
				co = Color.RED;
				save2();
				break;
			case R.id.radiogreen:
				tv.setTextColor(Color.GREEN);
				co = Color.GREEN;
				save2();
				break;
			case R.id.radioblue:
				tv.setTextColor(Color.BLUE);
				co = Color.BLUE;
				save2();
				break;

			default:
				break;
			}
		}
	}
	
	private void save1(){
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			try {
				OutputStream os1 = openFileOutput("size", MODE_PRIVATE);
				
				String buffer1 = bs + "";
				
				os1.write(buffer1.getBytes());
				
				os1.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	private void save2(){
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			try {
				
				OutputStream os2 = openFileOutput("color", MODE_PRIVATE);
				
				String buffer2 = co + "";
				
				os2.write(buffer2.getBytes());
				
				os2.close();
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
