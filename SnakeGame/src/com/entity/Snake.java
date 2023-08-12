package com.entity;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.utils.Direction;
import com.utils.Utility;


public class Snake {
	private  int [][]position = new int[Utility.maxSnakeLength][2] ; 
	private  int [][]cmofSnake = new int[Utility.maxSnakeLength][2] ; 
	private boolean automove = false, movement = false, moveUp = false , moveDown = false, moveLeft = false, moveRight = false , alive = false; 
	private Direction lastMove = Direction.EAST; 
	private int score = 0 ;
	private int headidx = 0 , tailidx = 0 , itridx = 0 , size = 10  , positionx = 0 , positiony = 0,xdelta = 1, ydelta = 1 ; 
	
	public Snake() {
		loadInitSnake();
	}
	
	
	
	
	private void loadInitSnake() {
		positionx = Utility.screenWidth / 2 ; 
		positiony = Utility.screenHeight / 2 ; 
		
		this.tailidx = 0 ; 
		this.headidx = this.tailidx + this.size - 1  ; 
		for ( int i = 0 ; i < this.size ; i++ ) {
			this.position[i][0] = positionx ; 
			this.position[i][1] = positiony ;
			this.cmofSnake[i][0] = positionx + 5 ; 
			this.cmofSnake[i][1] = positiony + 5 ;
			/**/
			positionx++ ; 
		}	
		this.itridx = this.size - 1 ; 
	}

	public void refresh(Graphics g) {
		/*body*/
		g.setColor(Color.CYAN);
 		for ( int i = this.tailidx ;  i < this.size ; i++ ) {
			g.fillOval(position[i][0] , position[i][1] ,10,10);
		}
 		/*backbone*/
 		g.setColor(Color.BLACK);
		for ( int i = this.tailidx ;  i < this.size ; i++ ) {
			g.fillOval(cmofSnake[i][0] , cmofSnake[i][1] ,2,2);
		}
		/*face*/
		g.setColor(Color.YELLOW);
		g.fillOval(position[headidx][0] , position[headidx][1] ,10,10);
		
		
		/**/
		
	}
	public void update() {
		
		if ( movement ) {
			if ( this.moveUp ) { positiony-= ydelta ;  };
			if ( this.moveDown ) { positiony+= ydelta  ; };
			if ( this.moveLeft ) { positionx-= xdelta ; };
			if ( this.moveRight ) { positionx+= xdelta ;  };
			
			
		}else if ( automove ) {
			
			switch (this.lastMove){
				case EAST : {
					positionx+= xdelta ;
					break ; 
				}
				case WEST : {
					positionx-= xdelta ; 
					break ; 
				}
				case NORTH : {
					positiony-= ydelta ; 
					break ; 
				}
				case SOUTH : {
					positiony+= ydelta  ; 
					break ; 
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + this.lastMove);
				}
		}else {
			return ; 
		}
		position[itridx][0] = positionx ; 
		position[itridx][1] = positiony ; 
		/**/
		cmofSnake[itridx][0] = positionx + 5  ; 
		cmofSnake[itridx][1] = positiony + 5  ; 
		
		this.headidx  = itridx ; 
		itridx = ( itridx+ 1 ) % this.size ; 
		
	}
	public void increaseSize() {
		this.size+=10 ;		
	}
	
	public void setLastMoveDirection(Direction direction ) {
		this.lastMove = direction ;
	}
	public Direction getLastMoveDirection() {
		return  this.lastMove ;
	}

	public int[][] getPosition() {
		return position;
	}
	public boolean isAutomove() {
		return automove;
	}
	public void setAutomove(boolean automove) {
		this.automove = automove;
	}
	public boolean isMovement() {
		return movement;
	}
	public void setMovement(boolean movement) {
		this.movement = movement;
	}


	public boolean isMoveUp() {
		return moveUp;
	}




	public void setMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}




	public int[][] getCmofSnake() {
		return cmofSnake;
	}




	public void setCmofSnake(int[][] cmofSnake) {
		this.cmofSnake = cmofSnake;
	}




	public boolean isMoveDown() {
		return moveDown;
	}




	public void setMoveDown(boolean moveDown) {
		this.moveDown = moveDown;
	}




	public boolean isMoveLeft() {
		return moveLeft;
	}




	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}




	public boolean isMoveRight() {
		return moveRight;
	}




	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}




	public boolean isAlive() {
		return alive;
	}




	public void setAlive(boolean alive) {
		this.alive = alive;
	}




	public int getScore() {
		return score;
	}




	public void setScore(int score) {
		this.score = score;
	}




	public int getHeadidx() {
		return headidx;
	}




	public void setHeadidx(int headidx) {
		this.headidx = headidx;
	}




	public int getTailidx() {
		return tailidx;
	}




	public void setTailidx(int tailidx) {
		this.tailidx = tailidx;
	}


	public int getSize() {
		return size;
	}




	public void setSize(int size) {
		this.size = size;
	}




	



	


}
