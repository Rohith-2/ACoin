package aieCoin;
import java.security.MessageDigest;

public class Util {
	
	public static String computeHash(final String base) {
	    try{
	        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        final byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        final StringBuilder hexString = new StringBuilder();
	        for (int i = 0; i < hash.length; i++) {
	            final String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) 
	              hexString.append('0');
	            hexString.append(hex);
	        }
	        return hexString.toString();
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
	
	public static void main(String[] args) {
		
		Block g = new Block("0","Rohith");
		g.mineIt();
		System.out.println(g.getHash());
	}
}
