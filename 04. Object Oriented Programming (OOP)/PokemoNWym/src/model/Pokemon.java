package model;

public class Pokemon extends PokemonBlueprint {
	
	protected int pokemonAttack;
	protected int pokemonDefense;
	protected int pokemonHealth;
	
	public Pokemon(String name, String pokemonType, int level, int pokemonAttack, int pokemonDefense, int pokemonHealth) {
		super(name, pokemonType, level);
		this.pokemonAttack = pokemonAttack;
		this.pokemonDefense = pokemonDefense;
		this.pokemonHealth = pokemonHealth;
	}

	public int getPokemonAttack() {
		return pokemonAttack;
	}

	public void setPokemonAttack(int pokemonAttack) {
		this.pokemonAttack = pokemonAttack;
	}

	public int getPokemonDefense() {
		return pokemonDefense;
	}

	public void setPokemonDefense(int pokemonDefense) {
		this.pokemonDefense = pokemonDefense;
	}

	public int getPokemonHealth() {
		return pokemonHealth;
	}

	public void setPokemonHealth(int pokemonHealth) {
		this.pokemonHealth = pokemonHealth;
	}
	
	
	// Without getter and setter function
	
	
	public void takeDamage(int damage) {
        this.pokemonHealth -= damage;
    }

    public void attack(Pokemon enemy) {
        System.out.println(getName() + " attacks " + enemy.getName() + "!\n");
        enemy.takeDamage(this.getPokemonAttack());
    }

    @Override
    public void useAbility() {
        System.out.println(getName() + " uses a generic ability!\n");
    }
	
}
