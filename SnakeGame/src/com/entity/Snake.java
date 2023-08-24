package com.entity;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.util.ArrayList;

import com.utils.Direction;
import com.utils.SnakeType;
import com.utils.Utility;


public class Snake {
	private  ArrayList<Position> position; 
	private  ArrayList<Position> cmofSnake ; 
	private boolean automove = false, movement = false, moveUp = false ,
			moveDown = false, moveLeft = false, moveRight = false , alive = false,
			onErossion = false , onDecreament = false  ; 
	private Direction lastMove = Direction.EAST; 
	private int score = 0  , tick = 0 ;
	private SnakeType snakeType ; 
	private int headidx = 0  , tailidx = 0 , size = 250  , positionx = 0 , positiony = 0,xdelta = 1, ydelta = 1 ; 
	
	public Snake( SnakeType snakeType) {
		this.snakeType = snakeType ; 
		loadInitSnake();
	}
	
	
	
	
	private void loadInitSnake() {
		positionx = Utility.screenWidth / 2 ; 
		positiony = Utility.screenHeight / 2 ; 
		this.position = new ArrayList<>() ; 
		this.cmofSnake = new ArrayList<>() ; 
		this.tailidx = 0 ; 
		this.headidx = this.tailidx + this.size - 1  ; 
		for ( int i = tailidx ; i <= headidx ; i++ ) {
			position.add(i,new Position( positionx , positiony ) );
			cmofSnake.add(i , new Position( positionx + 5 , positiony + 5 ));
			/**/
			positionx++ ; 
		}	
	}

	public void refresh(Graphics g) {
		/*body*/
		g.setColor(Color.CYAN);
 		for ( int i = this.tailidx  ;  i <= this.headidx ;i++ ) {
			g.fillOval(position.get(i).x ,position.get(i).y ,10,10);
			
		}
 		/*backbone*/
 		g.setColor(Color.BLACK);
		for ( int i = tailidx ;  i <= this.headidx ; i++ ) {
			g.fillOval(cmofSnake.get(i).x  , cmofSnake.get(i).y ,2,2);
		}
		/*face*/
		g.setColor(Color.YELLOW);
		g.fillOval(position.get(headidx).x , position.get(headidx).y ,10,10);
		
		/*back*/
		g.setColor(Color.RED);
		g.fillOval(position.get(tailidx).x , position.get(tailidx).y ,10,10);
		
		
		/**/
		
	}
	public void update() {
		switch( this.snakeType ) {
		case PLAYER : 
			updatePlayer();
			break ; 
		case BOT : 
			updateBot();
			break ; 
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.snakeType );
		
			
		}
	}
	public void updateBot() {
		
	}
	public synchronized void updatePlayer() {	
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
		position.remove(tailidx); 
		position.add(headidx ,new Position(positionx,positiony ) ); 
		/**/
		cmofSnake.remove(tailidx); 
		cmofSnake.add(headidx ,new Position(positionx+5,positiony+5 ) ); 
		
		
		if ( onDecreament && this.size > 15 ) {
				Utility.UPS = 400 ; 
				tick++ ; 
				position.remove(tailidx);
				cmofSnake.remove(tailidx);
				headidx--;
				this.size-- ;
				if (  tick > 10 ) {
					tick = 0 ; 
					onErossion = true ; 
				}else {
					onErossion = false ; 
				}
				 					
		}else {
			Utility.UPS = 200 ; 
		}
		
		
		
	}
	
	
	
	public void increaseSize() {
		for ( int i = this.size ; i < this.size + 10 ; i++ ) {
			position.add(0,new Position(-100,-100 ) );
			cmofSnake.add(0 , new Position(-100,-100));
			headidx++ ; 
			
		}
		this.size+=10 ;	
		
	}
	
	
	public boolean isOnDecreament() {
		return onDecreament;
	}




	public void setOnDecreament(boolean onDecreament) {
		this.onDecreament = onDecreament;
	}




//	public int getXdelta() {
//		return xdelta;
//	}
//  public void setXdelta(int xdelta) {
//		this.xdelta = xdelta;
//	}
//  public int getYdelta() {
//		return ydelta;
//	}
//	public void setYdelta(int ydelta) {
//		this.ydelta = ydelta;
//	}




	public void setLastMoveDirection(Direction direction ) {
		this.lastMove = direction ;
	}
	public Direction getLastMoveDirection() {
		return  this.lastMove ;
	}
	public ArrayList<Position> getPosition() {
		return position;
	}
	public ArrayList<Position> getCmofSnake() {
		return cmofSnake;
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
	public boolean isOnErossion() {
		return onErossion;
	}
	public void setOnErossion(boolean onErossion) {
		this.onErossion = onErossion;
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
