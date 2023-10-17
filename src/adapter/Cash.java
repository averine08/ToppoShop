package adapter;

public class Cash extends Payment{
	public Cash(int price, String type, String code) {
		super(price, type, code);

	}
	
	public void pay () {
		
		System.out.println("============================================");
		System.out.println("Pay with " + super.getType() +" with Price :" + getPrice());
		System.out.println("============================================");
	}

}
