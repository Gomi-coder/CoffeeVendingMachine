package com.coffeeVendingMachine.CoffeeVendingMachine;

public class Dispensor {
	public Dispensor(int selectionData) {
		// TODO Auto-generated constructor stub
		this.setSelectionData(selectionData);
	}

	private void setSelectionData(int selectionData) {
	}

	protected void getCup(int cup) {
		dropCup(cup);
	}
	
	protected void fillIngerdient(int milk, int coffee, int cream) {
		pour(milk, coffee, cream);
	}
	
	protected void fillWater(int water) {
		pour(water);
	}
	
	private void dropCup(int cup) {
		Stock.numOfCups -= cup;
	}
	
	private void pour(int milk, int coffee, int cream) {
		Stock.amountOfMilk -= milk;
		Stock.amountOfMilk -= coffee;
		Stock.amountOfCream -= cream;
	}
	
	private void pour(int water) {
		Stock.amountOfWater -= water;
	}

	public void makeCoffee(int cup, int water, int milk, int coffee, int cream) {
		// TODO Auto-generated method stub
		getCup(cup);
		fillIngerdient(milk, coffee, cream);
		fillWater(water);
	}
}
