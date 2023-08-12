package com.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UnitTest extends JFrame{
	public UnitTest() {
		this.setMinimumSize(new Dimension(600,600));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		JPanel panel = new JPanel(); 
		panel.setLayout(new BorderLayout());
		JLabel label = new JLabel(""); 
		panel.add(label); 
		ImageIcon imgIcon = new ImageIcon("res/exit.png"); 
//		imgIcon.set
		label.setIcon(imgIcon);
		this.add(panel); 
		this.setVisible(true);
		
	}
	public static void main(String []a) {
//		System.out.println("hell");
		new UnitTest(); 
	}
}




//
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//
//import javax.swing.JFrame;
//import javax.swing.JSlider;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//
//import SoundPlayerThread;
//
//public class UnitTest extends JFrame implements ChangeListener{
//	public JSlider slider ; 
//	public UnitTest() {
//		this.setMinimumSize(new Dimension(600,600));
//		this.setLocationRelativeTo(null);
//		this.setResizable(false);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setLayout(new FlowLayout());
//		slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);   
//		this.add(slider); 
//		this.setVisible(true);
//		slider.addChangeListener(this);
//		Thread run = new Thread(new SoundPlayerThread("res/bg.wav",true)) ; 
//		run.start(); 
//	}
//	public static void main(String []a) {
//		System.out.println("hell");
////		play() ; 
//		new UnitTest(); 
//		
//	}
//	@Override
//	public void stateChanged(ChangeEvent e) {
////		System.out.println("y");
////		if ( e.getSource().equals(slider)) {
////			System.out.println(slider.getValue());
//		TestUtility.currVol = slider.getValue(); 
////		}
//		
//	}
//	
//	
//	
////	public static void play() {
////		 try {
////			 	File audioFile = new File("res/incr.wav"); 
////			 	AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
//////			 	audioStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource("res/bg.wav" )); 
////		        AudioFormat format = audioStream.getFormat();
////		        Info info = new DataLine.Info(Clip.class, format);
////		        Clip audioClip = (Clip) AudioSystem.getLine(info);  
////		        audioClip.open(audioStream);
////
////		        while( true  ) {
//////	        		audioStream = AudioSystem.getAudioInputStream(audioFile);
//////		        	format = audioStream.getFormat();
//////		        	info = new DataLine.Info(Clip.class, format);
//////		        	audioClip = (Clip) AudioSystem.getLine(info);
////		        	
////		        	float currVol = 0; 
////		        	FloatControl gainControl   = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
////			        gainControl.setValue(0.0f  + currVol/10 - 5.0f );
////		        	audioClip.start();
//////		        	if ( audioClip.isOpen()) {
//////		        		System.out.println("open");
//////		        	}else {
//////		        		System.out.println("close");
//////		        	}
////		        	
////		        	boolean audiorun = audioClip.isOpen() ;
////		        	boolean  on = true ; 
//////		        	Thread thread = new Thread( new Runnable() {
//////						@Override
//////						public void run() {
//////							while( audiorun  ) {
//////								gainControl.setValue(0.0f  + currVol/10 - 5.0f); 
//////								try {
//////									Thread.sleep(1) ;
//////								} catch (InterruptedException e) {
//////									e.printStackTrace();
//////								}
////////								audiorun = audioClip.isOpen() ; 
//////								if ( !on ) {
//////									audioClip.stop(); 
//////								}
//////							}
//////						}
//////					} );
//////		        	thread.start() ; 
////			        Thread.sleep(audioClip.getMicrosecondLength() / 1000);	
//////		        }
//////			        if ( audioClip.isOpen()) {
//////			        	System.out.println("open");
//////		        	}else {
//////		        		System.out.println("close");
//////		        	}
////			        audioClip.setFramePosition(0);
//////			        audioClip.close();
//////			        audioClip.loop(Clip.LOOP_CONTINUOUSLY); 
////		        }
////		 	} catch ( IOException | InterruptedException | UnsupportedAudioFileException | LineUnavailableException ex) {
////		 		ex.printStackTrace();
////		    }
////	}
//
//
//
//
//}
//
//
//
//
//
//
//
//
////
////
////import java.awt.*;
////import java.awt.event.ActionEvent;
////import java.awt.event.ActionListener;
////import java.io.BufferedReader;
////import java.io.File;
////import java.io.FileInputStream;
////import java.io.FileNotFoundException;
////import java.io.IOException;
////import java.io.InputStreamReader;
////import java.text.SimpleDateFormat;
////
////import javax.swing.*;
////
////
////import java.util.Date;
////
////public class UnitTest extends JFrame implements ActionListener{
////	public UnitTest() {
//////		System.out.println("new game starts .....");
////		this.setMinimumSize(new Dimension(600,600));
////		this.setLocationRelativeTo(null);
////		this.setResizable(false);
////		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
////		this.setLayout(new BorderLayout());
////		this.setUndecorated(true); 
////		this.setOpacity(1.0f);
////		JButton btnJPanel = new JButton("button") ; 
////		btnJPanel.addActionListener(this);
////		this.add(btnJPanel); 
////	}
////	public static void main(String []a) {
////		new UnitTest().setVisible(true);
//////		testLog() ; 
//////		inputtest();
//////		new MenuScreen().setVisible(true);  
////		
////
////	}
////
////	public static void inputtest() {
////		try {
////			
////			File file= new File("a.txt") ; 
////			if ( !file.exists()) {
////				file.createNewFile();
////			}
////			BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
////			while( bReader.ready()) {
////				System.out.println(bReader.readLine());
////			}
////			bReader.close();
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////	}
////	public static void testLog() {
////		Log log = new Log();
////		log.d("f for frog\n");
////		Thread thread = new Thread(new Runnable() {
////			static int idx = 0 ; 
////			@Override
////			public void run() {
//////				while(true) {
//////					log.d(String.valueOf(idx++)) ; 
//////					try {
//////						Thread.sleep(1000);
//////					} catch (InterruptedException e) {
//////						// TODO Auto-generated catch block
//////						e.printStackTrace();
//////					}
//////				}
////			}
////		});
//////		thread.start();
////	}
////	@Override
////	public void actionPerformed(ActionEvent e) {
////		this.setOpacity(this.getOpacity()-0.1f);
////		
////	}
////	
////	
//////	@Override
//////	public void paint(Graphics g) {
//////	    super.paint(g);
//////	
//////	    int width = getWidth();
//////	    int height = getHeight();
//////	
//////	    // Define the gradient start and end points
////////	    Point startPoint = new Point(300, 0);  // Top-left corner
////////	    Point endPoint = new Point(0, height); // Bottom-left corner
////////	
////////	    // Define the gradient colors and their corresponding positions
////////	    Color startColor = Color.RED; // Gradient start color
////////	    Color endColor = Color.BLUE;  // Gradient end color
//////
//////	
//////	    // Create the GradientPaint object
////////	    GradientPaint gradient = new GradientPaint(startPoint, startColor, endPoint, endColor);
//////	
//////	    // Use the gradient to fill the component's background
//////	    Graphics2D g2d = (Graphics2D) g;
////////	    g2d.setPaint(new GradientPaint(new Point(0,height-50),Color.white,new Point(0,height),Color.RED));
//////	    g2d.setPaint(new GradientPaint(new Point(0,20),Color.RED,new Point(0,70),Color.WHITE));
////////	    g2d.setPaint(new GradientPaint(new Point(0,0),Color.RED,new Point(50,0),Color.WHITE));
////////	    g2d.setPaint(new GradientPaint(new Point(width-50,0),Color.WHITE,new Point(width,0),Color.RED));
//////	    
//////	    g2d.fillRect(0, 0, width, height);
//////	}
////
////
////
////
////}