package com.coffeeVendingMachine.CoffeeVendingMachine;

public class MoneyManager {
	private int cash;
	private int selectionPrice;
	private int change;
	static int total = 1000;
	private int selectionData;
	private boolean changeState;
	
	public MoneyManager() {
	
	}
	
	public void inputMoney(int selectionData, int cash, int selectionPrice) {
		this.selectionData = selectionData;
		this.selectionPrice = selectionPrice;
		this.cash = cash;
		
		setChangeState(this.cash, this.selectionPrice);
	}
	
	public static void updateTotal(int withdrawal) {
		total -= withdrawal;
	}
	
	private void setChangeState(int cash, int selectionPrice) {
		if(cash<selectionPrice){
			changeState = true;
		}
		else{
			this.change = cash - selectionPrice;
			changeState = false;
		}
	}
	
	public int getChange() {
		return change;
	}
	
	public boolean getChangeState() {
		return changeState;
	}

	public int getSelectionData() {
		return selectionData;
	}

	public void setSelectionData(int selectionData) {
		this.selectionData = selectionData;
	}
}
