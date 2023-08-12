package com.threads;


import javax.sound.sampled.Clip;

import com.helper.SoundPlayer;

public class SoundPlayerThread implements Runnable{
	private boolean looping  ;
	private  String path ; 
	private SoundPlayer player ; 
	private Clip clip ; 
	private boolean on = true ; 
	private SoundSetterThread soundSetter ; 
 	public SoundPlayerThread(String songPath,boolean looping ) {
 		this.looping = looping ;
 		this.path = songPath ; 
 		player = new SoundPlayer(this.path);
 		this.soundSetter = new SoundSetterThread(); 
	}
	@Override
	public void run() {
		clip =  player.setClip() ; 
		
		while( on ) {
			SoundSetterThread sst = new SoundSetterThread(); 
			sst.getControlOnClip(clip); 
			
			new Thread(sst).start() ;
			
			
			player.playClip(clip) ; 
			
			
			
			if ( !looping ) {
				on = false ; 
			}
		}
		
	}
 	

}
