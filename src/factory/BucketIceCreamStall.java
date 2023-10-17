package factory;


import adapter.Payment;
import models.BucketIceCream;
import models.IceCream;

public class BucketIceCreamStall extends IceCreamStore {



	@Override
	public IceCream makeIceCream(String flavor, String type, Payment payment) {
		// TODO Auto-generated method stub
		int price =0;
		if(type.equals("regular")){
			price = 40000;
		}else if(type.equals("special")) {
			price = 50000;
		}
		// TODO Auto-generated method stub
		return new BucketIceCream(flavor, type, price, payment);
		
	}

}
