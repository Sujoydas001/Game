package com.threads;
import com.entity.Snake;
import com.utils.Utility;

public class AutoUpdateThread implements Runnable{
	private Snake snake = null;
	public AutoUpdateThread(Snake snake ) {
		this.snake = snake ; 
	}
	@Override
	public void run() {
		Utility.log.d("snake position auto update while not moving ....");
		Utility.log.d("current game over status : " + Utility.gameOver);
		while(!Utility.gameOver ) {
			if (  !Utility.paused ) {
				try {	
					this.snake.setAutomove(true) ; 
					Thread.sleep(10) ; 
					this.snake.setAutomove(false) ;
					Thread.sleep(1000) ; 
				}catch (InterruptedException e) {
					
				}
			}else {
				try {
					Thread.sleep(400) ; 
				}catch (InterruptedException e) {
					
				}
			}
			
		}
	}
}