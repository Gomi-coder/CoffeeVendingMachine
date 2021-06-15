package com.coffeeVendingMachine.CoffeeVendingMachine;

public class DataManager {
	private int selectionData;
	public Stock stock;
	
	public DataManager(Stock stock) {
		// TODO Auto-generated constructor stub
		this.stock = stock;
	}
	
	public void inputData(int selectionData) {
		switch(selectionData){
			case 0: //setInventoryState(cup, water, milk, coffee, cream)
				//americano
				stock.setStockState(1, 800, 0, 200, 0);
				break;
			case 1:
				//Cafe Latte
				stock.setStockState(1, 0, 800, 200, 0);
				break;
			case 2: 
				//Cappuccino
				stock.setStockState(1, 0, 600, 200, 200);
				break;
			case 3: 
				//Dolce Latte
				stock.setStockState(1, 200, 200, 400, 200);
				break;
		}
	}


	public int getSelectionData() {
		return selectionData;
	}


	public void setSelectionData(int selectionData) {
		this.selectionData = selectionData;
	}
}
