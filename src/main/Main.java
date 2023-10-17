package main;

import java.util.ArrayList;
import java.util.Scanner;

import javax.crypto.spec.ChaCha20ParameterSpec;

import adapter.Cash;
import adapter.CryptoAdapter;
import adapter.Payment;
import adapter.TransferAdapter;
import factory.BucketIceCreamStall;
import factory.ConeIceCreamStall;
import factory.IceCreamStore;
import models.IceCream;

public class Main {
	public static Scanner scanner = new Scanner(System.in);
	Database db = Database.getDb();

	String payment = "akkaka";
	
	
	public void ConeIceCreamStall(String flavor, String type) {
		IceCreamStore coneStore = new ConeIceCreamStall();
		Payment choosenPayment = new Cash(0, "cash", "");
		IceCream es1 = coneStore.orderIceCream(flavor, type, choosenPayment);
		choosenPayment.setPrice(es1.getPrice());
		inputPayment();
		if(payment.equals("transfer")) {
			choosenPayment = new TransferAdapter(choosenPayment);
		}else if(payment.equals("crypto")) {
			choosenPayment = new CryptoAdapter(choosenPayment);
		}
		choosenPayment.pay();
		es1.setPayment(choosenPayment);
		db.addHistoryTransaction(es1);
		System.out.println("");
		
		System.out.println("-----CREATING CLONE OF PREVIOUS ICE CREAM CONE----");
		IceCream es1_copy = (IceCream) es1.createClone();
		System.out.println(es1);
		System.out.println(es1_copy);
	}
	
	public void BucketeIceCreamStall(String flavor, String type) {
		IceCreamStore bucketStore = new BucketIceCreamStall();
		Payment choosenPayment = new Cash(0, "cash", "");
		IceCream es2 = bucketStore.orderIceCream(flavor, type, choosenPayment);
		choosenPayment.setPrice(es2.getPrice());
		
		inputPayment();
		if(payment.equals("transfer")) {
			choosenPayment = new TransferAdapter(choosenPayment);
		}else if(payment.equals("crypto")) {
			choosenPayment = new CryptoAdapter(choosenPayment);
		}
		choosenPayment.pay();
		es2.setPayment(choosenPayment);
		db.addHistoryTransaction(es2);
		
		System.out.println("-----CREATING CLONE OF PREVIOUS BUCKET CREAM CONE----");
		IceCream es2_copy = (IceCream) es2.createClone();
		System.out.println(es2);
		System.out.println(es2_copy);
	}
	
	public String inputFlavor(String flavor) {
		System.out.println("What flavor do you want?");
		do {
			System.out.print("input ['Strawberry' or 'Chocolate']:");
			flavor = scanner.nextLine();
		}while(!(flavor.equals("Strawberry")) && !(flavor.equals("Chocolate")) );
		
		return flavor;
	}
	
	public String inputType(String type) {
		System.out.println("What type do you want?");
		do {
			System.out.print("input ['regular' or 'special']:");
			type = scanner.nextLine();
		}while(!(type.equals("regular")) && !(type.equals("special")) ) ;
		return type;
	}
	public void inputPayment() {
		System.out.println("What payment do you want to use?");
		do {
			System.out.println("input ['cash' or 'transfer' or 'crypto']: ");
			payment = scanner.nextLine();
		}while (!(payment.equals("cash")) && !(payment.equals("transfer")) && !(payment.equals("crypto")) );
	}
	public Main() {
		// TODO Auto-generated constructor stub
		int input;
		String flavor= "null";
		String type = "null";

		do {
		System.out.println("Where do you want to go? ");
		System.out.println("1. Cone Ice Cream Stall");
		System.out.println("2. Bucket Ice Cream Stall");
		System.out.println("0. Exit");
		System.out.print(">> Input : ");
		input = scanner.nextInt();
		scanner.nextLine();
		System.out.println("");

			if(input== 1) {
				flavor = inputFlavor(flavor);
				type = inputType(type);
				ConeIceCreamStall(flavor, type);
				System.out.println("");
			}else if(input ==2) {
				flavor = inputFlavor(flavor);
				type = inputType(type);
				BucketeIceCreamStall(flavor, type);
				System.out.println("");
			}
		} while(input != 0);
		
		
		ArrayList<IceCream> history = db.getHistoryTransaction();
		
		int totalSpent =0;
		System.out.println("ORDER HISTORY");
		for(IceCream ic : history) {
			
			System.out.println("> "+ic.getFlavor() + " " + ic.getType() + " " +ic.getPayment().getType() + " - " + ic.getPrice());
			ic.getPayment().pay();
			System.out.println();
			
			
			totalSpent+= ic.getPrice();
		}
		System.out.println("You have been spend : " + totalSpent);
		System.out.println("Thankyou For coming!");
		

		

	}
	public static void main(String[] args) {
		new Main()
;	}
}
