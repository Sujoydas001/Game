package encode_scheme;

import java.awt.Graphics2D;
import java.security.cert.PKIXRevocationChecker;

/**
 * 
 * @author Dr. Sunirmal Khatua
 *
 */
public class ManchesterEncoder extends Encoder{
	
	public ManchesterEncoder() {
		super("Manchester Encoding");
	}

	public void encode(Graphics2D g, String data) {
		super.encode(g, data);
		g.drawString("To be encoded by "+name+" scheme", 300,150);
		int base = 0 ; 
		Character prev = null ; 
		for ( int i = 0 ; i < data.length() ; i++ ) {
			if (prev != null &&  prev == data.charAt(i)) {
				drawVerticalLine(g,base); 
			}
			if ( data.charAt(i) == '1') {
				drawOne(g,base);
			}else if ( data.charAt(i) == '0') {
				drawZero(g,base);
			} 
			base += 20 ; 
			prev = data.charAt(i);  
		}
	}
	
	
	private void drawVerticalLine(Graphics2D g, int base) {
		g.drawLine(150+base+1 , 180-5, 150+(base+1), 180+5);
		
	}

	private void drawOne(Graphics2D g, int base ) {
		g.drawLine(150+base+1 , 180+5, 150+(base+10), 180+5);
		g.drawLine(150+base+11 , 180+5, 150+(base+11), 180-5);
		g.drawLine(150+base+12 , 180-5, 150+(base+20), 180-5);
		
	}
	private void drawZero(Graphics2D g, int base ) {
		g.drawLine(150+base+1 , 180-5, 150+(base+10), 180-5);
		g.drawLine(150+base+11 , 180+5, 150+(base+11), 180-5);
		g.drawLine(150+base+12 , 180+5, 150+(base+20), 180+5);
	}

}
