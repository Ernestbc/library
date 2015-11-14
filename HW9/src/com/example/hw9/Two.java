package com.example.hw9;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Two extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two);
		selectMP3();
	}
	
	@SuppressWarnings("deprecation")
	private void selectMP3(){
		ContentResolver resolver=getContentResolver();
		String[] projection={MediaStore.Video.Media._ID,MediaStore.Video.Media.DISPLAY_NAME};
        Cursor cursor=resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, projection, null, null, null);
        ListView listView=(ListView) findViewById(R.id.listView2);
//        Log.i("test", MediaStore.Video.Media.TITLE);
        listView.setAdapter(new SimpleCursorAdapter(
        		getApplicationContext(), R.layout.twoitem, cursor, projection, 
        		new int[]{R.id.textView21,R.id.textView22}));
	}
	
	
	
}
