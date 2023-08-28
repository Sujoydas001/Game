
package encode_scheme;

import java.awt.Graphics2D;


/**
 * 
 * @author Sujoy Das
 *
 */
public class NrzLEncoder extends Encoder{
	
	public NrzLEncoder() {
		super("NrzL Encoding");
	}

	public void encode(Graphics2D g, String data) {
		super.encode(g, data);
		g.drawString("To be encoded by "+name+" scheme", 300,150);
		int k = 0 ;
		Character prev = null ; 
		for( int i = 0 ; i < data.length() ; i++ ) {
			if (prev != null  &&  prev != data.charAt(i)) {
				g.drawLine(150+k+1 , 180-5, 150+(k+1), 180+5);
			}
			if ( data.charAt(i) == '1') {
				g.drawLine(150+k+1 , 180-5, 150+(k+20), 180-5);
			}else if ( data.charAt(i) == '0') {
				g.drawLine(150+k+1 , 180+5, 150+(k+20), 180+5);
			}else {
				
			}
			prev =Character.valueOf( data.charAt(i) ); 
			k = k + 20 ; 
		}
		
	}

}
