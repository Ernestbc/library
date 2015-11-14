package com.example.hw4;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class SizeDemo extends TextView {

	/**
	 * 当控件有默认风格时
	 * @param context
	 * @param attrs
	 * @param defStyleAttr
	 */
	public SizeDemo(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		
	}
	
	/**
	 * 使用控件时
	 * @param context
	 * @param attrs
	 */
	public SizeDemo(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}
	
	/**
	 * 写代码时
	 * @param context
	 */
	public SizeDemo(Context context) {
		super(context);
		
	}

}
