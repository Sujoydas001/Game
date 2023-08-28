package encode_scheme;

import java.awt.Graphics2D;

/**
 * 
 * @author Dr. Sunirmal Khatua
 *
 */
public class DifferentialManchesterEncoder extends Encoder{
	
	public DifferentialManchesterEncoder() {
		super("Differential Manchester Encoding");
	}

	public void encode(Graphics2D g, String data) {
		super.encode(g, data);
		g.drawString("To be encoded by "+name+" scheme", 300,150);
		int base = 0 ; 
		for ( int i = 0 ; i < data.length() ; i++ ) {
			if ( data.charAt(i) == '1') {
				keepSame(g,base); 
			}else if ( data.charAt(i) == '0') {
				invert(g,base); 
			}
			
			base += 20 ; 
		}
		
	}
	private static int prevVar = 0 ; 
	private void invert(Graphics2D g, int base ) {
		drawVertical(g, base);
		if ( prevVar == 1 ) {
			startAtDown(g, base);
			
		}else if ( prevVar == 0 ) {
			startAtUp(g, base);
			
		}
		
	}

	private void keepSame(Graphics2D g, int base ) {
		if ( prevVar == 1 ) {
			startAtUp(g, base);
			prevVar = 0 ; 
		}else if ( prevVar == 0 ) {
			startAtDown(g, base);
			prevVar = 1 ; 
			
		}
	}
	private void  drawVertical(Graphics2D g , int base ) {
		g.drawLine(150+base+1 , 180-5, 150+(base+1), 180+5);
	}
	private void startAtDown(Graphics2D g, int base ) {
		g.drawLine(150+base+1 , 180+5, 150+(base+10), 180+5);
		g.drawLine(150+base+11 , 180+5, 150+(base+11), 180-5);
		g.drawLine(150+base+12 , 180-5, 150+(base+20), 180-5);
	}
	private void startAtUp(Graphics2D g, int base ) {
		g.drawLine(150+base+1 , 180-5, 150+(base+10), 180-5);
		g.drawLine(150+base+11 , 180+5, 150+(base+11), 180-5);
		g.drawLine(150+base+12 , 180+5, 150+(base+20), 180+5);
	}

}
