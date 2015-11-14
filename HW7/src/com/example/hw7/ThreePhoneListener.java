package com.example.hw7;

import java.io.File;
import java.io.IOException;

import android.media.MediaRecorder;
import android.os.Environment;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class ThreePhoneListener extends PhoneStateListener {

	MediaRecorder mediaRecorder;
	File file;
	String phoneNum;
	
	/**
	 * 通话时的处理
	 */
	private void method(){
		try {
			mediaRecorder=new MediaRecorder();
			mediaRecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);//音频采集源
			mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);//内容输出格式
			mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);//编码格式，有3种，选其一
			
//		file=new File(Environment.getExternalStorageDirectory(), phoneNum+System.currentTimeMillis()+"3gp");
//		file=new File(Environment.getExternalStorageDirectory(), "XXXX.3gp");
//		mediaRecorder.setOutputFile(file.getAbsolutePath());
			mediaRecorder.setOutputFile("/sdCard/1235.3gp");
			Log.i("test", file.getAbsolutePath());
			
			mediaRecorder.prepare();
			mediaRecorder.start();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 来电状态
	 */
	@Override
	public void onCallStateChanged(int state, String incomingNumber) {
		// TODO Auto-generated method stub
		super.onCallStateChanged(state, incomingNumber);

		switch (state) {
		case TelephonyManager.CALL_STATE_IDLE://无状态时
			if(mediaRecorder!=null){
				mediaRecorder.stop();//停止刻录
				mediaRecorder.reset();//重设
				mediaRecorder.release();//刻完释放资源
				mediaRecorder = null;
			}
			break;
		case TelephonyManager.CALL_STATE_RINGING://来电时
			phoneNum=incomingNumber;
			break;
		case TelephonyManager.CALL_STATE_OFFHOOK://通话时
			method();
			break;

		default:
			break;
		}
	}

}
