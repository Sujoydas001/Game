package com.helper;



import java.awt.Graphics;

import com.entity.Gems;
import com.utils.Utility;


public class GemsManager implements Runnable{
	private Gems[] position = new Gems[Utility.maxGemsCount] ; 
	private boolean visible[] = new boolean[Utility.maxGemsCount] ; 
	private int gemsCount = 0 ; 
	
	public GemsManager() {}
	public void addGemstoScreen() {
		Gems gem = new Gems(); 
		int size = gemsCount ; 
		position[size] = gem ; 
		visible[size++] = true ;  
		gemsCount = size ; 
		
	}
	public void removeGemsfromScreen(int idx) {
		visible[idx] = false ;  
	}
	
	public void refresh(Graphics g) {
		for (  int i = 0 ; i < gemsCount ; i++  ) {
			if ( visible[i] ) {
				position[i].refresh(g);
			}
		}
	}
	@Override
	public void run() {
		Utility.log.d("gems manager starts adding gems....");
		while( !Utility.gameOver ) {
			if ( !Utility.paused ) {
				addGemstoScreen();
			}
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Gems[] getPosition() {
		return position;
	}
	public boolean[] getVisible() {
		return visible;
	}
	public void setVisible(boolean[] visible) {
		this.visible = visible;
	}
	public int getGemsCount() {
		return gemsCount;
	}

	
	

	
	

}
