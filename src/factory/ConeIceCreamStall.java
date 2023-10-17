package factory;


import adapter.Payment;
import models.ConeIceCream;
import models.IceCream;

public class ConeIceCreamStall extends IceCreamStore{

	@Override
	public IceCream makeIceCream(String flavor, String type,  Payment payment) {
		int price= 0;
		if(type.equals("regular")) {
			price = 10000;
		} else if(type.equals("special")) {
			price = 17000;
		}
		
		
		// TODO Auto-generated method stub
		return new ConeIceCream(flavor, type, price, payment);
	}

}
