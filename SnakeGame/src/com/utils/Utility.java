package com.utils;
import com.helper.GameManager;
import com.test.Log;

public class Utility {
	public static final int FPS = 120;
	public static int UPS =  200;
	public static final int obstacleWidth = 10;
	public static final int obstacleHeight =10;
	public static final int screenHeight = 600;
	public static final int screenWidth = 600;
	public static final int scoreBoardHeight = 40;
	public static final int scoreBoardWidth = screenWidth;
	public static final int panelHeight = screenHeight-scoreBoardHeight;
	public static final int panelWidth = screenWidth; 
	public static boolean paused = true , gameOver = true ,renderComplete = true ,updateComplete = true  ; 
	public static final Log log = new Log("db/applog.txt") ;
	public static final String scorecardFileString = "db/records.txt";
	public static final String highscoreFileString = "db/score.txt";
	public static GameManager gameManager  ; 
	public static float currVol = 60 ; 
	
}
