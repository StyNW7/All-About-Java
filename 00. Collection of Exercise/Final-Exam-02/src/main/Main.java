package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Animal;
import model.Bird;
import model.Duck;
import model.Monkey;

public class Main {

	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	ArrayList <Animal> animalList = new ArrayList<>();
	
	public Main() {
		
		int action;
		
		do {
			
			System.out.println("== Jungle Kingdom ==");
			System.out.println("1. Add Animal");
			System.out.println("2. Read Animals");
			System.out.println("3. Delete Animal");
			System.out.println("4. Update Animal");
			System.out.println("5. Exit");
			System.out.print(">> ");
			
			action = scan.nextInt();
			scan.nextLine();
			
			if (action == 1) addAnimal();
			else if (action == 2) showAnimal();
			else if (action == 3) deleteAnimal();
			else if (action == 4) updateAnimal();
			else if (action == 5) break;
			else {
				System.out.println("Invalid Input!");
			}
			
		}
		
		while (true);
		
	}
	
	
	public void addAnimal() {
		
		String name;
		int age;
		String type;
		String ability;
		boolean abilities;
		
		do {
			System.out.print("Input Animal Name [5 - 12 characters]: ");
			name = scan.nextLine();
			if (name.length() >= 5 && name.length() <= 12) break;
		}
		
		while (true);
		
		do {
			System.out.print("Input Animal Age [min: 0, max: 20]: ");
			age = scan.nextInt();
			scan.nextLine();
			if (age >= 0 && age <= 20) break;
		}
		
		while (true);
		
		do {
			System.out.print("Input Animal Type [Monkey | Duck | Bird]: ");
			type = scan.nextLine();
			if (type.equals("Monkey") || type.equals("Duck") || type.equals("Bird")) break;
		}
		
		while (true);
		
		do {
			if (type.equals("Monkey")) System.out.print("Is Monkey Wild? ");
			else if (type.equals("Duck")) System.out.print("Can this duck quack loudly? ");
			else if (type.equals("Bird")) System.out.print("Can this bird sing? ");
			ability = scan.nextLine();
			if (ability.equals("Yes") || ability.equals("No")) break;
		}
		
		while (true);
		
		abilities = (ability.equals("Yes")) ? true : false;
		
		if (type.equals("Monkey")) animalList.add(new Monkey(name, age, abilities));
		else if (type.equals("Bird")) animalList.add(new Bird(name, age, abilities));
		else if (type.equals("Duck")) animalList.add(new Duck(name, age, abilities));
		
		System.out.println("Animal add to the list successfully");
		
		printing();
		
	}
	
	
	public void showAnimal() {
		
		if (animalList.size() == 0) {
			System.out.println("There's no animal yet...");
			printing();
			return;
		}
		
		int index = 0;
		
		for (Animal animal : animalList) {
			
			System.out.printf("Index: %d\n", index++);
			System.out.println("---------------------\n");
			
			if (animal instanceof Monkey) {
				((Monkey) animal).printing();
				((Monkey) animal).ability();
				((Monkey) animal).sound();
				((Monkey) animal).generalAbility();
			}
			
			else if (animal instanceof Bird) {
				((Bird) animal).printing();
				((Bird) animal).ability();
				((Bird) animal).sound();
				((Bird) animal).generalAbility();
			}
			
			else if (animal instanceof Duck) {
				((Duck) animal).printing();
				((Duck) animal).ability();
				((Duck) animal).sound();
				((Duck) animal).generalAbility();
			}
			
			System.out.println("---------------------\n");
			
		}
		
	}
	
	
	public void deleteAnimal() {
		
		if (animalList.size() == 0) {
			System.out.println("There's no animal yet...");
			printing();
			return;
		}
		
		showAnimal();
		
		int indexDel;
		
		do {
			
			System.out.print("Enter index to delete animal: ");
			indexDel = scan.nextInt();
			scan.nextLine();
			
			if  (indexDel >= 0 && indexDel <= animalList.size()-1) break;
			
		}
		
		while (true);
		
		animalList.remove(indexDel);
		
		System.out.println("Animal has been deleted");
		
	}
	
	
	public void updateAnimal() {
		
		if (animalList.size() == 0) {
			System.out.println("There's no animal yet...");
			printing();
			return;
		}
		
		showAnimal();
		
		int indexDel;
		
		do {
			
			System.out.print("Enter index to update animal: ");
			indexDel = scan.nextInt();
			scan.nextLine();
			
			if  (indexDel >= 0 && indexDel <= animalList.size()-1) break;
			System.out.println("Invalid Index :(");
			
		}
		
		while (true);
		
		
		// Update
		
		
		String name;
		int age;
		String ability;
		boolean abilities;
		
		String type = null;
		if (animalList.get(indexDel) instanceof Monkey) type = "Monkey";
		else if (animalList.get(indexDel) instanceof Bird) type = "Bird";
		else if (animalList.get(indexDel) instanceof Duck) type = "Duck";
		
		do {
			System.out.print("Input Animal Name [5 - 12 characters]: ");
			name = scan.nextLine();
			if (name.length() >= 5 && name.length() <= 12) break;
		}
		
		while (true);
		
		do {
			System.out.print("Input Animal Age [min: 0, max: 20]: ");
			age = scan.nextInt();
			scan.nextLine();
			if (age >= 0 && age <= 20) break;
		}
		
		while (true);
		
		do {
			if (type.equals("Monkey")) System.out.print("Is Monkey Wild?");
			else if (type.equals("Duck")) System.out.print("Can this duck quack loudly?");
			else if (type.equals("Bird")) System.out.print("Can this bird sing?");
			ability = scan.nextLine();
			if (ability.equals("Yes") || ability.equals("No")) break;
		}
		
		while (true);
		
		abilities = (ability.equals("Yes")) ? true : false;
		
		
		// Update the animal
		
		
		animalList.get(indexDel).setAbility(abilities);
		animalList.get(indexDel).setName(name);
		animalList.get(indexDel).setAge(age);
		
		System.out.println("Animal has been updated");
		
	}
	

	public void printing() {
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	
	public static void main(String[] args) {
		new Main();
	}

}


