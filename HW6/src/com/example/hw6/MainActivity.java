package com.example.hw6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void one(View v) {
		Intent intent=new Intent();
		intent.setAction("One");
		startActivity(intent);
		finish();

	}

	public void two(View v) {

	}

	public void three(View v) {

	}

}
