package adapter;

public class Transfer extends Payment {

	public Transfer(int price, String type, String code) {
		super(price, type, code);
	}


	@Override
	public void pay() {
		System.out.println("============================================");
		System.out.println("Pay with " + getType() +" with Price :" + getPrice());
		System.out.println("Acc number: " + getCode());
		System.out.println("============================================");
	}
	
	
}
