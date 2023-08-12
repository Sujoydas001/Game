package com.components;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.io.MenuScreenHandler;
import com.utils.Utility;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuScreen extends JFrame implements ChangeListener , ScreenComponents{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L ;
	public JPanel windowPanel, mainPanel 
	, newP,soundP,helpP ,modeP , scorecardP,recordP,showrecordP ,showHelpP , exitP ; 
	public JLabel newL ,modeL, scoreL , soundL , helpL, recordL ;
	public JTextArea showRecordL  =  new JTextArea() ; 
	public JScrollPane jScrollPane; 

	public JRadioButton rbeasy,rbmedium,rbhard ; 
	public JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);   
	BufferedImage imgBufferedImage = null; 
	public  MenuScreen() { 
		imgBufferedImage  =  loadBG(); 
		MenuScreenHandler menuHandler = new MenuScreenHandler(this); 
		this.addMouseListener(menuHandler);
		
		windowPanel = new JPanel();
		windowPanel.setLayout(null);
		windowPanel.setBounds(0,0,Utility.screenWidth-200,Utility.screenHeight-200);
		windowPanel.setBackground(new Color(0,0,68)) ; 	
		
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(6,1));
		mainPanel.setBackground(new Color(0,0,42)) ; 	
		mainPanel.setBounds((Utility.screenWidth-200)/2-125, (Utility.screenHeight-200)/2-75,250,150);
			scorecardP = new JPanel(); 
			scorecardP.setLayout(new BorderLayout());
			scorecardP.setBackground(null);
//			
			scoreL = new JLabel("HIGH SCORE : "  ); 
			scoreL.setForeground(Color.WHITE);
			scorecardP.add(scoreL, BorderLayout.CENTER) ; 
			
			newP = new JPanel();
			newL = new JLabel(" NEW "); 
			newL.setForeground(Color.WHITE);
			newP.setLayout(new BorderLayout());
			newP.setBackground(null);
			newP.add(newL , BorderLayout.CENTER);  
			
			soundP = new JPanel();
			soundP.setBackground(null);
			soundL = new JLabel("SOUND       "); 
			soundL.setForeground(Color.WHITE);
			slider.setBackground(null); 
			slider.addChangeListener(this);
			soundP.setLayout(new BorderLayout());
			soundP.add(soundL,BorderLayout.WEST) ; 
			soundP.add(slider,BorderLayout.CENTER) ; 
			
			modeP = new JPanel();
			modeP.setLayout(new GridLayout(1,4)); 
			modeP.setBackground(null);
			modeL = new JLabel("MODE ") ; 
			modeL.setForeground(Color.WHITE);
				rbeasy =new JRadioButton("easy");  
				rbmedium=new JRadioButton("medium");    
				rbhard =new JRadioButton("hard");
				rbeasy.setForeground(Color.WHITE);rbmedium.setBackground(Color.WHITE);rbhard.setBackground(Color.WHITE);
				rbeasy.setBackground(null);rbmedium.setBackground(null);rbhard.setBackground(null);
				rbeasy.addMouseListener(menuHandler);rbmedium.addMouseListener(menuHandler);rbhard.addMouseListener(menuHandler);
			modeP.add(modeL) ; modeP.add(rbeasy) ;modeP.add(rbmedium); modeP.add(rbhard) ;
		
			helpP = new JPanel();
			helpP.setBackground(null);
			helpL = new JLabel("HELP ") ;
			helpL.setForeground(Color.WHITE);
			helpP.setLayout(new BorderLayout());
			helpP.add(helpL,BorderLayout.CENTER ) ; 
			helpL.addMouseListener(menuHandler);
	
			recordP = new JPanel(); 
			recordP.setBackground(null);
			recordL = new JLabel("RECORDS ");
			recordL.setForeground(Color.WHITE);
			recordP.setLayout(new BorderLayout());
			recordP.add(recordL, BorderLayout.CENTER) ; 
			recordL.addMouseListener(menuHandler);
			
			
			
		mainPanel.add(scorecardP);  mainPanel.add(newP); mainPanel.add(modeP); mainPanel.add(soundP); mainPanel.add(helpP);mainPanel.add(recordP);  
//		showHelpP = new JPanel() ; 
//		showHelpP.setLayout(new FlowLayout());
//		showHelpP.setBounds((Utility.screenWidth-200)/2+130, (
//				Utility.screenHeight-200)/2-75,200,190); 
//		showHelpP.setBackground(Color.lightGray);
//		showHelpP.setVisible(false);
		showrecordP = new JPanel(); 
		showrecordP.setLayout(new BorderLayout());
		jScrollPane = new JScrollPane(showrecordP) ; 
		jScrollPane.setBounds((Utility.screenWidth-200)/2-125, (Utility.screenHeight-200)/2+85,250,100);
		showrecordP.setBackground(Color.lightGray);
//		showrecordP.setVisible(true);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		windowPanel.add(mainPanel); 
//		this.add(mainPanel);  
//		showHelpP.add(new JLabel("HELP Utility")) ; 
//		this.add(showHelpP); 
		/**/
		
		showrecordP.add(showRecordL); 
		
		showRecordL.setEnabled(false);
//		this.add(jScrollPane) ;
		windowPanel.add(jScrollPane);
		jScrollPane.setVisible(false);
		exitP = new JPanel(); 
		JLabel exitLabel = new JLabel(); 
		
		exitP.setBounds(Utility.screenWidth - 230, 10 , 20,20);
		exitLabel.setIcon(new ImageIcon("res/exit.png")); 
		exitP.add(exitLabel);
		exitP.addMouseListener(menuHandler);
		exitP.setToolTipText("exit");
		exitP.setBackground(new Color(0,0,68));
//		this.add(exitP); 
		windowPanel.add(exitP); 
		
		
		this.add(windowPanel);
		this.setUndecorated(true) ; 
		this.setAlwaysOnTop(true);
		this.setMinimumSize(new Dimension(Utility.screenWidth-200,Utility.screenHeight-200));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		newL.addMouseListener(menuHandler); 
		
		this.setLayout(null);
		this.setVisible(true);
		
		
	}
	
	
	
	
	
	private BufferedImage loadBG() {
		BufferedImage img = null; 
		try {
			img = ImageIO.read(new File("res/logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return img ; 
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(imgBufferedImage, 120, 10, 100,100 , null) ; 
	}



	@Override
	public void stateChanged(ChangeEvent e) {
		Utility.currVol = this.slider.getValue() ; 
		
	}
}
