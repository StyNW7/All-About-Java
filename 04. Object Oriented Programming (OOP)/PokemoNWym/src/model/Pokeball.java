package model;

public class Pokeball extends Item implements ItemInterface {
	
	private int chanceRate;

	public Pokeball(String itemName, int itemCost, int chanceRate) {
		super(itemName, itemCost);
		this.chanceRate = chanceRate;
	}

	public int getChanceRate() {
		return chanceRate;
	}

	public void setChanceRate(int chanceRate) {
		this.chanceRate = chanceRate;
	}
	
	@Override
    public void useItem(Pokemon pokemon) {
        System.out.println("Throwing " + getItemName() + " to catch " + pokemon.getName() + "!\n");
        // Logic to catch the Pokemon could be added here
    }

}
