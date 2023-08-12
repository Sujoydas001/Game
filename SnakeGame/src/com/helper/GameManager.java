package com.helper;
import com.components.Game;
import com.components.MenuScreen;
import com.entity.ScoreCard;
import com.entity.ScoreCardDB;
import com.threads.SoundPlayerThread;
import com.utils.Utility;

public class GameManager {
	private MenuScreen menu ; 
	public Game game ; 
	public Thread gameThread ; 
	public ScoreCardDB scorebase ; 
	public ScoreCardManager scoreCardManager; 
	public GameManager() {
		Utility.gameManager = this ; 
		scorebase = new ScoreCardDB() ; 
		scoreCardManager = new ScoreCardManager(scorebase) ; 
		scoreCardManager.getScoreCards();
		
 		this.menu = new MenuScreen() ; 
 		setBackgroundSound(); 
 		updateRecords();
 		
	}
	private void setBackgroundSound() {
		Thread run = new Thread(new SoundPlayerThread("res/bg.wav",true)) ; 
		run.start(); 
		
	}
	private void updateRecords() {
		
		if ( scorebase.scoreCards.size() == 0 ) {
			this.menu.scoreL.setText("HIGH SCORE: "+scorebase.highscoreCard.score ); 
		}else {
			this.menu.scoreL.setText("HIGH SCORE: "+scorebase.highscoreCard.score 
					+ " LAST SCORE:" + scorebase.scoreCards.get(0).score);	
		}
		
		this.menu.showRecordL.setText("");		
 		String records = "" ;
 		for ( ScoreCard each: scorebase.scoreCards ) {
 			records += each.toString(); 
 			Utility.log.d(each.toString());
 		}
		this.menu.showRecordL.setText(records);
		

	}
	public void generateNewGame(){
		Utility.gameOver = false ;
		Utility.log.d("generating new game" );
		onResume();
		this.game = new Game();
		
	}
	public void onPause() {
		Utility.paused = true ; 
		Utility.log.d("game paused" );
		this.menu.setVisible(true);
	}
	public void onResume() {
		this.menu.setVisible(false);
		Utility.log.d("game resumed" );
		Utility.paused= false ; 
	}
	public void onGameOver() {
		if ( Utility.gameOver ) {
			Utility.log.d("game over" );
			updateRecords();
			this.menu.setVisible(true);
			this.game.gameWindow.frame.dispose() ; 
			this.game = null ; 
			Utility.paused = true  ; 
		}
	}
	public void onExit() {
		Utility.log.d("game exit" );
		Utility.gameOver = true ; 
		System.exit(0);
	}
	public void lapseExistingGame() {
		if ( !Utility.gameOver ) {
			Utility.log.d(" existing game exit" );
			this.game.gameWindow.frame.dispose(); 
		}
		Utility.gameOver = true ; 
		
	}; 


}
