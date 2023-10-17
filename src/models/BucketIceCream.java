package models;

import adapter.Payment;

public class BucketIceCream extends IceCream {

	public BucketIceCream(String flavor, String type, int price, Payment payment) {
		super(flavor, type, price, payment);
		payment.setPrice(price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeIceCream() {
		System.out.println(">Prepare a bucket");
		System.out.println(">Fill the ice cream until the box is full");
		System.out.println(this.getFlavor() + this.getType() + "Bucket Ice cream is ready to serve...");
		
	}

	@Override
	public Object createClone() {
		// TODO Auto-generated method stub
		try {
			return this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
