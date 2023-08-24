package com.components;
import com.entity.Snake;
import com.helper.Controller;
import com.helper.GemsManager;
import com.threads.AutoUpdateThread;
import com.threads.MainThread;
import com.utils.SnakeType;
import com.utils.Utility;

public class Game{
	public  GamePanel gamePanel ; 
	public GameWindow gameWindow ; 
	public WindowPanel windowPanel ; 
	public ScorePanel scorePanel ; 
	public Thread gameThread ; 
	private Snake playerSnake; 
	private GemsManager gemsManager ; 
	private Controller controller ; 
	
	public Game() {
		
		
		scorePanel = new ScorePanel() ; 
		windowPanel = new WindowPanel(); 
		
		playerSnake = new Snake( SnakeType.PLAYER ); 
		gemsManager = new GemsManager() ; 
		controller = new Controller( scorePanel,gemsManager, playerSnake); 
		gamePanel = new GamePanel(playerSnake,gemsManager,controller); 
		
		windowPanel.add(gamePanel);
		windowPanel.add(scorePanel); 
		
		
		
		
		
		
		gameWindow = new GameWindow(windowPanel) ; 
		gamePanel.requestFocus();
		Thread autoSetPosThread = new Thread(new AutoUpdateThread(this.playerSnake));
		autoSetPosThread.start(); 
		Thread gemsGeneratorThread = new Thread(gemsManager) ; 
		gemsGeneratorThread.start(); 
		Utility.log.d("gameover status : " + Utility.gameOver);
		startGameLoop() ; 
		
		
		
	}
	private void startGameLoop() {
		gameThread = new Thread(new MainThread()); 
		gameThread.start(); 
		Utility.log.d("game loop starts") ; 
	}
	
	
	
	


}
