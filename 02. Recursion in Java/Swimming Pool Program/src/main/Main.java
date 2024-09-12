package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static Scanner scan = new Scanner (System.in);
	static Random rand = new Random();
	
	static String globalName;
	
	// Array of String
	
	static String [] poolMap = {
			"############             ############",
			"#...........#           #...........#",
			"#............#         #............#",
			"#.............#       #..........#..#",
			"#..............#     #..............#",
			"#....###........#   #...............#",
			"#................# #........##......#",
			"#.................#.................#",
			"#........#..........................#",
			"#........##.........................#",
			"#......................######.......#",
			"#...................................#",
			"#......####.........................#",
			"#......#............................#",
			"#.................##.......###......#",
			"#............................#......#",
			"#...##..............................#",
			"#...................................#",
			"#####################################"
	};
	
	// Convert to array of char 2d
	
	static char[][] charMap = convertToCharMap(poolMap);
	
	// Main not using public Main

	public static void main(String[] args) {
		
		// First start fill the pool
		
		editPoolMap();
		
		int action;
		
		do {
			
			clearScreen();
			printLogo();
			System.out.println("");
			System.out.println("1. Login");
			System.out.println("2. About Us");
			System.out.println("3. Exit");
			System.out.print(">> ");
			action = scan.nextInt();
			scan.nextLine();
			
			if (action == 1) {
				clearScreen();
				loginValidation();
			}
			
			else if (action == 2) {
				clearScreen();
				printAboutUs();
			}
			
		}
		
		while (action != 3);
		
		clearScreen();
		printExit();

	}
	
	public static char[][] convertToCharMap(String[] map) {
        int numRows = map.length;
        int numCols = map[0].length();
        char[][] charMap = new char[numRows][numCols];
        
        for (int i = 0; i < numRows; i++) {
            charMap[i] = map[i].toCharArray();
        }

        return charMap;
    }
	
	public static void floodFill(char[][] map, int row, int col, char target, char replacement) {

        if (row < 0 || row >= map.length || col < 0 || col >= map[0].length || map[row][col] != target) {
            return;
        }

        map[row][col] = replacement;
        printMap();

        floodFill(map, row + 1, col, target, replacement); // Down
        floodFill(map, row - 1, col, target, replacement); // Up
        floodFill(map, row, col + 1, target, replacement); // Right
        floodFill(map, row, col - 1, target, replacement); // Left
        
    }
	
	public static void printMap() {
		clearScreen();
        for (char[] row : charMap) {
            System.out.println(new String(row));
            // I can use sleep to delay it but faster without using this
//            try {
//                Thread.sleep(0,1);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
        }
        System.out.println();
    }
	
	public static void editPoolMap() {
	    try (FileWriter fileWriter = new FileWriter("pool.txt")) {
	        for (char[] row : charMap) {
	            fileWriter.write(new String(row) + "\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void swim() {
		
		clearScreen();
		
		// Checking user item
		
		int move = 1;
		
		File file = new File("userEquipment.txt");
		
		if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
		try {
			
			Scanner fileRead = new Scanner(file);
			
            while (fileRead.hasNextLine()) {
            	
                String line = fileRead.nextLine();
                String[] parts = line.split(",");
                
            	String usernameComparison = parts[0];
            	String itemExist = parts[1];
                
                if (globalName.equals(usernameComparison)) {
                	if (itemExist.equals("Swimcap")) move = 2;
                	else if (itemExist.equals("Google")) move = 3;
                	else if (itemExist.equals("Swimsuit")) move = 4;
                	break;
                }
                
            }
            
            fileRead.close();
            
        }
		
		catch (IOException e) {
            e.printStackTrace();
        }
		
		// Checking pool empty or not
		
		// Make an exit
		
		for (int i = 1; i < 3; i++) {
			for (int j = 1; j < 3; j++) {
				charMap[i][j] = 'E';
			}
		}
		
		// Make player location based on the .EXE example
		
		int xPlayer = 1;
		int yPlayer = 5;
		
		charMap[xPlayer][yPlayer] = 'P';
		
		do {
			
			clearScreen();
			
			printMap();
			
			System.out.println("Swim to (W/A/S/D): ");
			String temp = scan.nextLine();
			
			// Bug fixing
			if (temp.isEmpty()) continue;
			
			char direction = Character.toUpperCase(temp.charAt(0));
			
			
			
			int prevX = xPlayer;
            int prevY = yPlayer;
            
            // The .exe example logic can swim pass the walls
            // So I try to make like that, but the swimmer position cannot at the walls but can pass the walls
            // This logic the same as the .exe example, but I use the better version according to the guide description

//            switch (direction) {
//                case 'W':
//                    if (xPlayer - move >= 0 && (charMap[xPlayer - move][yPlayer] == '.' || charMap[xPlayer - move][yPlayer] == 'E')) {
//                        xPlayer -= move;
//                    }
//                    break;
//                case 'A':
//                    if (yPlayer - move >= 0 && (charMap[xPlayer][yPlayer - move] == '.' || charMap[xPlayer][yPlayer - move] == 'E')) {
//                        yPlayer -= move;
//                    }
//                    break;
//                case 'S':
//                    if (xPlayer + move < charMap.length && (charMap[xPlayer + move][yPlayer] == '.' || charMap[xPlayer + move][yPlayer] == 'E')) {
//                        xPlayer += move;
//                    }
//                    break;
//                case 'D':
//                    if (yPlayer + move < charMap[0].length && (charMap[xPlayer][yPlayer + move] == '.' || charMap[xPlayer][yPlayer + move] == 'E')) {
//                        yPlayer += move;
//                    }
//                    break;
//            }
            
            // Better Version than the .exe example
            
            switch (direction) {
            case 'W':
                if (xPlayer - move >= 0) {
                	Boolean noWalls = true;
                	for (int i = 1; i <= move; i++) {
                		if (charMap[xPlayer-i][yPlayer] == '#') noWalls=false;
                	}
                    if (noWalls) xPlayer -= move;
                }
                break;
            case 'A':
                if (yPlayer - move >= 0) {
                	Boolean noWalls = true;
                	for (int i = 1; i <= move; i++) {
                		if (charMap[xPlayer][yPlayer-i] == '#') noWalls=false;
                	}
                    if (noWalls) yPlayer -= move;
                }
                break;
            case 'S':
                if (xPlayer + move < charMap.length) {
                	Boolean noWalls = true;
                	for (int i = 1; i <= move; i++) {
                		if (charMap[xPlayer+i][yPlayer] == '#') noWalls=false;
                	}
                    if (noWalls) xPlayer += move;
                }
                break;
            case 'D':
                if (yPlayer + move < charMap[0].length) {
                	Boolean noWalls = true;
                	for (int i = 1; i <= move; i++) {
                		if (charMap[xPlayer][yPlayer+i] == '#') noWalls=false;
                	}
                    if (noWalls) yPlayer += move;
                }
                break;
        }
            
            if (charMap[xPlayer][yPlayer] == 'E') {
            	charMap[prevX][prevY] = '.';
                resetPool();
                break;
            }
            
            if (xPlayer != prevX || yPlayer != prevY) {
            	
            	charMap[xPlayer][yPlayer] = 'P';
                charMap[prevX][prevY] = '.';
            	
            }
            
		}
		
		while (true);
		
	}
	
	public static void resetPool() {
		for (int i = 1; i < 3; i++) {
			for (int j = 1; j < 3; j++) {
				charMap[i][j] = '.';
			}
		}
	}
	
	public static void tutorial() {
		
		clearScreen();
		
		System.out.print(" Movement Tutorial\r\n"
				+ " -----------------\r\n"
				+ "\r\n"
				+ " Swim Controls\r\n"
				+ " W -> Up\r\n"
				+ " S -> Down\r\n"
				+ " A -> Left\r\n"
				+ " D -> Right\r\n"
				+ "\r\n"
				+ " Objects\r\n"
				+ " # -> Wall\r\n"
				+ " . -> Water\r\n"
				+ " E -> Exit Pool\r\n"
				+ "\r\n"
				+ " Press enter to continue...");
		
		scan.nextLine();
		
	}
	
	public static void store() {
		
		clearScreen();
		
		int action;
		
		do {
			
			System.out.print("Equipment Store\r\n"
					+ "-------------------\r\n"
					+ "1. Swimcap\r\n"
					+ "2. Goggle\r\n"
					+ "3. Swimsuit\r\n"
					+ "4. Exit\r\n"
					+ ">> ");
			
			action = scan.nextInt();
			scan.nextLine();
			
			if (action >= 1 && action <= 4) break;
			
		}
		
		while (true);
		
		String item = "";
		
		if (action == 1) {
			item = "Swimcap";
		}
		
		else if (action == 2) {
			item = "Google";
		}
		
		else if (action == 3) {
			item = "Swimsuit";
		}
		
		else if (action == 4) return;
		
		// Check menu already bought an item or not
		
		// Username is unique
		
		File file = new File("userEquipment.txt");
		
		// Create new file
		
		Boolean alreadyBought = false;
		
		if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
		try {
			
			Scanner fileRead = new Scanner(file);
			
            while (fileRead.hasNextLine()) {
            	
                String line = fileRead.nextLine();
                String[] parts = line.split(",");
                
            	String usernameComparison = parts[0];
//            	String itemExist = parts[1];
                
                if (globalName.equals(usernameComparison)) {
                	alreadyBought = true;
                	break;
                }
                
            }
            
            fileRead.close();
            
        }
		
		catch (IOException e) {
            e.printStackTrace();
        }
		
		if (alreadyBought) {
			System.out.println("You have already bought an equipment");
			System.out.println("Press enter to continue...");
			scan.nextLine();
		}
		
		else {
			System.out.println("Purchase Success");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			
			// Insert Data for userEquipment File
			
			try (FileWriter fileWriter = new FileWriter(file, true);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) 
			{
				String data = String.format("%s,%s\n", globalName, item);
	            bufferedWriter.write(data);
//	            fileWriter.close();
//	            bufferedWriter.close();
	        }
			
			catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
	}
	
	public static void userPage() {
		
		int action;
		
		do {
			
			clearScreen();
			
			System.out.printf("Welcome, %s\n", globalName);
			System.out.println("---------------------");
			
			System.out.println("1. Swim");
			System.out.println("2. Tutorial");
			System.out.println("3. Store");
			System.out.println("4. Logout");
			System.out.print(">> ");
			
			action = scan.nextInt();
			scan.nextLine();
			
			if (action == 1) {
				
				// Pool is empty
				
				if (charMap[1][1] != '.') {
					System.out.println("Pool is empty :)");
					System.out.println("Press enter to continue...");
					scan.nextLine();
				}
				
				else swim();
			}
			
			else if (action == 2) {
				tutorial();
			}
			
			else if (action == 3) {
				store();
			}
			
		}
		
		while (action != 4);
		
		return;
		
	}
	
	public static void fillPool() {
		
		clearScreen();
		
		floodFill(charMap, 1, 1, ' ', '.');
		
		printMap();
		
		System.out.println("\n\nSwimming Pool filled successfully");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		
		editPoolMap();
		
	}
	
	public static void emptyPool() {
		
		clearScreen();
		
		floodFill(charMap, 1, 1, '.', ' ');
		
		printMap();
		
		System.out.println("\n\nSwimming Pool emptied successfully");
		System.out.println("Press enter to continue...");
		scan.nextLine();
		
		editPoolMap();
		
	}
	
	public static void registerUser() {
		
		clearScreen();
		
		String username;
		String password;
		String id = "US";
		
		Boolean notSame = true;
		
		// Username Validation
		
		do {
			
			System.out.print("Username: ");
			username = scan.nextLine();
			
			Boolean lengthValidation = false;
			
			if (username.length() >= 4) lengthValidation = true;
			
			// Unique Name
			
			if (lengthValidation) {
				
				File file = new File("credentials.txt");
				
				// Create new file
				
				if (!file.exists()) {
//					System.out.println("Created new File!!!");
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
	                    String[] parts = line.split(",");
	                    
	                    if (parts.length == 3) {
	                    	String usernameComparison = parts[1];
	                    	// case insensitive?
	                    	if (username.equals(usernameComparison)) {
	                    		notSame = false;
	                    		break;
	                    	}
	                    }
	                    
	                }
	                
	                fileRead.close();
	                
	            }
				
				catch (IOException e) {
	                e.printStackTrace();
	            }
				
				if (notSame) break;
				
				else {
					System.out.println("Username must be unique\n");
//	                System.out.print("Press Enter to continue");
//	                scan.nextLine();
				}
				
			}
			
			else {
				System.out.println("Username length must be 4 or more\n");
			}
			
		}
		
		while (true);
		
		// Password Validation
		
		do {
			
			System.out.print("Password: ");
			password = scan.nextLine();
			
			Boolean lengthValidation = false;
			
			if (password.length() >= 6) lengthValidation = true;
			
			if (lengthValidation) {
				
				Boolean upperCase = false;
				
				for (int i = 0; i < password.length(); i++) {
					if (Character.isUpperCase(password.charAt(i))) upperCase = true;
				}
				
				if (upperCase) break;
				else System.out.println("Password must at least have 1 uppercase letter\n");
				
			}
			
			else {
				System.out.println("Password length must be 6 or more\n");
			}
			
		}
		
		while (true);
		
		// Generate Random ID
		
		for (int i = 0; i < 3; i++) {
			int randNum = rand.nextInt(10);
			id += randNum;
		}
		
		// Insert Data for Credential File
		
		try (FileWriter fileWriter = new FileWriter("credentials.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) 
		{
			String data = String.format("%s,%s,%s\n", id, username, password);
            bufferedWriter.write(data);
//            fileWriter.close();
//            bufferedWriter.close();
        } 
		
		catch (IOException e) {
            e.printStackTrace();
        }
		
//		try (FileWriter writer = new FileWriter("credentials.txt")) {
//			String data = String.format("%s,%s,%s\n", id, username, password);
//			writer.write(data);
//			writer.close();
//		}
		
//		catch (IOException e) {
//            e.printStackTrace();
//        }
		
	}
	
	public static void adminPage() {
		
		int action;
		
		do {
			
			clearScreen();
			
			System.out.println("Welcome, Admin");
			System.out.println("---------------------");
			
			System.out.println("1. Fill Pool");
			System.out.println("2. Empty Pool");
			System.out.println("3. Register User");
			System.out.println("4. Logout");
			System.out.print(">> ");
			
			action = scan.nextInt();
			scan.nextLine();
			
			if (action == 1) {
				if (charMap[1][1] != ' ') {
					clearScreen();
					System.out.println("Pool is already fill!");
					System.out.println("Press enter to continue...");
					scan.nextLine();
				}
				else fillPool();
			}
			
			else if (action == 2) {
				if (charMap[1][1] != '.') {
					clearScreen();
					System.out.println("Pool is already empty!");
					System.out.println("Press enter to continue...");
					scan.nextLine();
				}
				else emptyPool();
			}
			
			else if (action == 3) {
				registerUser();
			}
			
		}
		
		while (action != 4);
		
	}
	
	public static void loginValidation() {
		
		String username;
		String password;
		
		System.out.println("Login");
		System.out.println("----------------");
		
		System.out.print("Username: ");
		username = scan.nextLine();
		
		System.out.print("Password: ");
		password = scan.nextLine();
		
		if (password.equals("Admin") && username.equals("Admin")) {
			adminPage();
			return;
		}
		
		File file = new File("credentials.txt");
		
		// Create new file
		
		if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        // Read File
		
		Boolean userValid = false;
        
        try {
			
			Scanner fileRead = new Scanner(file);
			
            while (fileRead.hasNextLine()) {
            	
                String line = fileRead.nextLine();
                String[] parts = line.split(",");
                
                if (parts.length == 3) {
                	String usernameComparison = parts[1];
                	String passwordComparison = parts[2];
                	if (username.equals(usernameComparison) && password.equals(passwordComparison)) {
                		userValid = true;
                		break;
                	}
                }
                
            }
            
            fileRead.close();
            
        }
		
		catch (IOException e) {
            e.printStackTrace();
        }
        
		if (userValid) {
			globalName = username;
			userPage();
		}
		
		else {
			System.out.println("Invalid credentials!");
			System.out.print("Press enter to continue...");
			scan.nextLine();
		}
        
	}
	
	public static void printAboutUs() {
		
		System.out.print(" Welcome to Mirthful Harbor, where every splash is a moment of joy! Our swimming pool offers a haven of laughter\r\n"
				+ " and relaxation for all ages. Dive into our crystal-clear waters and immerse yourself in a world of aquatic merriment.\r\n"
				+ "\r\n"
				+ " _\\/_                 |                _\\/\r\n"
				+ " /o\\\\             \\       /            //o\\\r\n"
				+ "  |                 .---.                |\r\n"
				+ " _|_______     --  /     \\  --     ______|__\r\n"
				+ "          `~^~^~^~^~^~^~^~^~^~^~^~`\r\n"
				+ "\r\n"
				+ "\r\n"
				+ " Press enter to continue...");
		
		scan.nextLine();
		
	}
	
	public static void printLogo() {
		System.out.println("         __  ___       ___                              ___\r\n"
				+ " |\\/| | |__)  |  |__| |__  |  | |       |__|  /\\  \\  / |__  |\\ |\r\n"
				+ " |  | | |  \\  |  |  | |    \\__/ |___    |  | /~~\\  \\/  |___ | \\|\r\n"
				+ " ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
	}
	
	public static void printExit() {
		System.out.println("                                  ......................\r\n"
				+ "                            ............:::::::::::...........\r\n"
				+ "                         .......::--==================---::.......\r\n"
				+ "                     .....:::--==+++*####%%%%%%%%####*++====--::.....\r\n"
				+ "                   ....::--==+*#%%%%%%%%%%%%%%#%%%%%%%%%%%#*+==---:.....\r\n"
				+ "                 ...::--=+*##%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#*+=---:....\r\n"
				+ "               ....:-=+*#%%%%%%%%%%%%%%%%#%%%%%%%%%%%%%%%%%%%%%%##*=---:....\r\n"
				+ "             ....:-=*#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%##%%%%%%%%%%%%%%#+=--:....\r\n"
				+ "           ....:-=*#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%####%%##%%%%%%%%%%%%#+--::...\r\n"
				+ "          ..:.:-+#%#%%%%%%%%%%%%%%%##%%%%%%%%###%#*+**%#**####%%%%%%%%%%#+--:...\r\n"
				+ "         ..:::=*%%%%%%%%%%%##%%%%%%**#%###%%#**#%*+=+=#*++**++#%%#%%%%%%%%*-:::...\r\n"
				+ "        ..:::+#%%%%%%%%%%%%########++#%***#**+++#+=---++--==-=*%%%%%%%%%%%%#=:::...\r\n"
				+ "       ..::-*#%%%%%%%%%%%%%*+**+*##==+*===*=+-=-+--:::=-:::-::*%%%%%%%%%%%%%#+:::..\r\n"
				+ "      ..:::+#%#%%%%%%%%%%%#+==+==++--=+:--=--:::-:...... ..:-=*%%%%%%%%%%%%%%#+:-:..\r\n"
				+ "      .:::+#%%%%%%%%%%%%%#*---=---=:::-.:.:.... ::--=+**#%%%%%%%%%%%%%%%%%%%%%#=:-...\r\n"
				+ "     ..:.=#%%%%%%%%%%%%%%#+::::...:   ..:-=+++*#%%###%%%%%%%%%%%%%%%%%%%%%%%%%%*-:-..\r\n"
				+ "     .:::*#%%%%%%%%%%%%%%*-...:--=+*##%%%%%%#++##%#**%%%%%%%%%###%%%#%%%%%%%%%%#+:-:..\r\n"
				+ "    ..:.=#%%%%%%%%%%%#%%%*::+***#%%%###%%%%%*==+*#+++%###%%%%%**#%%%%%%%%%%%%%%#*-:-..\r\n"
				+ "    ..:.+#%%%%%%%%%%%%%%%+-=*+=+*###**#%%%%%*-:==+===#*++%####++*%%%%%%%%%%%%%%%*-:-..\r\n"
				+ "    ..::+#%%%%%%%%%%%%%%%*--==-==**#++*####%+..::-:::+===#**++==+#%%%%%%%%%%%%%%#=:-:.\r\n"
				+ "    ...:+###############%*:.:-:--+=+==*#**#%*=--.. ..-:::+==-=:-=*###############=:::.\r\n"
				+ "    ...:+#################+..:..:--=:-=+==*#**#####*+=-:.:.:.:.:-=##############*=-::.\r\n"
				+ "    ...:=###################=-.  ..:..:-:-=+=+*###########*+=-...-*#############*--:..\r\n"
				+ "    .:.:-*######################*+=-:.....:-:-+***#############*-.+#############+:-:..\r\n"
				+ "     ::.-+*####################***#####*+=--:.=+++*****#***#****=-+############*=--:.\r\n"
				+ "     .:.:-********#************++************++===**+=+*+++*++==-:+*********#**+--:..\r\n"
				+ "      ..:-=*******%#***********+++*+++*+++++*+=---==--==-=-=----..+*********%#+---:.\r\n"
				+ "      .:.:-=*****#@@#******+++*===+===+==---+--:::--:::-:::-.:...+*********#@#=--:..\r\n"
				+ "       .:.--=+***%@@%*****+===+---=---=--:::-::...::.... . ..:-+**********#%%+=-:..\r\n"
				+ "        .:.--+*#%%@@@#****+----:::-.:.:.:...:.   ..::--==++++++++***#%****##+==:..\r\n"
				+ "         ...-=+#@@@@@%%*+*+:.::....   ...::--===+++++++++++++++*+++#@@%+#%*===:..\r\n"
				+ "          ...:==#%@@@@@*+%*  .:::--==+++++++++++++++++++++++++*@#++%@@%##+==-:..\r\n"
				+ "            ..:-=+%@@@#+%@@++++++++++++++*#+++++++++++*+++++++%@%#%%@@%+-==-..\r\n"
				+ "             ...:-=+%@@@@@@%++++++++++++*%@#++++++++++@%++++*%@@@@@@%#+==-:..\r\n"
				+ "               ..::-=+#%@@@@%+=+*@*====+#@@%*=======+%@@*+==*@@@@%%*+==-:..\r\n"
				+ "                 ..::--=+#%@%==+@@%+==+%@@@@*+++===+*%@@%+=#%@@%*+===-:..\r\n"
				+ "                   ...::--=+***#@@@*==*@@@@@@%#%+==*@@@@@##%#*+===-::..\r\n"
				+ "                     ....:-----+*#%%***%@@@@@%@@*==+%%%#*+====--::..\r\n"
				+ "                        ....::-------=++********+=====-------::..\r\n"
				+ "                             ....::---======--=====-----::...\r\n"
				+ "                                   ........::::........\r\n"
				+ "\r\n"
				+ "                  \"Inspired by passion, driven by purpose, together we\r\n"
				+ "                        shatter limits and redefine boundaries.\"");
		
		System.out.println("\nPress Enter to Continue...");
		scan.nextLine();
		
		System.out.println("Made By Stanley Nathanael Wijaya - T091");
		
	}

	public static void clearScreen() {
//	        System.out.print("\033[H\033[2J");
//	        System.out.flush();
		for (int i = 0; i < 25; i++) {
			System.out.println("");
		}
    }

}


/*

ARCHIEVED

//			int prevX = xPlayer;
//			int prevY = yPlayer;
//			
//			if (direction == 'w' || direction == 'W') {
//				if (charMap[xPlayer - move][yPlayer] == '.' || charMap[xPlayer - move][yPlayer] == 'E' && xPlayer-move > 0) {
//					xPlayer -= move;
//					charMap[xPlayer][yPlayer] = 'P';
//					charMap[prevX][prevY] = '.';
//				}
//			}
//			
//			else if (direction == 'a' || direction == 'A') {
//				if (charMap[xPlayer][yPlayer-move] == '.' || charMap[xPlayer][yPlayer-move] == 'E' && yPlayer-move > 0) {
//					yPlayer -= move;
//					charMap[xPlayer][yPlayer] = 'P';
//					charMap[prevX][prevY] = '.';
//				}	
//			}
//			
//			else if (direction == 's' || direction == 's') {
//				if (charMap[xPlayer + move][yPlayer] == '.' || charMap[xPlayer + move][yPlayer] == 'E' && xPlayer + move < 19) {
//					xPlayer += move;
//					charMap[xPlayer][yPlayer] = 'P';
//					charMap[prevX][prevY] = '.';
//				}	
//			}
//			
//			else if (direction == 'd' || direction == 'D') {
//				if (charMap[xPlayer][yPlayer+move] == '.' || charMap[xPlayer][yPlayer+move] == 'E' && yPlayer+move < 19) {
//					yPlayer += move;
//					charMap[xPlayer][yPlayer] = 'P';
//					charMap[prevX][prevY] = '.';
//				}	
//			}
//			
//			if (charMap[xPlayer][yPlayer] == 'E') {
//				resetPool();
//				break;
//			}

*/

