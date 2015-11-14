package com.example.hw7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Two extends Activity implements OnClickListener{
	private Button btnStart;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		btnStart=(Button)findViewById(R.id.btn21);
		btnStart.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		sendBroadcast(new Intent("receiver_two2"));
		
	}
}
