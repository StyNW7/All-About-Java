package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	
	// Global Variable
	
	static String name1;
	static String name2;
	
	static ArrayList<Integer> player1Cards = new ArrayList<>();
	static ArrayList<Integer> player2Cards = new ArrayList<>();
	
	static int playerTurn = 1;
	
	// I think using 6 ArrayList is better than using 6 variable size
	// using two dimensional array
	
	static ArrayList<Integer> player1Arena1 = new ArrayList<>();
	static ArrayList<Integer> player1Arena2 = new ArrayList<>();
	static ArrayList<Integer> player1Arena3 = new ArrayList<>();
	
	static ArrayList<Integer> player2Arena1 = new ArrayList<>();
	static ArrayList<Integer> player2Arena2 = new ArrayList<>();
	static ArrayList<Integer> player2Arena3 = new ArrayList<>();
	
	// Actually in this case we can use 2 arrayList using 2 dimensional:
	
	
	//	static ArrayList<ArrayList<Integer>> player1Arena = new ArrayList<>();
	//	static ArrayList<ArrayList<Integer>> player2Arena = new ArrayList<>();
	
	
	// Public Static Void Main Function

	public static void main(String[] args) {
		
		int action;
		
		do {
			
			System.out.println("RigJaw\n");
			System.out.println("1. Play Game");
			System.out.println("2. Quit Game");
			System.out.println(">> ");
			action = scan.nextInt();
			scan.nextLine();
			
			if (action == 1) {
				playGame();
			}
			
			else if (action == 2) {
				printExit();
			}
			
		}
		
		while (action != 2);

	}
	
	// PlayGame Logic Function
	
	public static void playGame() {
		
		clearScreen();
		
		nameValidation();
		
		startRandomCard();
		
		clearScreen();
		
		while (player1Cards.size() != 0 || player2Cards.size() != 0) {
			clearScreen();
			arenaPrinting();
			playerTurnInput();
		}
		
		clearScreen();
		arenaPrinting();
		clearScreen();
		
		winnerChecker();
		
		clearScreen();
		
		removeAllValues();

	}
	
	// Name Validation Function
	
	public static void nameValidation() {
		
		// Name's Validation
		
		do {
			System.out.print("Input Player 1's Name [5 - 10 Characters]: ");
			name1 = scan.nextLine();
			if (name1.length() >= 5 && name1.length() <= 10) break;
			else System.out.println("Name length must between 5 - 10 Characters\n");
		}
		
		while (true);
		
		do {
			System.out.print("Input Player 2's Name [5 - 10 Characters]: ");
			name2 = scan.nextLine();
			if (name2.length() >= 5 && name2.length() <= 10 && name2.equals(name1) != true) break;
			else System.out.println("Name length must between 5 - 10 Characters\n");
		}
		
		while (true);
		
	}
	
	// Starting Random Card for each player
	
	public static void startRandomCard() {
		
		// Random Card for player 1
		
		int card1Counter = 1;
		
		while (card1Counter <= 10) {
			int randomNum = rand.nextInt(10) + 1;
			int index = 0;
			boolean notSame = true;
			while (index < player1Cards.size()) {
				if (randomNum == player1Cards.get(index)) {
					notSame = false;
					break;
				}
				index++;
			}
			if (notSame) {
				player1Cards.add(randomNum);
				card1Counter++;
			}
		}
		
		// Random Card for player 2
		
		int card2Counter = 1;
		
		while (card2Counter <= 10) {
			int randomNum = rand.nextInt(10) + 1;
			int index = 0;
			boolean notSame = true;
			while (index < player2Cards.size()) {
				if (randomNum == player2Cards.get(index)) {
					notSame = false;
					break;
				}
				index++;
			}
			if (notSame) {
				player2Cards.add(randomNum);
				card2Counter++;
			}
		}
		
	}
	
	// Print the arena menu
	
	public static void arenaPrinting() {
		
		int player1Arena1Power = 0;
		
		for (int i : player1Arena1) {
			player1Arena1Power += i;
		}
		
		System.out.printf("%s, Power {%d}\n", name1, player1Arena1Power);
		
		if (player1Arena1.size() == 0) System.out.println("[No card placed]");
		else {
			for (int i : player1Arena1) {
				System.out.printf("[%d] ", i);
			}
			System.out.println("");
		}
		
		System.out.println("ARENA 1");
		
		int player2Arena1Power = 0;
		
		for (int i : player2Arena1) {
			player2Arena1Power += i;
		}
		
		System.out.printf("%s, Power {%d}\n", name2, player2Arena1Power);
		
		if (player2Arena1.size() == 0) System.out.println("[No card placed]");
		else {
			for (int i : player2Arena1) {
				System.out.printf("[%d] ", i);
			}
			System.out.println("");
		}
		
		System.out.println("\n---------------------------------------\n");
		
		// Arena 2
		
		int player1Arena2Power = 0;
		
		for (int i : player1Arena2) {
			player1Arena2Power += i;
		}
		
		System.out.printf("%s, Power {%d}\n", name1, player1Arena2Power);
		
		if (player1Arena2.size() == 0) System.out.println("[No card placed]");
		else {
			for (int i : player1Arena2) {
				System.out.printf("[%d] ", i);
			}
			System.out.println("");
		}
		
		System.out.println("ARENA 2");
		
		int player2Arena2Power = 0;
		
		for (int i : player2Arena2) {
			player2Arena2Power += i;
		}
		
		System.out.printf("%s, Power {%d}\n", name2, player2Arena2Power);
		
		if (player2Arena2.size() == 0) System.out.println("[No card placed]");
		else {
			for (int i : player2Arena2) {
				System.out.printf("[%d] ", i);
			}
			System.out.println("");
		}
		
		System.out.println("\n---------------------------------------\n");
		
		// Arena 3
		
		int player1Arena3Power = 0;
		
		for (int i : player1Arena3) {
			player1Arena3Power += i;
		}
		
		System.out.printf("%s, Power {%d}\n", name1, player1Arena3Power);
		
		if (player1Arena3.size() == 0) System.out.println("[No card placed]");
		else {
			for (int i : player1Arena3) {
				System.out.printf("[%d] ", i);
			}
			System.out.println("");
		}
		
		System.out.println("ARENA 3");
		
		int player2Arena3Power = 0;
		
		for (int i : player2Arena3) {
			player2Arena3Power += i;
		}
		
		System.out.printf("%s, Power {%d}\n", name2, player2Arena3Power);
		
		if (player2Arena3.size() == 0) System.out.println("[No card placed]");
		else {
			for (int i : player2Arena3) {
				System.out.printf("[%d] ", i);
			}
			System.out.println("");
		}
		
		System.out.println("\n---------------------------------------\n");
		
	}
	
	// Player turn's logic
	
	public static void playerTurnInput() {
		
		// Adding Cards
		
		if (playerTurn == 1) {
			
			int arena;
			
			do {
				
				System.out.printf("%s's turn to place card [%d]\n", name1, player1Cards.get(0));
				System.out.print("Choose Arena (1, 2, 3): ");
				arena = scan.nextInt();
				scan.nextLine();
				
				if (arena < 1 || arena > 3) {
					System.out.print("Arena must be 1, 2, or 3");
					scan.nextLine();
					continue;
				}
				
				if (arena == 1 && player1Arena1.size() < 4) {
					player1Arena1.add(player1Cards.get(0));
					player1Cards.remove(0);
					break;
				}
				
				else if (arena == 2 && player1Arena2.size() < 3) {
					player1Arena2.add(player1Cards.get(0));
					player1Cards.remove(0);
					break;
				}
				
				else if (arena == 3 && player1Arena3.size() < 3) {
					player1Arena3.add(player1Cards.get(0));
					player1Cards.remove(0);
					break;
				}
				
				else {
					System.out.printf("Arena %d is full", arena);
					scan.nextLine();
					continue;
				}
				
			}
			
			while (true);
			
			// Change the player's turn
			
			playerTurn = 2;
			
		}
		
		else if (playerTurn == 2) {
			
			int arena;
			
			do {
				
				System.out.printf("%s's turn to place card [%d]\n", name2, player2Cards.get(0));
				System.out.print("Choose Arena (1, 2, 3): ");
				arena = scan.nextInt();
				scan.nextLine();
				
				if (arena < 1 || arena > 3) {
					System.out.print("Arena must be 1, 2, or 3");
					scan.nextLine();
					continue;
				}
				
				if (arena == 1 && player2Arena1.size() < 4) {
					player2Arena1.add(player2Cards.get(0));
					player2Cards.remove(0);
					break;
				}
				
				else if (arena == 2 && player2Arena2.size() < 3) {
					player2Arena2.add(player2Cards.get(0));
					player2Cards.remove(0);
					break;
				}
				
				else if (arena == 3 && player2Arena3.size() < 3) {
					player2Arena3.add(player2Cards.get(0));
					player2Cards.remove(0);
					break;
				}
				
				else {
					System.out.printf("Arena %d is full", arena);
					scan.nextLine();
					continue;
				}
				
			}
			
			while (true);
			
			// Change the player's turn
			
			playerTurn = 1;
			
		}
		
	}
	
	// Winner checker function
	
	public static void winnerChecker() {
		
		int player1Point = 0;
		int player2Point = 0;
		
		for (int x = 1; x <= 3; x++) {
			
			int player1Power = 0;
			int player2Power = 0;
			
			if (x == 1) {
				for (int i : player1Arena1) {
					player1Power += i;
				}
				for (int i : player2Arena1) {
					player2Power += i;
				}
			}
			
			else if (x == 2) {
				for (int i : player1Arena2) {
					player1Power += i;
				}
				for (int i : player2Arena2) {
					player2Power += i;
				}
			}
			
			else if (x == 3) {
				for (int i : player1Arena3) {
					player1Power += i;
				}
				for (int i : player2Arena3) {
					player2Power += i;
				}
			}
			
			if (player1Power > player2Power) player1Point++;
			else if  (player1Power < player2Power) player2Point++;
			// There's no need condition for draw
			
		}
		
		if (player1Point > player2Point) {
			clearScreen();
			System.out.printf("%s Win!\n\n", name1);
			System.out.println("Press enter to continue...");
			scan.nextLine();
		}
		
		else if (player1Point < player2Point) {
			clearScreen();
			System.out.printf("%s Win!\n\n", name2);
			System.out.println("Press enter to continue...");
			scan.nextLine();
		}
		
		else {
			clearScreen();
			System.out.printf("Draw!\n\n");
			System.out.println("Press enter to continue...");
			scan.nextLine();
		}
		
	}
	
	// Remove all values especially for the cards in each arena for each player
	
	public static void removeAllValues() {
		
		// Remove all global variable value
		
		for (int i = 0; i < 4; i++) {
			player1Arena1.remove(0);
		}
		
		for (int i = 0; i < 3; i++) {
			player1Arena2.remove(0);
		}
		
		for (int i = 0; i < 3; i++) {
			player1Arena3.remove(0);
		}
		
		for (int i = 0; i < 4; i++) {
			player2Arena1.remove(0);
		}
		
		for (int i = 0; i < 3; i++) {
			player2Arena2.remove(0);
		}
		
		for (int i = 0; i < 3; i++) {
			player2Arena3.remove(0);
		}
		
		playerTurn = 1;
		
	}
	
	// print exit function
	
	public static void printExit() {
		clearScreen();
		System.out.println("You Exit The Game!");
	}
	
	// clear screen function (to make the console more clean)
	
	public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
