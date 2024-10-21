package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.ElectricPokemon;
import model.FirePokemon;
import model.Item;
import model.Pokeball;
import model.Pokemon;
import model.Potion;
import model.WaterPokemon;

public class Main {
	
	
	Scanner scan = new Scanner (System.in);
	Random rand = new Random();
	
	ArrayList <Pokemon> PokemonList = new ArrayList<>();
	ArrayList <Item> ItemList = new ArrayList<>();
	
	
	ArrayList <Pokemon> MyPokemon = new ArrayList<>();
	ArrayList <Item> MyItem = new ArrayList<>();
	
	
	String trainerName;
	
	
	public Main() {
		
		setupItem();
		setupPokemon();
		
		System.out.println("Welcome to the PokemoN Wym 2024\n");
		System.out.print("Please insert your Trainer Name: ");
		trainerName = scan.nextLine();
		
		int action;
		
		do {
			
			PrintingMenu();
			action = scan.nextInt();
			scan.nextLine();
			
			if (action == 1) GetPokemon();
			else if (action == 2) GetItem();
			else if (action == 3) ViewPokemon();
			else if (action == 4) ViewItem();
			else if (action == 5) staticTesting();
			else if (action == 6) break;
			else System.out.println("Input Invalid!\n");
			
		}
		
		while (true);
		
		System.out.printf("\n\nThank youu, %s\n", trainerName);
		
	}
	
	
	public void GetPokemon() {
		
		int index = rand.nextInt(PokemonList.size());
		
		Pokemon getPokemon = PokemonList.get(index);
		
		MyPokemon.add(getPokemon);
		
		System.out.printf("Successfully get %s\n", getPokemon.getName());
		
	}
	
	
	public void GetItem() {
		
		int index = rand.nextInt(ItemList.size());
		
		Item getItem = ItemList.get(index);
		
		MyItem.add(getItem);
		
		System.out.printf("Successfully get %s\n", getItem.getItemName());
		
	}
	
	
	public void ViewPokemon() {
		
		for (int i = 0; i < 80; i++) System.out.print("=");
		System.out.println();
		
		System.out.printf("| %-20s | %-15s | %-6s | %-7s | %-7s | %-6s |\n", "Pokemon Name", "Pokemon Type", "Level", "Attack", "Defense", "Health");
		
		for (int i = 0; i < 80; i++) System.out.print("=");
		System.out.println();
		
		for (Pokemon poke : MyPokemon) {
			System.out.printf("| %-20s | %-15s | %-6d | %-7d | %-7d | %-6d |\n", poke.getName(), poke.getPokemonType(),
					poke.getLevel(), poke.getPokemonAttack(), poke.getPokemonDefense(), poke.getPokemonHealth());
		}
		
		for (int i = 0; i < 80; i++) System.out.print("=");
		System.out.println("\n");
		
	}
	
	
	public void ViewItem() {
		
		for (int i = 0; i < 57; i++) System.out.print("=");
		System.out.println();
		
		System.out.printf("| %-20s | %-15s | %-12s |\n", "Item Name", "Item Cost", "Chance Rate");
		
		for (int i = 0; i < 57; i++) System.out.print("=");
		System.out.println();
		
		for (Item item : MyItem) {
			
			if (item instanceof Pokeball) {
				int chanceRate = ((Pokeball) item).getChanceRate();
				System.out.printf("| %-20s | %-15d | %-12d |\n", item.getItemName(), item.getItemCost(), chanceRate);
			}
			
			else {
				int effect = ((Potion) item).getHealthEffect();
				System.out.printf("| %-20s | %-15d | %-12d |\n", item.getItemName(), item.getItemCost(), effect);
			}
			
		}
		
		for (int i = 0; i < 57; i++) System.out.print("=");
		System.out.println("\n");
		
	}
	
	
	public void PrintingMenu() {
		
		System.out.println("Action Menu");
		System.out.println("=========================");
		System.out.println("1. Get Pokemon");
		System.out.println("2. Get Item");
		System.out.println("3. View Pokemon");
		System.out.println("4. View Item");
		System.out.println("5. Static Testing");
		System.out.println("6. Exit");
		System.out.print(">> ");
		
	}
	
	
	public void setupPokemon() {
		
		File file = new File("pokemon.txt");
		
		// Create new file
		
		if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
		// Read File
        
        try {
			
			Scanner fileRead = new Scanner(file);
			
            while (fileRead.hasNextLine()) {
            	
                String line = fileRead.nextLine();
                String[] parts = line.split("#");
                
//                System.out.println("Test");
                
                if (parts.length == 6) {
                	
                	String pokemonName = parts[0];
                	String pokemonType = parts[1];
                	Integer level = Integer.parseInt(parts[2].trim());
                	Integer attack = Integer.parseInt(parts[3].trim());
                	Integer defense = Integer.parseInt(parts[4].trim());
                	Integer health = Integer.parseInt(parts[5].trim());
                	
                	// Pokemon Type Validation
                	
                	if (pokemonType.equals("Fire")) {
                		Pokemon firePokemon = new FirePokemon(pokemonName, pokemonType, level, attack, defense, health);
                		PokemonList.add(firePokemon);
                	}
                	
                	else if (pokemonType.equals("Water")) {
                		Pokemon waterPokemon = new WaterPokemon(pokemonName, pokemonType, level, attack, defense, health);
                		PokemonList.add(waterPokemon);
                	}
                	
                	else if (pokemonType.equals("Electric")) {
                		Pokemon electricPokemon = new ElectricPokemon(pokemonName, pokemonType, level, attack, defense, health);
                		PokemonList.add(electricPokemon);
                	}
                	
                }
                
            }
            
            fileRead.close();
            
        }
		
		catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	
	public void setupItem() {
		
		File file = new File("item.txt");
		
		// Create new file
		
		if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
		// Read File
        
        try {
			
			Scanner fileRead = new Scanner(file);
			
            while (fileRead.hasNextLine()) {
            	
                String line = fileRead.nextLine();
                String[] parts = line.split("#");
                
//                System.out.println("Test");
                
                if (parts.length == 3) {
                	
                	String itemName = parts[0];
                	Integer itemCost = Integer.parseInt(parts[1].trim());
                	Integer itemEffect = Integer.parseInt(parts[2].trim());
                	
                	// Item Type Validation
                	
                	// Pokeball
                	
//                	System.out.println("Test");
                	
                	if (itemName.startsWith("ball")) {
                		Pokeball newPokeball = new Pokeball(itemName, itemCost, itemEffect);
                		ItemList.add(newPokeball);
                	}
                	
                	// Potion
                	
                	else {
                		Potion newPotion = new Potion(itemName, itemCost, itemEffect);
                		ItemList.add(newPotion);
                	}
                	
                }
                
            }
            
            fileRead.close();
            
        }
		
		catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	
	public void staticTesting() {
		
		// Create Pokemon
		
		Pokemon charmander = new FirePokemon("Charmander", "Fire", 1, 55, 30, 100);
        Pokemon squirtle = new WaterPokemon("Squirtle", "Water", 1, 55, 30, 100);
        Pokemon pikachu = new ElectricPokemon("Pikachu", "Electric", 1, 55, 30, 100);
        
        Pokemon naturalPokemon = new Pokemon("Xavier", "Natural", 1, 55, 30, 100);

        // Use abilities
        
        charmander.useAbility();
        squirtle.useAbility();
        pikachu.useAbility();
        
        naturalPokemon.useAbility();

        // Battle simulation
        
        charmander.attack(squirtle);
        System.out.printf("Squirtle HP: %d\n\n",squirtle.getPokemonHealth());

        // Use items
        
        Potion potion = new Potion("Super Potion", 20, 25);
        potion.useItem(squirtle);
        
        Pokeball pokeball = new Pokeball("Ultra Ball", 150, 50);
        pokeball.useItem(pikachu);
		
	}
	

	public static void main(String[] args) {
		
		new Main();

	}

}
