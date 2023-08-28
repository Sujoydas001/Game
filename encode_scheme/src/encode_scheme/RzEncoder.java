
package encode_scheme;

import java.awt.Graphics2D;

/**
 * 
 * @author Sujoy das
 *
 */
public class RzEncoder extends Encoder{
	
	public RzEncoder() {
		super("RZ Encoding");
	}

	public void encode(Graphics2D g, String data) {
		super.encode(g, data);
		g.drawString("To be encoded by "+name+" scheme", 300,150);
		int base = 0 ; 
		for ( int i = 0 ; i < data.length() ; i++ ) {
			
			if ( data.charAt(i) == '1') {
				drawOne(g,base) ;
			}else if ( data.charAt(i) == '0') {
				drawZero(g,base) ;
			}
			base += 20 ; 
			 
		}
	}
	
	
	private void drawZero(Graphics2D g, int base) {
		g.drawLine(150+base+1 , 180+5, 150+(base+10), 180+5);
		g.drawLine(150+base+1 , 180, 150+(base+1), 180+5);
		g.drawLine(150+base+1 , 180, 150+(base+10), 180);
		g.drawLine(150+base+11 , 180, 150+(base+11), 180+5);
		
	}

	private void drawOne(Graphics2D g, int base) {
		g.drawLine(150+base+1 , 180-5, 150+(base+10), 180-5);
		g.drawLine(150+base+1 , 180, 150+(base+1), 180-5);
		g.drawLine(150+base+11 , 180, 150+(base+20), 180);
		g.drawLine(150+base+11 , 180, 150+(base+11), 180-5);
		
	}


}
