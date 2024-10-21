package model;

public abstract class Item {
	
	protected String itemName;
	protected int itemCost;
	
	public Item(String itemName, int itemCost) {
		this.itemName = itemName;
		this.itemCost = itemCost;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemCost() {
		return itemCost;
	}

	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}

}
