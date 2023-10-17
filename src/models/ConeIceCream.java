package models;

import adapter.Payment;

public class ConeIceCream extends IceCream{
	public ConeIceCream(String flavor, String type, int price, Payment payment) {
		super(flavor, type,price, payment );
		payment.setPrice(price); 
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeIceCream() {
		System.out.println("> Prepare the cone");
		System.out.println("> Put the " + this.getFlavor() + "ice cream flavour on the top of the cone");
		if(this.getType().equals("special")) {			
			System.out.println("> Put some " + this.getFlavor().toLowerCase() + "on top of the ice cream");
			System.out.println("> Add extra waffle stick on top of the ice cream");
			System.out.println("> "+ this.getFlavor() + " Special Cone Ice Cream is ready to serve...");
		} else if(this.getType().equals("regular"))
		System.out.println("> "+ this.getFlavor() + " Regular Cone Ice Cream is ready to serve...");
		
		
	}

	@Override
	public Object createClone() {
		// TODO Auto-generated method stub
		ConeIceCream cloneCurrent = null;
		try {
			cloneCurrent = (ConeIceCream) this.clone(); 
			return cloneCurrent;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cloneCurrent;
	}


}
