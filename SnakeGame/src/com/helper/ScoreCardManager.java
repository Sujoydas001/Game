package com.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


import com.entity.ScoreCard;
import com.entity.ScoreCardDB;
import com.utils.Utility;



public class ScoreCardManager {
	private ScoreCardDB scoreCardDB ; 
	public ScoreCardManager(ScoreCardDB scoreCardDB) {
		this.scoreCardDB = scoreCardDB ; 
	}
	
	
	private void setHighScore() {
		Utility.log.d(" set high score ");
		File file = new File("score.txt"); 
		if ( !file.exists()) {
			try {
				Utility.log.d(" score file not found creating new file");
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			Utility.log.d(" score file found");
		}
		try {
			FileOutputStream foStream = new FileOutputStream(file);
			ObjectOutputStream obj   = new ObjectOutputStream(foStream);
			obj.writeObject(this.scoreCardDB.highscoreCard) ; 
	        obj.close();
	        foStream.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void setScoreRecords() {
		Utility.log.d("setting records ");
		File file = new File("records.txt"); 
		if ( !file.exists()) {
			try {
				Utility.log.d(" records file not found creating new file");
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			Utility.log.d(" records file found");
		}
		try {
			FileOutputStream foStream = new FileOutputStream(file);
			ObjectOutputStream obj   = new ObjectOutputStream(foStream);
			obj.writeObject(this.scoreCardDB.scoreCards) ; 
	        obj.close();
	        foStream.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void setScoreCards() {
		setHighScore();
		setScoreRecords(); 
	}
	public void getScoreCards() {
		getHighScore();
		getScoreRecords(); 
	}
	private void getScoreRecords() {
		File file = new File("records.txt"); 
		if ( !file.exists()) {
			Utility.log.d("no records exists ");
			setScoreCards();
			return ; 
		}else {
			Utility.log.d(" records found");
		}
		try {
			FileInputStream fiStream = new FileInputStream(file);
			ObjectInputStream obj   = new ObjectInputStream(fiStream);
	        while( fiStream.available() > 0  ){
	        	this.scoreCardDB.scoreCards =(ArrayList<ScoreCard>)( obj.readObject()) ; 
	        	Utility.log.d("file iteration time");
	        }
	        obj.close();
	        fiStream.close(); 
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	private void getHighScore() {
		File file = new File("score.txt"); 
		if ( !file.exists()) {
			Utility.log.d("no file exists ");
			return ; 
		}else {
			Utility.log.d(" score file found");
		}
		try {
			FileInputStream fiStream = new FileInputStream(file);
			ObjectInputStream obj   = new ObjectInputStream(fiStream);
	        while( fiStream.available() > 0  ){
	        	this.scoreCardDB.highscoreCard =(ScoreCard)(obj.readObject()) ; 
	        	Utility.log.d("file iteration time");
	        }
	        Utility.log.d("getting high score :" + Utility.gameManager.scorebase.highscoreCard.score);
	        obj.close();
	        fiStream.close(); 
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}        
	}
}