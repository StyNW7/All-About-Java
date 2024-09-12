package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import assets.Printing;
import model.Item;
import model.Normal;
import model.Potion;
import model.Shield;
import model.Player;

public class Main {
	
	Printing print = new Printing();
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	Player player = new Player(5, 5, 25, 1, 0, 0, 0, 0);
	
	ArrayList <Item> itemList = new ArrayList<>();
	
	Boolean gameEnd = false;

	public Main() {
		
		// Added item to the Global ArrayList from the item.txt
		
		addItem();
		
		int action;
		
		do {
			
			print.clearScreen();
			print.printLogo();
			System.out.println("");
			System.out.println("1. Login");
			System.out.println("2. About Us");
			System.out.println("3. Exit");
			System.out.print(">> ");
			action = scan.nextInt();
			scan.nextLine();
			
			if (action == 1) {
				
				print.clearScreen();
				loginAnimation();
				while (!gameEnd) {
					playGame();
				}
				
				// Reset Game
				resetGame();
				
			}
			
			else if (action == 2) {
				print.clearScreen();
				print.printAbout();
				scan.nextLine();
			}
			
		}
		
		while (action != 3);
		
		print.clearScreen();
		print.printExit();
		
	}
	
	public void resetGame() {
		gameEnd = false;
		player.setChestFound(0);
		player.setLevel(1);
		player.setMove(25);
		player.setMultiplier(0);
		player.setProtection(0);
		player.setPoint(0);
		player.setX(5);
		player.setY(5);
	}
	
	public void playGame() {
		
		// Level checker to read the file map based on the player's level
		
		String fileName = "";
		
		if (player.getLevel() == 1) fileName = "1.txt";
		else if (player.getLevel() == 2) fileName = "2.txt";
		else if (player.getLevel() == 3) fileName = "3.txt";
		
		// Creating the map
			
		ArrayList<String> lines = readFile(fileName);
		char[][] charMap = createCharArray(lines);
		
		// Game attributes
		
		int chestAmount = 10 + 5 * player.getLevel();
		int chestFound = 0;
		
		int xPlayer = player.getX();
		int yPlayer = player.getY();
		
		int move = 1;
		
		// Set up the player
		
		charMap[xPlayer][yPlayer] = 'P';
		
		do {
			
			// Print Map
			
			print.clearScreen();
	        for (char[] row : charMap) {
	            System.out.println(new String(row));
	        }
	        System.out.println();
	        
	        // Print Details
	        
	        System.out.println("Current Level: " + player.getLevel());
	        System.out.println("Points Gained: " + player.getPoint());
	        System.out.println("Moves Remaining: " + player.getMove() + "\n");
	        
	        if (player.getProtection() == 0) System.out.println("Protection Not Available");
	        else System.out.println("Protection Available");
	        
	        if (player.getMultiplier() == 0) System.out.println("Multiplier Not Available");
	        else System.out.println("Multiplier Available");
	        
	        // Command
	        
	        System.out.print("Input a key [w | a | s | d] (Then press enter) >> ");
			String temp = scan.nextLine();
			
			if (temp.isEmpty()) continue;
			
			char direction = Character.toUpperCase(temp.charAt(0));
			
			int prevX = xPlayer;
            int prevY = yPlayer;
            
            // Move Logic

            switch (direction) {
                case 'W':
                    if (xPlayer - move >= 0 && (charMap[xPlayer - move][yPlayer] != '#')) {
                        xPlayer -= move;
                    }
                    break;
                case 'A':
                    if (yPlayer - move >= 0 && (charMap[xPlayer][yPlayer - move] != '#')) {
                        yPlayer -= move;
                    }
                    break;
                case 'S':
                    if (xPlayer + move < charMap.length && (charMap[xPlayer + move][yPlayer] != '#')) {
                        xPlayer += move;
                    }
                    break;
                case 'D':
                    if (yPlayer + move < charMap[0].length && (charMap[xPlayer][yPlayer + move] != '#')) {
                        yPlayer += move;
                    }
                    break;
		    }
            
//            print.clearScreen();
//	        for (char[] row : charMap) {
//	            System.out.println(new String(row));
//	        }
//	        System.out.println();
            
            // Chest collision

            if (charMap[xPlayer][yPlayer] == 'C') {
            	
            	player.setMove(player.getMove()-1);
            	charMap[prevX][prevY] = ' ';
            	charMap[xPlayer][yPlayer] = 'P';
            	chestFound++;
            	
            	// Type of chest
            	
            	int chestPoint = 0;
            	int randomNum = rand.nextInt(100) + 1;
            	int itemNum = 55 - player.getLevel() * 5;
            	int enemyNum = itemNum + 35 + player.getLevel() * 5;
            	
            	int randomMove = rand.nextInt(4) + 2;
            	
            	// Logic for item
            	
            	if (randomNum <= itemNum && player.getMultiplier() == 0) {
            		
            		int randomItem = rand.nextInt(itemList.size());
            		Item getItem = itemList.get(randomItem);
            		
            		// My assumption the potion will only active if player get item
            		
            		if (player.getMultiplier() == 1) {
            			chestPoint = getItem.getItemPoint() * 2;
            			getItem.printItem(true);
            			System.out.println("Press enter to continue...");
                		scan.nextLine();
                		continue;
            		}
            		
            		chestPoint = getItem.getItemPoint();
            		
            		if (getItem instanceof Normal) {
        				getItem.printItem();
        			}
            		
        			else if (getItem instanceof Shield) {
        				getItem.printItem(player.getProtection());
        				player.setProtection(1);
        			}
            		
        			else if (getItem instanceof Potion) {
        				getItem.printItem(player.getProtection(), player.getMultiplier());
        				player.setMultiplier(1);
        			}

            		System.out.println("Press enter to continue...");
            		scan.nextLine();
            		
            	}
            	
            	else if (randomNum <= itemNum && player.getMultiplier() == 1) {
            		int randomItem = rand.nextInt(itemList.size());
            		Item getItem = itemList.get(randomItem);
            		
            		// My assumption the potion will only active if player get item
            		
            		if (player.getMultiplier() == 1) {
            			chestPoint = getItem.getItemPoint() * 2;
            			getItem.printItem(true);
            			player.setMultiplier(0);
            		}
            		
            		System.out.println("Press enter to continue...");
            		scan.nextLine();
            		
            	}
            	            	
            	// Logic for enemy
            		
            	else if (randomNum <= enemyNum && player.getProtection() == 0) {
            		int pointDecrease = rand.nextInt(6) + 4;
            		chestPoint = pointDecrease * -1;
            		System.out.println("You found enemy!");
            		System.out.println("Your point decreased by " + pointDecrease);
            		System.out.println("Press enter to continue...");
            		scan.nextLine();
            	}
            	
            	else if (randomNum <= enemyNum && player.getProtection() == 1) {
            		System.out.println("You found enemy!");
            		System.out.println("You have protection. Your point still the same!");
            		System.out.println("Press enter to continue...");
            		scan.nextLine();
            		player.setProtection(0);
            	}
            	
            	// Zonk from 90 - 100 number
            	
            	else {
            		
            		System.out.println("This chest is empty!");
            		System.out.println("Press enter to continue...");
            		scan.nextLine();
            		
            	}
            	
            	// Added the point
            	
            	if (player.getPoint() + chestPoint >= 0) player.setPoint(player.getPoint() + chestPoint);
            	player.setMove(player.getMove() + randomMove);
            	
            }
            
            // Else
            
            else if (xPlayer != prevX || yPlayer != prevY) {
            	player.setMove(player.getMove()-1);
            	charMap[xPlayer][yPlayer] = 'P';
            	charMap[prevX][prevY] = ' ';
            }
			
		}
		
		while (chestFound < chestAmount && player.getMove() > 0);
		
		// Lose Condition
		
		if (player.getMove() <= 0) {
			gameEnd = true;
			print.clearScreen();
			System.out.println("You Lose!");
			System.out.printf("You have gained %d points.\n", player.getPoint());
			System.out.print("Press enter to continue...");
			scan.nextLine();
			return;
		}
		
		// Win condition
		
		if (player.getLevel() == 3) {
			gameEnd = true;
			print.clearScreen();
			System.out.println("All chest has been cleared");
			System.out.printf("You have gained %d points.\n", player.getPoint());
			System.out.print("Press enter to continue...");
			scan.nextLine();
			return;
		}
		
		// Level up
		
		// Change all the data of the player class
		
		player.setChestFound(player.getChestFound() + chestFound);
		player.setX(5);
		player.setY(5);
		player.setLevel(player.getLevel() + 1);
		
		// Message for level up
		
		print.clearScreen();
		System.out.println("All chest has been cleared");
		System.out.printf("You have gained %d points.\n", player.getPoint());
		System.out.print("Press enter to continue...");
		scan.nextLine();
		
	}
	
