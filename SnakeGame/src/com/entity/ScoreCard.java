package com.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScoreCard  implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Date datetime ; 
	public int score ;
	SimpleDateFormat formatter ; 
	
	public ScoreCard(Date datetime, int score) {
		this.datetime = datetime;
		this.score = score;
		formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss") ; 
	} 
	@Override
	public String toString() {
		return " " + this.formatter.format(this.datetime) + " : " + this.score + " \n"; 
	}
}