package com.coffeeVendingMachine.CoffeeVendingMachine;

public abstract class Manufacture {
	private int selectionData;
	
	public Manufacture(int selectionData) {
		this.setSelectionData(selectionData);
	}
	
	protected abstract void getCup(int cup);
	
	protected abstract void fillIngredient(int milk,int coffee, int cream);
	
	protected abstract void fillWater(int water);
	
	public final void makeCoffee(int cup,int water, int milk, int coffee, int cream) {
		getCup(cup);
		fillIngredient(milk, coffee, cream);
		fillWater(water);
	}

	public int getSelectionData() {
		return selectionData;
	}

	public void setSelectionData(int selectionData) {
		this.selectionData = selectionData;
	}
}
