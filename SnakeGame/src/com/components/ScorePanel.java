package com.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.io.InputListener;
import com.threads.SoundPlayerThread;
import com.utils.Utility;

public class ScorePanel extends JPanel implements ScreenComponents{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel pauseBtn = new JPanel(); 
	public JPanel scoreBoard = new JPanel(); 
	public JLabel scoreLabel = new JLabel("HIGH SCORE : 0 SCORE : 0 ") ; 
	InputListener inputListener ; 
	private boolean firstHighScoreBoolean = true ; 
	public ScorePanel() {
		this.setBounds(0,0,Utility.panelWidth,Utility.scoreBoardHeight);
		scoreBoard.setBounds(Utility.panelWidth -300 , 10 , 190, 21 );
		scoreLabel.setFont(new Font("Arial", Font.PLAIN, 10));
		scoreBoard.add(scoreLabel) ; 
		scoreBoard.setBackground(Color.RED);
		pauseBtn.setBounds(Utility.panelWidth -330 , 10 , 21, 21 );
		pauseBtn.setBackground(Color.GRAY);
		this.add(scoreBoard);
		this.add(pauseBtn) ; 
		this.setLayout(null);
		inputListener = new InputListener(this) ; 
		pauseBtn.addMouseListener(inputListener);
		this.setScoreBoard(0);
	}
	public void setScoreBoard(int score) {
		int prevscore = Utility.gameManager.scorebase.highscoreCard.score ;
		if( score > prevscore ) {
			prevscore = score ; 
			if ( firstHighScoreBoolean ) {
				setHighScoreSound(); 
				firstHighScoreBoolean = false ; 
			}
		}
		this.scoreLabel.setText("HIGH SCORE : "+prevscore+" SCORE : "+ score);
	}
	private void setHighScoreSound() {
		Thread run = new Thread(new SoundPlayerThread("res/highscore.wav",false)) ; 
		run.start(); 
	}
}
