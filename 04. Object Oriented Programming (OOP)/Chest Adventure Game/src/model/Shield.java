package model;

public class Shield extends Item {

	public Shield(String itemName, int itemPoint) {
		super(itemName, itemPoint);
	}
	
	public void printItem() {
		System.out.printf("You have found shield item (%s)!\n", itemName);
		System.out.println("You got " + itemPoint + "points.");
	}

}
