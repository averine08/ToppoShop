package factory;


import adapter.Payment;
import models.IceCream;

public abstract class IceCreamStore {
	
	public IceCream orderIceCream(String flavor, String type, Payment payment) {
		System.out.println("creating Ice Cream!");
		IceCream icecream = makeIceCream(flavor, type, payment);
		icecream.makeIceCream();
		System.out.println("Giving ice cream to client");
		return icecream;
	}
	
	public abstract IceCream makeIceCream(String flavor, String type, Payment payment);




}
