package model;

public class Archer extends Hero {
	
	public Archer(String heroName, Integer heroHP) {
		super(heroName, heroHP);
	}

	@Override
	public int physicalAttack() {
		return 30;
	}

	@Override
	public int magicAttack() {
		return 60;
	}

	@Override
	public void heroAttack(int damage) {
		System.out.printf("Archer attack with Arrow Blast with %d damage\n\n", damage);
	}
	
	@Override
	public void heroMagic(int damage) {
		System.out.printf("Archer attack with Golden Arrow with %d damage\n\n", damage);
	}

}
