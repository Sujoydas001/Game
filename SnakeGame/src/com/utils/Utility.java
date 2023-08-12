package com.utils;
import com.helper.GameManager;
import com.test.Log;

public class Utility {
	public static final int FPS = 120 , UPS =  200 ,obstacleWidth = 10,obstacleHeight =10 ,
			screenHeight = 600 , screenWidth = 600 ,maxSnakeLength = 500, maxGemsCount = 10000,
			scoreBoardHeight = 40 ,scoreBoardWidth = screenWidth,panelHeight = screenHeight-scoreBoardHeight ,
			panelWidth = screenWidth; 
	public static boolean paused = true , gameOver = true ,renderComplete = true ,updateComplete = true  ; 
	public static final Log log = new Log("db/applog.txt") ;
	public static final String scorecardFileString = "db/records.txt";
	public static final String highscoreFileString = "db/score.txt";
	public static GameManager gameManager  ; 
	public static float currVol = 60 ; 
	
}
