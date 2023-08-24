package com.helper;



import java.awt.Graphics;
import java.util.ArrayList;

import com.entity.Gems;
import com.utils.Utility;


public class GemsManager implements Runnable{
	private ArrayList<Gems> position = new ArrayList<>() ;  
	private int gemsCount = 0 ; 
	
	public GemsManager() {}
	private void addGemstoScreen() {
		Gems gem = new Gems(); 
		int size = gemsCount ; 
		position.add(size, gem )  ; 
		gemsCount = ++size ; 
		
	}
	public void addGemstoScreen(Gems gem) {
		int size = gemsCount ; 
		position.add(size, gem )  ; 
		gemsCount = ++size ; 
		
	}
	public void removeGemsfromScreen(int idx) {
		position.remove(idx);
		this.gemsCount-- ; 
	}
	
	public void refresh(Graphics g) {
		for (  int i = 0 ; i < gemsCount ; i++  ) {
				position.get(i).refresh(g);
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
	public ArrayList<Gems> getPosition() {
		return position;
	}

	public int getGemsCount() {
		return gemsCount;
	}

	
	

	
	

}
