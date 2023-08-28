
package encode_scheme;

import java.awt.Graphics2D;
import java.security.cert.PKIXRevocationChecker;

/**
 * 
 * @author Sujoy das
 *
 */
public class PseudometryEncoder extends Encoder{
	
	public PseudometryEncoder() {
		super("Pseudometry Encoding");
	}

	public void encode(Graphics2D g, String data) {
		super.encode(g, data);
		g.drawString("To be encoded by "+name+" scheme", 300,150);
		int base = 0 ; 
		for ( int i = 0 ; i < data.length() ; i++ ) {
			
			if ( data.charAt(i) == '0') {
				draw(g,base) ; 
			}
			
			
			base += 20 ; 
			 
		}
	}
	
	private boolean prevPositive = true ; 
	private void draw(Graphics2D g,int base) {
		if ( prevPositive ) {
			drawPositive(g,base);
			prevPositive = false ; 
		}else {
			drawNegative(g,base);
			prevPositive = true ; 
		}
	}


	private void drawPositive(Graphics2D g, int base ) {
		
		g.drawLine(150+base+1 , 180, 150+(base+1), 180-10);
		g.drawLine(150+base+1 , 180-10, 150+(base+20), 180-10);
		g.drawLine(150+base+20 , 180, 150+(base+20), 180-10);
		
		
	}
	private void drawNegative(Graphics2D g, int base ) {
		g.drawLine(150+base+1 , 180, 150+(base+1), 180+10);
		g.drawLine(150+base+1 , 180+10, 150+(base+20), 180+10);
		g.drawLine(150+base+20 , 180, 150+(base+20), 180+10);
		
	}

}
