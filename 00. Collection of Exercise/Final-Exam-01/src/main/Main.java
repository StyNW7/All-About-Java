package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Archer;
import model.Hero;
import model.Warrior;
import utility.Printing;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	static Printing print = new Printing();
	
	ArrayList <Hero> heroList = new ArrayList<>();
	
	public Main() {
		
		int action;
		
		do {
			
			System.out.println("BINUS Battle Realms");
			print.dashSpacing();
			
			System.out.println("1. Create New Hero");
			System.out.println("2. View Hero List");
			System.out.println("3. Find Enemy and Battle");
			System.out.println("4. Exit");
			
			System.out.print("Choose option [1-4]: ");
			
			action = scan.nextInt();
			scan.nextLine();
			
			if (action == 1) createNewHero();
			else if (action == 2) showHeroList();
			else if (action == 3) battle();
			else if (action == 4) break;
			else {
				System.out.println("\nInvalid Input!\n");
			}
			
		}
		
		while (action != 4);
		
	}
	
	public void battle() {
		
		if (heroList.size() == 0) {
			System.out.println("There is no hero in Hero List");
			print.clickSpace();
			return;
		}
		
		// Assets
		
		boolean win = false;
		
		// Hero
		
		Hero activeHero = heroList.get(0);
		
		// Enemy
		
		int enemyHP = rand.nextInt(151) + 50;
		
		do {
			
			// Player Turn
			
			System.out.printf("Your HP: %d\n", activeHero.getHeroHP());
			System.out.printf("Enemy HP: %d\n\n", enemyHP);
			
			System.out.println("1. Attack");
			System.out.println("2. Magic\n");
			
			int action;
			
			do {
				System.out.println("Choose [1 - 2]: ");
				action = scan.nextInt();
				scan.nextLine();
				if (action == 1 || action == 2) break;
			}
			
			while (true);
			
			// Check apakah Enemy mati or not
			
			if (activeHero instanceof Warrior) {
				if (action == 1) {
					enemyHP -= ((Warrior) activeHero).physicalAttack();
					((Warrior) activeHero).heroAttack(((Warrior) activeHero).physicalAttack());
				}
				else {
					enemyHP -= ((Warrior) activeHero).magicAttack();
					((Warrior) activeHero).heroMagic(((Warrior) activeHero).magicAttack());
				}
			}
			
			else {
				if (action == 1) {
					enemyHP -= ((Archer) activeHero).physicalAttack();
					((Archer) activeHero).heroAttack(((Archer) activeHero).physicalAttack());
				}
				else {
					enemyHP -= ((Archer) activeHero).magicAttack();
					((Archer) activeHero).heroAttack(((Archer) activeHero).magicAttack());
				}
			}
			
			if (enemyHP <= 0) {
				win = true;
				break;
			}
			
			// Enemy Turn
			
			int enemyAttack = rand.nextInt(61) + 10;
			
			activeHero.setHeroHP(activeHero.getHeroHP() - enemyAttack);
			
			System.out.printf("Enemy attack with %d damage\n\n", enemyAttack);
			
			if (activeHero.getHeroHP() <= 0) {
				win = false;
				break;
			}
			
		}
		
		while (enemyHP > 0 && activeHero.getHeroHP() > 0);
		
		System.out.println("Battle Report");
		
		if (win) System.out.println("Congratulation! You Win!!!");
		
		else {
			System.out.println("Your Hero is Dead on the battle :(");
			System.out.println("It will be removed from Hero List!");
			heroList.remove(0);
		}
		
	}
	
	public void createNewHero() {
		
		String type;
		String name;
		
		do {
			
			System.out.print("Choose hero type [Warrior / Archer]: ");
			type = scan.nextLine();
			if (type.equals("Warrior") || type.equals("Archer")) break;
			
		}
		
		while (true);
		
		do {
			
			System.out.print("Input hero name [5 - 30 Characters]: ");
			name = scan.nextLine();
			if (name.length() >= 5 && name.length() <= 30) break;
			
		}
		
		while (true);
		
		int hp = 0;
		
		if (type.equals("Warrior")) {
			hp = rand.nextInt(151) + 50;
			heroList.add(new Warrior(name, hp));
		}
		
		else {
			hp = rand.nextInt(101) + 50;
			heroList.add(new Archer(name, hp));
		}
		
		System.out.println("Success create new hero...\n");
		
		print.clickSpace();
		
	}
	
	
	public void showHeroList() {
		
		if (heroList.size() == 0) {
			System.out.println("There is no hero in Hero List");
			print.clickSpace();
			return;
		}
		
		System.out.printf("| %-5s | %-20s | %-10s | %-5s |\n", "No", "Name", "Type", "Hp");
		int index = 1;
		String type = "";
		
		for (Hero hero : heroList) {
			type = (hero instanceof Warrior) ? "Warrior" : "Archer";
			System.out.printf("| %-5d | %-20s | %-10s | %-5d |\n", index++, hero.getHeroName(), type, hero.getHeroHP());
		}
		
		System.out.println();
		
	}
	

	public static void main(String[] args) {
		
		new Main();
		
	}

}
