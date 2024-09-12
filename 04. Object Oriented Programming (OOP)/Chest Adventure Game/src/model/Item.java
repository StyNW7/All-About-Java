package model;

public abstract class Item {
	
	protected String itemName;
	protected int itemPoint;
	
	public Item(String itemName, int itemPoint) {
		this.itemName = itemName;
		this.itemPoint = itemPoint;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPoint() {
		return itemPoint;
	}

	public void setItemPoint(int itemPoint) {
		this.itemPoint = itemPoint;
	}
	
	public void printItem() {
		System.out.printf("You have found normal item (%s)!\n", itemName);
		System.out.println("You got " + itemPoint + " points.");
	}
	
	// Polymorp
	
	public void printItem(int protection) {
		System.out.printf("You have found shield item (%s)!\n", itemName);
		System.out.println("You got " + itemPoint + " points.");
	}
	
	public void printItem(int protection, int shield) {
		System.out.printf("You have found potion item (%s)!\n", itemName);
		System.out.println("You got " + itemPoint + " points.");
	}
	
	public void printItem(Boolean multiplier) {
		System.out.printf("You have found (%s)!\n", itemName);
		System.out.println("You have 2x bonus! You got " + (itemPoint * 2) + " points.\n");
	}

}
