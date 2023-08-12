package com.entity;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.utils.Utility;

public class Gems {
	private  int xpos , ypos , width , height ;
	private Random random ; 
	public Gems() {
		random = new Random(); 
		this.xpos = random.nextInt(Utility.panelWidth) ; 
		this.ypos = random.nextInt(Utility.panelHeight) ; 
		this.width = Utility.obstacleWidth ;
		this.height = Utility.obstacleHeight ; 
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void refresh(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(xpos, ypos, width, height);
	}
	public int getXpos() {
		return xpos;
	}
	public int getYpos() {
		return ypos;
	}
	
	

}
