package com.threads;
import com.utils.Utility;

public class MainThread implements Runnable{
//	private GamePanel gamePanel ; 
	
	public MainThread( ) {
//		this.gamePanel = gamePanel ; 
	}
	@Override
	public void run() {
		
		long timeperFrame = 1000000000 / Utility.FPS ; 
		
		double deltaF = 0 , deltaU = 0 ;  
		long framecount = 0 , updatecount = 0 , prevtimeforframe = System.nanoTime() , prevtimeforupdate = System.nanoTime() ;
		long checktimeforprint = System.currentTimeMillis(),resetFrameCountAndUpdateCount = System.currentTimeMillis() ; 
		while( !Utility.gameOver ) {
			
			long now = System.nanoTime() ; 
			long timeperUpdate = 1000000000 / Utility.UPS ; 
			deltaF += ( now - prevtimeforframe )/ timeperFrame  ; 
			deltaU += ( now - prevtimeforupdate )/ timeperUpdate  ; 
			
			if ( deltaF >= 1 ) {
				if ( !Utility.paused ) {
					this.refreshComponents() ; 
				}
					deltaF-- ; 
					framecount++ ;
					prevtimeforframe = now  ;
				
			}
			if ( deltaU >= 1 ) {
				if ( !Utility.paused  ) {
					this.updateComponents() ; 
				}
					deltaU-- ; 
					updatecount++ ;
					prevtimeforupdate =  now  ;
				
			}
			if ( System.currentTimeMillis() - checktimeforprint >= 1000 ) {
				Utility.log.d("frame : " + framecount + " : update : " + updatecount); 
				checktimeforprint = System.currentTimeMillis() ; 
			}
			if ( System.currentTimeMillis() - resetFrameCountAndUpdateCount >= 1000 ) {
				framecount = 0 ; 
				updatecount =  0 ; 
				resetFrameCountAndUpdateCount = System.currentTimeMillis() ; 
			}	
				
			if ( Utility.gameOver ) {
				Utility.log.d("gameOver status to run next iteration : " + Utility.gameOver);
			}
			
		}	
	}
	private void updateComponents() {
		Utility.gameManager.game.gamePanel.update();
		
	}
	private void refreshComponents() {
		Utility.gameManager.game.gamePanel.refresh();
		
	}

}
