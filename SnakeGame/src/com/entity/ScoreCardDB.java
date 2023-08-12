package com.entity;
import java.util.ArrayList;

public class ScoreCardDB {

	public ScoreCard highscoreCard ;  
	public ArrayList<ScoreCard> scoreCards ;
	public ScoreCardDB() {
		this.highscoreCard = new ScoreCard(null, 0); 
		this.scoreCards = new ArrayList<>() ;
	}
	

}
