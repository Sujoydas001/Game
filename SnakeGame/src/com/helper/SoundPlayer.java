package com.helper;


import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundPlayer {
	private String path ; 
	public SoundPlayer(String path) {
		this.path = path ; 
	}
	public Clip setClip() {
		File audioFile = new File(this.path); 
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	//	 	audioStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource("res/bg.wav" )); 
	        AudioFormat format = audioStream.getFormat();
	        Info info = new DataLine.Info(Clip.class, format);
	        Clip audioClip = (Clip) AudioSystem.getLine(info);  
			audioClip.open(audioStream);
			return audioClip ; 
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
		return null;
        
	}
	public void playClip(Clip clip) {
		clip.start(); 
		try {
			Thread.sleep(clip.getMicrosecondLength() / 1000);
			clip.setFramePosition(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
	}

}
