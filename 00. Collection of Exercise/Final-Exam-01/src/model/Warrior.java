package model;

public class Warrior extends Hero {

	public Warrior(String heroName, Integer heroHP) {
		super(heroName, heroHP);
	}

	@Override
	public int physicalAttack() {
		return 50;
	}

	@Override
	public int magicAttack() {
		return 40;
	}

	@Override
	public void heroAttack(int damage) {
		System.out.printf("Warrior attack with Axe with %d damage\n\n", damage);
	}
	
	@Override
	public void heroMagic(int damage) {
		System.out.printf("Warrior attack with Iron Fist with %d damage\n\n", damage);
	}

}
