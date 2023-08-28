package encode_scheme;

import java.awt.Graphics2D;

/**
 * 
 * @author Dr. Sunirmal Khatua
 *
 */
public  class EncoderFactory {
	
	public static void encode(Graphics2D g, String scheme, String data) {
		createEncoder(scheme).encode(g, data);
	}
	
	
	public static Encoder createEncoder(String scheme) {
		if(scheme.equals("Manchester")) {
			return new ManchesterEncoder();
		}else if(scheme.equals("Differential Manchester")) {
			return new DifferentialManchesterEncoder();
		}else if(scheme.equals("NRZ-L")) {
			return new NrzLEncoder();
		}else if(scheme.equals("NRZ-I")) {
			return new NrzIEncoder();
		}else if(scheme.equals("AMI")) {
			return new AmiEncoder();
		}else if(scheme.equals("Pseudoternary")) {
			return new PseudometryEncoder();
		}else if(scheme.equals("RZ")) {
			return new RzEncoder();
		}
		else {
			return null;//TO BE DONE for OTHER SCHEMES....
		}
	}
	
	

}