	public void addItem() {
		
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
                
                if (parts.length == 2) {
                	
                	String itemName = parts[0];
                	Integer itemPrice = Integer.parseInt(parts[1].trim());
                	
                	// Item Type Validation
                	
                	// Shield
                	
                	if (itemName.startsWith("Shield")) {
                		Shield newShield = new Shield(itemName, itemPrice);
                		itemList.add(newShield);
                	}
                	
                	// Potion
                	
                	else if (itemName.endsWith("Potion")) {
                		Potion newPotion = new Potion(itemName, itemPrice);
                		itemList.add(newPotion);
                	}
                	
                	// Normal Item
                	
                	else {
                		Normal newItem = new Normal(itemName, itemPrice);
                		itemList.add(newItem);
                	}
                	
                }
                
            }
            
            fileRead.close();
            
        }
		
		catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public void printMap() {
//		print.clearScreen();
//        for (char[] row : charMap) {
//            System.out.println(new String(row));
//        }
//        System.out.println();
    }
	
	public static char[][] createCharArray(ArrayList<String> lines) {
        int numRows = lines.size();
        int maxCols = 0;
        for (String line : lines) {
            if (line.length() > maxCols) {
                maxCols = line.length();
            }
        }

        char[][] charArray = new char[numRows][maxCols];
        for (int i = 0; i < numRows; i++) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                charArray[i][j] = line.charAt(j);
            }
        }
        return charArray;
    }
	
	public static ArrayList<String> readFile(String filePath) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        return lines;
    }
	
	public void loginAnimation() {
		
		print.clearScreen();
		
		int iterate = 0;
		
		for (int i = 0; i < 101; i += 20) {
			print.clearScreen();
			System.out.print("[");
			for (int j = 0; j < iterate; j++) {
				System.out.print("=");
			}
			for (int x = i; x < 100; x += 20) {
				System.out.print("  ");
			}
			System.out.println("]");
			System.out.println("Loading... " + i + "%");
			iterate++;
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		new Main();

	}

}
