package com.components;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow {
	
	public JFrame frame ; 

	
	public GameWindow( WindowPanel windowPanel ) {
		frame  = new JFrame(); 
		frame.setResizable(false);
		
		frame.add(windowPanel); 
		frame.pack(); 
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		frame.setVisible(true) ; 
	}
 

}
