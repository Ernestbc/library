package com.example.hw9;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class One extends Activity implements OnClickListener {

	SQLiteDatabase database;
	private static final String TABLE_NAME = "student";
	private static final String STUDENT_ID = "student_id";
	private static final String STUDENT_NAME = "student_name";
	private static final String STUDENT_AGE = "student_age";
	private static final String STUDENT_SCORE = "student_score";

	EditText etid;
	EditText etname;
	EditText etage;
	EditText etscore;
	Button btninsert;
	Button btnselect;
	Button btnupdate;
	Button btndelete;
	Button btnback;

	String student_name;
	int student_age;
	int student_score;

	private void init() {
		etid = (EditText) findViewById(R.id.editText1);
		etname = (EditText) findViewById(R.id.editText2);
		etage = (EditText) findViewById(R.id.editText3);
		etscore = (EditText) findViewById(R.id.editText4);
		btninsert = (Button) findViewById(R.id.btn1);
		btndelete = (Button) findViewById(R.id.btn2);
		btnupdate = (Button) findViewById(R.id.btn3);
		btnselect = (Button) findViewById(R.id.btn4);
		btnback = (Button) findViewById(R.id.btnback);
	}

	private void listener() {
		btninsert.setOnClickListener(this);
		btnselect.setOnClickListener(this);
		btnupdate.setOnClickListener(this);
		btndelete.setOnClickListener(this);
		btnback.setOnClickListener(this);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.one);
		init();
		listener();
		A openHelper = new A(getApplicationContext(), "data.db", null, 1);
		database = openHelper.getWritableDatabase();

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			insertM();
			break;
		case R.id.btn4:
			selectM();
			break;
		case R.id.btn2:
			deleteStudent();
			break;
		case R.id.btn3:
			updateStudent();
			break;
		case R.id.btnback:
			Intent intent=new Intent(this,MainActivity.class);
			startActivity(intent);
			finish();
			break;

		default:
			break;
		}

	}

	/**
	 * 根据学号修改
	 */
	private void updateStudent() {
		ContentValues contentValues = new ContentValues();
		if (etid.getText().length() == 0) {//若学号不输入
			Toast.makeText(getApplicationContext(), "请输入学号", Toast.LENGTH_SHORT).show();
		} else {
			if (etname.getText().length() == 0 && etage.getText().length() == 0&& etscore.getText().length() == 0) {//若什么都没该改
				Toast.makeText(getApplicationContext(), "未做修改",Toast.LENGTH_SHORT).show();
			} else {
				int id = Integer.parseInt(etid.getText() + "");
				String[] whereArgs = { "" + id };
				
				if (etname.getText().length() != 0) {
					contentValues.put(STUDENT_NAME, etname.getText() + "");
					database.update(TABLE_NAME, contentValues, "student_id=?",whereArgs);
				}
				if (etage.getText().length() != 0) {
					contentValues.put(STUDENT_AGE,Integer.parseInt(etage.getText() + ""));
					database.update(TABLE_NAME, contentValues, "student_id=?",whereArgs);
				}
				if (etscore.getText().length() != 0) {
					contentValues.put(STUDENT_SCORE,Integer.parseInt(etscore.getText() + ""));
					database.update(TABLE_NAME, contentValues, "student_id=?",whereArgs);
				}
				Toast.makeText(getApplicationContext(), "修改成功",Toast.LENGTH_SHORT).show();
			}

		}

	}

	/**
	 * 根据id删除学生
	 */
	private void deleteStudent() {
		if(etid.getText().length() == 0){
			Toast.makeText(getApplicationContext(), "请输入学号", Toast.LENGTH_SHORT).show();
		}else{
			int id = Integer.parseInt(etid.getText() + "");
			String[] whereArgs = { "" + id };
			database.delete(TABLE_NAME, "student_id=?", whereArgs);
			Toast.makeText(getApplicationContext(), "删除成功", Toast.LENGTH_SHORT).show();
			
		}
	}

	/**
	 * 查找方式选择
	 */
	private void selectM() {
		if (etid.getText().length() != 0) {
			selectStudent();
		} else {
			selectAllStudent();
		}
	}

	/**
	 * 查找所有
	 */
	private void selectAllStudent() {
		Cursor cursor = database.query(TABLE_NAME, null, null, null, null,null, null);
		// StringBuffer sb=new StringBuffer();
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			Student selall = new Student(cursor.getInt(cursor.getColumnIndex(STUDENT_ID)), 
					cursor.getString(cursor.getColumnIndex(STUDENT_NAME)), 
					cursor.getInt(cursor.getColumnIndex(STUDENT_AGE)), 
					cursor.getInt(cursor.getColumnIndex(STUDENT_SCORE)));
			// int count=cursor.getColumnCount();
			// for(int i=0;i<count;i++){
			// sb.append(cursor.getString(i)+"|");
			// }
			// sb.append("\n");
			Log.i("test", selall.toString());
		}
	}

	/**
	 * 根据学号查找
	 */
	private void selectStudent() {
		int id = Integer.parseInt(etid.getText() + "");
		String[] selectById = { "" + id };
		Cursor cursor = database.query(TABLE_NAME, null, "student_id=?",
				selectById, null, null, null);
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			Student selall = new Student(cursor.getInt(cursor.getColumnIndex(STUDENT_ID)), 
					cursor.getString(cursor.getColumnIndex(STUDENT_NAME)), 
					cursor.getInt(cursor.getColumnIndex(STUDENT_AGE)), 
					cursor.getInt(cursor.getColumnIndex(STUDENT_SCORE)));
			Log.i("test", selall.toString());
			etname.setText(selall.getName());
			etage.setText(selall.getAge() + "");
			etscore.setText(selall.getScore() + "");
		}
	}

	/**
	 * 添加数据库
	 * 
	 * @param s
	 */
	private void insertStudent() {
		student_name = (etname.getText() + "");
		student_age = Integer.parseInt(etage.getText() + "");
		student_score = Integer.parseInt(etscore.getText() + "");
		Student s = new Student(student_name, student_age, student_score);

		ContentValues values = new ContentValues();
		values.put(STUDENT_NAME, s.getName());
		values.put(STUDENT_AGE, s.getAge());
		values.put(STUDENT_SCORE, s.getScore());
		database.insert(TABLE_NAME, null, values);
	}

	/**
	 * 添加判定
	 */
	private void insertM() {
		if (etname.getText().length() == 0  
				|| etage.getText().length() == 0
				|| etscore.getText().length() == 0) {
			Toast.makeText(getApplicationContext(), "不可为空", Toast.LENGTH_SHORT).show();
		} else {
			student_age = Integer.parseInt(etage.getText() + "");
			student_score = Integer.parseInt(etscore.getText() + "");
			if (student_age < 18 || student_age > 100) {
				Toast.makeText(getApplicationContext(), "年龄超范围",Toast.LENGTH_SHORT).show();
			} else if (student_score > 150) {
				Toast.makeText(getApplicationContext(), "分数超范围",Toast.LENGTH_SHORT).show();
			} else {
				insertStudent();
				Toast.makeText(getApplicationContext(), "添加成功",Toast.LENGTH_SHORT).show();
			}
		}
	}

	/**
	 * 判定数据库的类
	 * openHelper
	 * @author MBENBEN
	 *
	 */
	class A extends SQLiteOpenHelper {

		/**
		 * 构造方法
		 * @param context
		 * @param name
		 * @param factory
		 * @param version
		 */
		public A(Context context, String name, CursorFactory factory,
				int version) {
			super(context, name, factory, version);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			final String create_table_cmd = "CREATE TABLE " + TABLE_NAME + "("
					+ STUDENT_ID + " Integer primary key autoincrement,"
					+ STUDENT_NAME + " String," + STUDENT_AGE + " Integer,"
					+ STUDENT_SCORE + " Integer)";
			db.execSQL(create_table_cmd);
			Toast.makeText(getApplicationContext(), "数据库已创建",Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub

		}
	}
	
	
	
}
