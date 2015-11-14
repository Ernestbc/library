package com.example.hw9;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Profile;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Three extends Activity implements OnClickListener {

	private static final String TABLE_NAME = "student";
	private static final String STUDENT_ID = "student_id";
	private static final String STUDENT_NAME = "student_name";
	private static final String STUDENT_AGE = "student_age";
	private static final String STUDENT_SCORE = "student_score";
	
	private static final Uri uri=Uri.parse("content://"+"com.example.a");

	Button btninsert;
	Button btnback;

	String student_name;
	int student_age;
	int student_score;

	private void init() {
		btninsert = (Button) findViewById(R.id.btn33);
		btnback = (Button) findViewById(R.id.btn3back);
	}

	private void listener() {
		btninsert.setOnClickListener(this);
		btnback.setOnClickListener(this);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.three);
		init();
		listener();
		

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn33:
			Student s=new Student("张三", 20, 150);
			insertStudent(s);
			selectAllStudent(s);
			break;
		
		case R.id.btn3back:
			Intent intent=new Intent(this,MainActivity.class);
			startActivity(intent);
			finish();
			break;

		default:
			break;
		}

	}

	
	/**
	 * 查找所有
	 */
	@SuppressWarnings("deprecation")
	private void selectAllStudent(Student s) {
		Cursor cursor = getContentResolver().query(uri,  null, null,null, null);
		// StringBuffer sb=new StringBuffer();
		
			// int count=cursor.getColumnCount();
			// for(int i=0;i<count;i++){
			// sb.append(cursor.getString(i)+"|");
			// }
			// sb.append("\n");
			
		String[] projection={s.getName(),s.getAge()+"",s.getScore()+""};//4项数据
		ListView listView=(ListView) findViewById(R.id.listView3);
        listView.setAdapter(new SimpleCursorAdapter(
        		getApplicationContext(), R.layout.threeitem, cursor, projection, 
        		new int[]{R.id.tvname,R.id.tvage,R.id.tvscore}));
	}

	

	/**
	 * 添加数据库
	 * 
	 * @param s
	 */
	private void insertStudent(Student s) {

		ContentValues values = new ContentValues();
		values.put(STUDENT_NAME, s.getName());
		values.put(STUDENT_AGE, s.getAge());
		values.put(STUDENT_SCORE, s.getScore());
		getContentResolver().insert(uri, values);
		
	}
	
	
}
