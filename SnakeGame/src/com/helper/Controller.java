package com.helper;

import java.util.ArrayList;
import java.util.Date;

import com.components.ScorePanel;
import com.entity.Gems;
import com.entity.Position;
import com.entity.ScoreCard;
import com.entity.Snake;
import com.threads.SoundPlayerThread;
import com.utils.Utility;

public class Controller {
	private GemsManager gemsManager ; 
	private Snake snake ; 
	private ScorePanel scorePanel ; 
	public Controller( ScorePanel scorePanel, GemsManager gemsManager, Snake snake ) {
		this.gemsManager = gemsManager ; 
		this.snake = snake  ; 
		this.scorePanel = scorePanel ; 
	}
	public void checkGemsHit() {
		for ( int i =  0 ; i < gemsManager.getGemsCount(); i++  ) {
			if ( ( checkHit(gemsManager.getPosition().get(i))) ) {
				
				this.snake.setScore(this.snake.getScore()+1);
				/**/
				this.scorePanel.setScoreBoard(this.snake.getScore());
				/**/
				
				
				this.snake.increaseSize() ; 
				this.gemsManager.removeGemsfromScreen(i);
			}
		}
	}
	public void checkGameLogic() {
		checkGemsHit();
		checkBoundaryHit();
		checkSelfBite() ; 
		addGemsonErossion();
		
	}
	
	private void addGemsonErossion() {
		if ( this.snake.isOnErossion() ) {
			this.gemsManager.addGemstoScreen(
					new Gems(this.snake.getPosition().get(this.snake.getTailidx()).x,
							this.snake.getPosition().get(this.snake.getTailidx()).y
							));
		}
		
	}
	private void checkSelfBite() {
		int snakeheadx = this.snake.getCmofSnake().get(this.snake.getHeadidx()).x; 
		int snakeheady = this.snake.getCmofSnake().get(this.snake.getHeadidx()).y;
		ArrayList<Position> cmofSnake  = this.snake.getCmofSnake() ; 
		for ( int i = 0 ; i < this.snake.getSize() ; i++ ) {
			if ( i != this.snake.getHeadidx() ) {
				
				if( snakeheadx == cmofSnake.get(i).x && 
						snakeheady == cmofSnake.get(i).y ) {
					Utility.log.d("self bite");
					onCrash();
					return ; 
					
				}
			}
		}
		
	}
	

	private boolean checkHit(Gems each ) {
		int snakeheadx = this.snake.getPosition().get(this.snake.getHeadidx()).x; 
		int snakeheady = this.snake.getPosition().get(this.snake.getHeadidx()).y;
		if (  ( (each.getYpos() + each.getHeight()) > (snakeheady )
				&& 
				( (each.getYpos()) < ( (snakeheady + 10 )  ))
				&&
				(  (each.getXpos() + each.getWidth()) > ( (snakeheadx)  )) 
				&&
				(  (each.getXpos()) < ((snakeheadx)+ 10 )  )))
				{
				setHitSound() ; 
				return true ; 
					
				}
				return false;
	}
	private void setHitSound() {
			Thread run = new Thread(new SoundPlayerThread("res/incr.wav",false)) ; 
			run.start(); 
	}
	private void checkBoundaryHit() {
		int xpos = this.snake.getCmofSnake().get(this.snake.getHeadidx()).x; 
		int ypos = this.snake.getCmofSnake().get(this.snake.getHeadidx()).y;
		
		if ( ( xpos <= 0 || xpos >= Utility.panelWidth )
			||
			(ypos <= 0 || ypos >= Utility.panelHeight ) )
			{
				onCrash();
			}
		return ; 
	}
	private void setOnCrashSound() {
		Thread run = new Thread(new SoundPlayerThread("res/fail.wav",false)) ; 
		run.start(); 
		
	}
	private void onCrash() {
		Utility.gameOver = true ;
		
		setOnCrashSound(); 
		ScoreCard newScoreCard =  new ScoreCard(new Date(), this.snake.getScore());
		Utility.gameManager.scorebase.scoreCards.add(0,newScoreCard); 
		if (newScoreCard.score > Utility.gameManager.scorebase.highscoreCard.score) {
			Utility.log.d("high score changed ");
			Utility.gameManager.scorebase.highscoreCard = newScoreCard ;
		}
		Utility.gameManager.scoreCardManager.setScoreCards();
		Utility.gameManager.onGameOver();
	}
	
}
