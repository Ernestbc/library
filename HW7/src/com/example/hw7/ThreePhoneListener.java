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
	 * ͨ��ʱ�Ĵ���
	 */
	private void method(){
		try {
			mediaRecorder=new MediaRecorder();
			mediaRecorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);//��Ƶ�ɼ�Դ
			mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);//���������ʽ
			mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);//�����ʽ����3�֣�ѡ��һ
			
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
	 * ����״̬
	 */
	@Override
	public void onCallStateChanged(int state, String incomingNumber) {
		// TODO Auto-generated method stub
		super.onCallStateChanged(state, incomingNumber);

		switch (state) {
		case TelephonyManager.CALL_STATE_IDLE://��״̬ʱ
			if(mediaRecorder!=null){
				mediaRecorder.stop();//ֹͣ��¼
				mediaRecorder.reset();//����
				mediaRecorder.release();//�����ͷ���Դ
				mediaRecorder = null;
			}
			break;
		case TelephonyManager.CALL_STATE_RINGING://����ʱ
			phoneNum=incomingNumber;
			break;
		case TelephonyManager.CALL_STATE_OFFHOOK://ͨ��ʱ
			method();
			break;

		default:
			break;
		}
	}

}
