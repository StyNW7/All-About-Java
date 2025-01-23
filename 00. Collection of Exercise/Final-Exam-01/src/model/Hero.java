package model;

public abstract class Hero implements Attackable {
	
	private String heroName;
	private Integer heroHP;
	
	public Hero(String heroName, Integer heroHP) {
		super();
		this.heroName = heroName;
		this.heroHP = heroHP;
	}
	
	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}
	
	public Integer getHeroHP() {
		return heroHP;
	}


	public void setHeroHP(Integer heroHP) {
		this.heroHP = heroHP;
	}
	
	// Abstract Method

	public abstract void heroAttack(int damage);
	public abstract void heroMagic(int damage);

}
