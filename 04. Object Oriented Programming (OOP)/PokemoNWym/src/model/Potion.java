package model;

public class Potion extends Item implements ItemInterface {
	
	private int healthEffect;

	public Potion(String itemName, int itemCost, int healthEffect) {
		super(itemName, itemCost);
		this.healthEffect = healthEffect;
	}

	public int getHealthEffect() {
		return healthEffect;
	}

	public void setHealthEffect(int healthEffect) {
		this.healthEffect = healthEffect;
	}
	
	@Override
    public void useItem(Pokemon pokemon) {
        System.out.println("Using " + getItemName() + " on " + pokemon.getName());
        System.out.println(pokemon.getName() + " healed for " + healthEffect + " HP!");
    }

}
