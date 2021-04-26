package aieCoin;

public class Block {
	String prevHash;
	String data;
	Long timestamp;
	String hash;
	
	int difficulty = 10;
	int nonce = 0;
	
	public Block(String pH,String d) {
		prevHash = pH;
		data = d;
		timestamp = System.currentTimeMillis();
	}
	
	public String hashIt() {
		return Util.computeHash(prevHash+data+timestamp+nonce);
	}
	
	public void mineIt() {
		boolean found = false;
		String tempHash="";
		String diffRef = "";
		for(int i=0;i<difficulty;i++) diffRef += '0';
		while(!found) {
			tempHash = hashIt();
			String diffString = tempHash.substring(0, difficulty);
			
			if(diffString.equals(diffRef)) found = true;
			else nonce++;
		}
		hash = tempHash;
		
	}
	
	public String getHash() {
		return hash;
	}
	
}
