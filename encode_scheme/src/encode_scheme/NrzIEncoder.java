package encode_scheme;

import java.awt.Graphics2D;
import java.util.Base64;

/**
 * 
 * @author Sujoy Das
 *
 */
public class NrzIEncoder extends Encoder{
	
	public NrzIEncoder() {
		super("NrzI Encoding");
	}

	public void encode(Graphics2D g, String data) {
		super.encode(g, data);
		g.drawString("To be encoded by "+name+" scheme", 300,150);
		Character prev = null ; 
		int base = 0 ; 
		for ( int i = 0 ; i < data.length() ; i++ ) {

			choose(g, base, (data.charAt(i)));

			base += 20 ; 
		}
		
		
	}
	private void choose(Graphics2D g, int base, char i) {
		if( i == '0'){
			invert(g,base) ; 
		}else if ( i == '1' ) {
			same(g,base) ;
		}else {
		}
		
	}
	private void same(Graphics2D g, int base) {
		if ( prevVar == 1 ) {
			
			drawHorizontalPositive(g, base);

		}else if ( prevVar == 0 ) {
			drawHorizontalNegative(g, base);

		}
	}
	private static int prevVar = 0 ; 
	private void invert(Graphics2D g, int base ) {
		drawVertical(g, base);
		if ( prevVar == 1 ) {
			drawHorizontalNegative(g, base);
			prevVar = 0 ; 
		}else if ( prevVar == 0 ) {
			drawHorizontalPositive(g, base);
			prevVar = 1 ; 
		}
		
	}
	private void  drawVertical(Graphics2D g , int base ) {
		g.drawLine(150+base+1 , 180-5, 150+(base+1), 180+5);
	}
	private void  drawHorizontalPositive(Graphics2D g , int base) {
		g.drawLine(150+base+1 , 180-5, 150+(base+20), 180-5);
	}
	private void  drawHorizontalNegative(Graphics2D g , int base ) {
		g.drawLine(150+base+1 , 180+5, 150+(base+20), 180+5);
	}
	

}
