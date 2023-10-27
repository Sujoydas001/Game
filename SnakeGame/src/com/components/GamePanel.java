package com.components;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import com.entity.Snake;
import com.helper.Controller;
import com.helper.GemsManager;
import com.io.InputListener;
import com.utils.Utility;


public class GamePanel extends JPanel implements ScreenComponents{
	public  Snake snake =  null ; 
	public InputListener inputListener = null; 
	public Controller controller  = null;
	public GemsManager gemsManager = null ; 
	
	public GamePanel(Snake snake, GemsManager gemsManager,Controller controller) {
		this.snake  = snake ;
		this.gemsManager = gemsManager ; 
		this.controller = controller ; 

		this.setBounds(0,Utility.scoreBoardHeight,Utility.panelWidth, Utility.panelHeight);

		this.setLayout(null);
		
		this.setBackground(new Color(0,0,30)) ; 	
		
		
		inputListener = new InputListener(this); 
		this.addKeyListener(inputListener);
		Utility.log.d("panel setup done ....");
		
		
		
		
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g ; 
		
		g2d.setBackground(Color.BLACK);
			this.snake.refresh(g) ; 
			this.gemsManager.refresh(g); 
//			this.controller.warnForBoundary(g);	
	}
	public void refresh() {
		repaint(); 
		
		
	}

	public void update() {
		this.snake.update();
		this.controller.checkGameLogic();
		 
	}
	
}
