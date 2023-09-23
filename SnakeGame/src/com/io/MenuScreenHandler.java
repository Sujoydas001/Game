package com.io;
import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import com.components.MenuScreen;
import com.utils.Utility;


public class MenuScreenHandler implements MouseInputListener {
	private MenuScreen menuScreen ; 
	public MenuScreenHandler( MenuScreen menu) {
		this.menuScreen = menu ; 
	}
	@Override
	public void mouseClicked(MouseEvent e) {
//		if ( e.getSource().equals( menuScreen.rbeasy ) && 
//				menuScreen.rbeasy.isEnabled()){
//			menuScreen.rbmedium.setSelected(false); 
//			menuScreen.rbhard.setSelected(false); 
////			Utility.mode = MODES.EASY ; 
//		}
//		if ( e.getSource().equals(menuScreen.rbmedium ) &&
//				menuScreen.rbmedium.isEnabled()) { 
//			menuScreen.rbeasy.setSelected(false); 
//			menuScreen.rbhard.setSelected(false); 
////			Utility.mode = MODES.MEDIUM ; 
//		}
//		if ( e.getSource().equals(menuScreen.rbhard ) && 
//				menuScreen.rbhard.isEnabled()) {
//			menuScreen.rbmedium.setSelected(false); 
//			menuScreen.rbeasy.setSelected(false); 
////			Utility.mode = MODES.HARD ; 
//		}
//		if ( e.getSource().equals( menuScreen.rbeasy ) || 
//				e.getSource().equals( menuScreen.rbmedium ) ||
//				e.getSource().equals( menuScreen.rbhard ) ) {
//			menuScreen.rbeasy.setForeground(Color.BLACK);
//			menuScreen.rbmedium.setForeground(Color.BLACK);
//			menuScreen.rbhard.setForeground(Color.BLACK);
//		}

		
//		if ( e.getSource().equals(this.menuScreen.newP)) {
//			System.out.println("enter ");
//			this.menuScreen.newP.setBackground(Color.BLACK);
//		}
		if ( e.getSource().equals( menuScreen.newL )) {
//			if ( !( menuScreen.rbeasy.isEnabled() &&
//					menuScreen.rbmedium.isEnabled() &&
//					menuScreen.rbhard.isEnabled() )||
//					!( menuScreen.rbeasy.isSelected() ||
//							menuScreen.rbmedium.isSelected() ||
//							menuScreen.rbhard.isSelected()
//							) )
//			{
//				
//				menuScreen.rbeasy.setEnabled(true) ;  
//				menuScreen.rbmedium.setEnabled(true) ;  
//				menuScreen.rbhard.setEnabled(true) ;  
//				menuScreen.rbeasy.setForeground(Color.RED);
//				menuScreen.rbmedium.setForeground(Color.RED);
//				menuScreen.rbhard.setForeground(Color.RED);
//			}else{
//				
					Utility.gameManager.lapseExistingGame(); 
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					Utility.gameOver  = false ; 
				
				
				Utility.gameManager.generateNewGame();
				Utility.log.d("next calling generate new game ");
			}; 
//		}
		if ( e.getSource().equals(menuScreen.helpL)) {
//			if ( menuScreen.showHelpP.isVisible() ) {
////				menuScreen.showHelpP.setVisible(false);
//			}else {
////				menuScreen.showHelpP.setVisible(true);
//			}
		}
		if ( e.getSource().equals(menuScreen.recordL)) {
			if ( menuScreen.jScrollPane.isVisible() ) {
				menuScreen.jScrollPane.setVisible(false);
			}else {
				menuScreen.jScrollPane.setVisible(true);
				menuScreen.showRecordL.setVisible(true);
				
			}
		}
		if ( e.getSource().equals(menuScreen.exitP)) {
			Utility.gameManager.onExit();
			
			
		}
		
	}

		
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if ( e.getSource().equals(this.menuScreen.newL)) {
			this.menuScreen.newP.setBackground(Color.LIGHT_GRAY);
			this.menuScreen.newL.setForeground(Color.BLACK);
		}
//		if ( e.getSource().equals(this.menuScreen.modeL)) {
//			this.menuScreen.modeP.setBackground(Color.LIGHT_GRAY);
//			this.menuScreen.modeL.setForeground(Color.BLACK);
//		}
		if ( e.getSource().equals(this.menuScreen.scoreL)) {
			this.menuScreen.scorecardP.setBackground(Color.LIGHT_GRAY);
			this.menuScreen.scoreL.setForeground(Color.BLACK);
		}
		if ( e.getSource().equals(this.menuScreen.soundL)) {
			this.menuScreen.soundP.setBackground(Color.LIGHT_GRAY);
			this.menuScreen.soundL.setForeground(Color.BLACK);
		}
		if ( e.getSource().equals(this.menuScreen.helpL)) {
			this.menuScreen.helpP.setBackground(Color.LIGHT_GRAY);
			this.menuScreen.helpL.setForeground(Color.BLACK);
		}
		if ( e.getSource().equals(this.menuScreen.recordL)) {
			this.menuScreen.recordP.setBackground(Color.LIGHT_GRAY);
			this.menuScreen.recordL.setForeground(Color.BLACK);
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if ( e.getSource().equals(this.menuScreen.newL)) {
			this.menuScreen.newP.setBackground(null);
			this.menuScreen.newL.setForeground(Color.WHITE);
			
		}
//		if ( e.getSource().equals(this.menuScreen.modeL)) {
//			this.menuScreen.modeP.setBackground(null);
//			this.menuScreen.modeL.setForeground(Color.WHITE);
//			
//		}
		if ( e.getSource().equals(this.menuScreen.scoreL)) {
			this.menuScreen.scorecardP.setBackground(null);
			this.menuScreen.scoreL.setForeground(Color.WHITE);
			
		}
		if ( e.getSource().equals(this.menuScreen.soundL)) {
			this.menuScreen.soundP.setBackground(null);
			this.menuScreen.soundL.setForeground(Color.WHITE);
			
		}
		if ( e.getSource().equals(this.menuScreen.helpL)) {
			this.menuScreen.helpP.setBackground(null);
			this.menuScreen.helpL.setForeground(Color.WHITE);

		}
		if ( e.getSource().equals(this.menuScreen.recordL)) {
			this.menuScreen.recordP.setBackground(null);
			this.menuScreen.recordL.setForeground(Color.WHITE);
		}
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		if ( e.getSource().equals(this.menuScreen.newP)) {
			System.out.println("enter ");
			this.menuScreen.newP.setBackground(Color.BLACK);
		}
		
	}
	

}
