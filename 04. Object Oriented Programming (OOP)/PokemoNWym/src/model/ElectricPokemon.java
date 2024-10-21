package model;

public class ElectricPokemon extends Pokemon {

	public ElectricPokemon(String name, String pokemonType, int level, int pokemonAttack, int pokemonDefense, int pokemonHealth) {
		super(name, pokemonType, level, pokemonAttack, pokemonDefense, pokemonHealth);
	}

	@Override
    public void useAbility() {
        System.out.println(getName() + " uses Thunderbolt!\n");
    }
	
}
