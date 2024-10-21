package model;

public abstract class PokemonBlueprint {
	
	protected String name;
	protected String pokemonType;
	protected int level;
	
	public PokemonBlueprint(String name, String pokemonType, int level) {
		this.name = name;
		this.pokemonType = pokemonType;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPokemonType() {
		return pokemonType;
	}

	public void setPokemonType(String pokemonType) {
		this.pokemonType = pokemonType;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
	// Without getter and setter function
	
	
	public void levelUp() {
        this.level++;
    }

    // Abstract method to define the unique ability
	
    public abstract void useAbility();

}
