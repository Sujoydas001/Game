package com.io;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;


import javax.swing.event.MouseInputListener;

import com.components.GamePanel;
import com.components.ScorePanel;
import com.components.ScreenComponents;
import com.entity.Snake;
import com.utils.Direction;
import com.utils.Utility;


public class InputListener  implements KeyListener , MouseInputListener{
	private ScreenComponents obj ; 
	private Snake snake = null ; 
	public InputListener( ScreenComponents objT ) {
		this.obj = objT ; 
		
		if ( objT.getClass().getName().equals("com.components.GamePanel")) {
			this.snake = ((GamePanel)this.obj).snake ; 
		}
		
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		if ( e.getKeyCode() == KeyEvent.VK_LEFT ){
			if ( this.snake.getLastMoveDirection() != Direction.EAST ) {
				this.snake.setLastMoveDirection(Direction.WEST);
				this.snake.setMovement(true);
				this.snake.setMoveLeft(true);
				this.snake.setMoveRight(false);
				
			}
			
		};
		if ( e.getKeyCode() == KeyEvent.VK_RIGHT ){
			if ( this.snake.getLastMoveDirection() != Direction.WEST) {
				this.snake.setLastMoveDirection(Direction.EAST);
				this.snake.setMovement(true);
				this.snake.setMoveRight(true);
				this.snake.setMoveLeft(false);
			}
		};
		if ( e.getKeyCode() == KeyEvent.VK_UP ){
			if ( this.snake.getLastMoveDirection() != Direction.SOUTH) {
				this.snake.setLastMoveDirection(Direction.NORTH);
				this.snake.setMovement(true);
				this.snake.setMoveUp(true);
				this.snake.setMoveDown(false);
			}
		};
		if ( e.getKeyCode() == KeyEvent.VK_DOWN ){ 
			if ( this.snake.getLastMoveDirection() != Direction.NORTH) {
				this.snake.setLastMoveDirection(Direction.SOUTH);
				this.snake.setMovement(true);
				this.snake.setMoveDown(true);
				this.snake.setMoveUp(false);
			}
		};
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if ( e.getKeyCode() == KeyEvent.VK_LEFT ){
			this.snake.setMovement(false);
			this.snake.setMoveLeft(false);
		};
		if ( e.getKeyCode() == KeyEvent.VK_RIGHT ){
			this.snake.setMovement(false);
			this.snake.setMoveRight(false);
		};
		if ( e.getKeyCode() == KeyEvent.VK_UP ){
			this.snake.setMovement(false);
			this.snake.setMoveUp(false);
		};
		if ( e.getKeyCode() == KeyEvent.VK_DOWN ){ 
			this.snake.setMovement(false);
			this.snake.setMoveDown(false);
		};
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if ( e.getSource().equals(((ScorePanel)obj).pauseBtn)) {
			if ( !Utility.paused ){
				
				/**/
				/**
				 * open pause menu*/
				Utility.gameManager.onPause();
				/**/
			}
			else {
				/*close pause open game*/
				Utility.gameManager.onResume();
			}
			
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
