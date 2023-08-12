package com.threads;


import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import com.test.TestUtility;
import com.utils.Utility;


public class SoundSetterThread implements Runnable{
	private FloatControl gainControl ;
	private Clip clip ;
	public void getControlOnClip(Clip clip) {
		this.clip = clip  ;
		gainControl =  (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN); 
	}
	private void setVolume(float value) {
		gainControl.setValue(value);
	}
	@Override
	public void run() {
		while(clip.isOpen()) {
			this.setVolume(Utility.currVol/10-5.0f);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
