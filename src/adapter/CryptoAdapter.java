package adapter;

import java.util.Random;

public class CryptoAdapter extends Crypto {
	Cash cash;
	Random random = new Random();
	public CryptoAdapter(Payment cash1) {
		super(cash1.getPrice(), cash1.getType(), cash1.getCode());
		// TODO Auto-generated constructor stub
		this.cash = (Cash) cash1;
		
		setPrice(cash1.getPrice()/2);
		setType("crypto");
		setCode(generateCode());
	}
	
	public String generateCode() {
		
		StringBuilder sbf = new StringBuilder();
		sbf.append('0');
		String possibility = "abcdefghijklmnopqrstuvwxyz0123456789";
		
		for(int i=0; i<11; i++) {
			
			int randomIdx = random.nextInt(possibility.length());
			char selectedChar = possibility.charAt(randomIdx);
			
			sbf.append(selectedChar);
		}
		return sbf.toString();
		
	}
}
