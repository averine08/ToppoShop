package models;

import adapter.Payment;
import main.IClone;


public abstract class IceCream implements IClone {
	private String flavor;
	private String type;
	private int price;
	private Payment payment;
	

	public IceCream(String flavor, String type, int price, Payment payment) {
		super();
		this.flavor = flavor;
		this.type = type;
		this.price = price;
		this.payment = payment;
	}

	public abstract void makeIceCream();
	
	public String getFlavor() {
		return flavor;
	}


	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
