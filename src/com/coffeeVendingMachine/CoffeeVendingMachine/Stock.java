package com.coffeeVendingMachine.CoffeeVendingMachine;

public class Stock {
	static int numOfCups = 30;
	static int amountOfWater = 4000;
	static int amountOfMilk = 6000;
	static int amountOfCream = 3000;
	static int amountOfCoffee = 4000;
	
	private boolean stockState = true;
	
	public int cup = 0, water = 0, milk = 0, coffee = 0, cream = 0;
	
	public Stock() {

	}
	
	public void setStockState(int cup, int water, int milk, int coffee, int cream) {
		this.cup = cup;
		this.water = water;
		this.milk = milk;
		this.coffee = coffee;
		this.cream = cream;
		if((numOfCups-cup)>=0 && (amountOfWater-water)>=0 && (amountOfMilk-milk)>=0 && (amountOfCoffee-coffee)>=0 && (amountOfCream-cream)>=0){
			stockState = true;
		}	
		else stockState = false;
	}
	
	public static void updateStock(int cup, int water, int milk, int coffee, int cream) {
		numOfCups += cup;
		amountOfWater += water;
		amountOfMilk += milk;
		amountOfCoffee += coffee;
		amountOfCream += cream;
	}
	
	public static int getIngredient(int n) {
		if(n == 0) return numOfCups;
		else if(n == 1) return amountOfWater;
		else if(n == 2) return amountOfMilk;
		else if(n==3) return amountOfCoffee;
		else return amountOfCream;
	}
	
	public int getCup() {
		return cup;
	}
	
	public int getWater() {
		return water;
	}
	
	public int getMilk() {
		return milk;
	}
	
	public int getCream() {
		return cream;
	}
	
	public int getCoffee() {
		return coffee;
	}
	
	public boolean getCheckState() {
		return stockState;
	}
}
