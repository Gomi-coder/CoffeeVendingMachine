package com.coffeeVendingMachine.CoffeeVendingMachine;

public class Controller implements coffeeVendingMachine {
	private int selectionData, selectionPrice, cash;
	private UserPanel userPanel;
	private MoneyManager moneyManager;
	private DataManager dataManager;
	private Stock stock;
	private Dispensor manufacture;
	
	public Controller(UserPanel userPanel) {
		this.userPanel = userPanel;
	}
	
	public void inputInfo(int selection,int cash, int selectionPrice) {
		selectionData = selection;
		this.cash = cash;
		this.selectionPrice = selectionPrice;
		
		moneyManager = new MoneyManager();
		moneyManager.inputMoney(this.selectionData, this.cash, this.selectionPrice);
		checkChange();
	}
	
	private void getResult() {
		returnCoffee();
		returnChange();
	}
	
	private void checkChange() {
		stock = new Stock();
		dataManager = new DataManager(stock);
		if(moneyManager.getChangeState() == true){userPanel.activityLog.append("[error]not enough cash. \ninsert more Or return.\n");}
		else{
			dataManager.inputData(selectionData);
			checkStock();
		}
	}
	
	private void checkStock() {
		if((stock.getCheckState())==true){
			manufacture = new Dispensor(selectionData);
			manufacture.makeCoffee(stock.getCup(), stock.getWater(), stock.getMilk(), stock.getCoffee(), stock.getCream());
			getResult();
		}
		else{
			userPanel.disableBtn();
		}
	}
	
	private void returnCoffee() {
		switch(selectionData){
			case 0:
				userPanel.activityLog.append(">>Americano.\n");
				break;
			case 1:
				userPanel.activityLog.append(">>Cafe Latte.\n");
				break;
			case 2:
				userPanel.activityLog.append(">>Cappuccino.\n");
				break;
			case 3:
				userPanel.activityLog.append(">>Dolce Latte.\n");
				break;
		}
	}
	
	private void returnChange() {
		userPanel.slot.setText("Change is " + Integer.toString(moneyManager.getChange()) + ".\n");
		MoneyManager.total = MoneyManager.total + selectionPrice;
	}
}
