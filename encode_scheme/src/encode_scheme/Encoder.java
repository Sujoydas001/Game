package encode_scheme;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * 
 * @author Dr. Sunirmal Khatua
 *
 */
public abstract class Encoder {
	
	String name;
	
	public Encoder(String name) {
		this.name = name;
	}
	
	public void encode(Graphics2D g, String data) {
		g.setBackground(Color.WHITE);
		g.clearRect(0, 0, 800, 800);
		g.drawString(data, 120,90);
		Image i = new ImageIcon("computer.jpg").getImage();
//		g.drawImage(i,100,100,100,100,null);
		g.drawImage(i,700,100,100,100,null);
		g.drawLine(150, 180, 750, 180);
	}

}
