package main;

import java.util.ArrayList;

import models.IceCream;

public class Database {
	private ArrayList<IceCream> historyTransaction = new ArrayList<>();
	public static Database db = null;
	private Database() {}
	
	public static Database getDb() {
		if(db ==null) {
			db = new Database();
		}
		return db;
	}

	public ArrayList<IceCream> getHistoryTransaction() {
		return historyTransaction;
	}

	public void addHistoryTransaction(IceCream icecream) {
		this.historyTransaction.add(icecream);
	}

}
