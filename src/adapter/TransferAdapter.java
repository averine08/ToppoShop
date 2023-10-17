package adapter;

import java.util.Random;

public class TransferAdapter extends Transfer{
	Cash cash;
	Random random = new Random();
	StringBuilder sbf = new StringBuilder();
	
	public TransferAdapter(Payment cash) {
		super(cash.getPrice(), cash.getType(), cash.getCode());
		this.cash = (Cash) cash;
		double temp = cash.getPrice() * 1.1;
		setPrice((int)temp);
		setType("transfer");
		setCode(generateCode());
		// TODO Auto-generated constructor stub
	}
	public String generateCode() {
		int acc_arr[]= new int[10];
		for (int i=0; i<10; i++) {
			acc_arr[i] = random.nextInt(10);
			sbf.append(acc_arr[i]);
//			System.out.println(acc_arr[i]);
		}
		
		return sbf.toString();
	}
//	public void pay() {
//		System.out.println("============================================");
//		System.out.println("Pay with " + getType() +" with Price :" + getPrice());
//		System.out.println("Acc number : " + getCode());
//		System.out.println("============================================");
//	}



}
