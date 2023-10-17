package adapter;

public class Crypto extends Payment {



	public Crypto(int price, String type, String code) {
		super(price, type, code);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("============================================");
		System.out.println("Pay with " + getType() +" with Price :" + getPrice());
		System.out.println("Acc number: " + getCode());
		System.out.println("============================================");
		
	}


}
