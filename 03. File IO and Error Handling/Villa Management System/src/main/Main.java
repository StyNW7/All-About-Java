package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import assets.Printing;
import assets.Villa;
import assets.Booking;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	
	static Printing print = new Printing();
	
	static int idCounter = 1;
	
	static ArrayList<Villa> villa = new ArrayList<>();
	static ArrayList<Booking> booking = new ArrayList<>();

	public Main() {

		int action;
		
		do {
			
			print.clearScreen();
			print.printLogo();
			
			System.out.println("1. Login");
			System.out.println("2. Exit");
			System.out.print(">> ");
			action  = scan.nextInt();
			scan.nextLine();
			
			if (action == 1) {
				loginValidation();
			}
			
			else if (action == 2) {
				print.clearScreen();
				print.printExit();
			}
			
			else {
				System.out.println("Input must be between 1 - 2");
				System.out.println("Press enter to continue...");
				scan.nextLine();
			}
			
		}
		
		while (action != 2);
		
	}
	
	public static String generateID () {
		
		String id = "BI";
		
		for (int i = 0; i < 3; i++) {
			int randomNum = rand.nextInt(10);
			id += randomNum;
		}
		
		return id;
		
	}
	
	public static void bookingVilla() {
		
		print.clearScreen();
		
		Boolean thereIsVilla = false;
		
		for (Villa villaCounter : villa) {
			if (villaCounter.getVillaStatus() == "Available") {
				thereIsVilla = true;
				break;
			}
		}
		
		if (!thereIsVilla) {
			 System.out.println("There's no villa available!");
			 System.out.print("Press enter to exit");
			 scan.nextLine();
			 return;
		}
		
		for (int i = 0; i < 77; i++) System.out.print("=");
		System.out.printf("\n| %-3s | %-18s | %-15s | %-15s | %-10s |\n", "ID", "Type", "Total Bedroom", "Status", "Price");
		for (int i = 0; i < 77; i++) System.out.print("=");
		System.out.println("");
		
		if (villa.size() == 0) System.out.printf("| %-73s |\n", "The data is empty!");
		
		else {
			for (Villa villaCounter : villa) {
				if (villaCounter.getVillaStatus().equals("Available")) System.out.printf("| %-3d | %-18s | %-15d | %-15s | %-10d |\n", villaCounter.getId(), villaCounter.getVillaType(),villaCounter.getBedRoom(), villaCounter.getVillaStatus(), villaCounter.getPrice());
			}
		}
			
		for (int i = 0; i < 77; i++) System.out.print("=");
		System.out.println("\n");
		
		System.out.print("Input the villa ID [0 for exit]: ");
		
		int id = scan.nextInt();
		scan.nextLine();
		
		if (id == 0) return;
		
		Boolean found = false;
		
		for (Villa villaCounter : villa) {
			
			if (villaCounter.getId() == id && villaCounter.getVillaStatus().equals("Available")) {
				
				found = true;
				
				String guestName;
				int guest;
				int day;
				
				do {
					System.out.print("Input the name of the person who reserved the villa [3 - 10 characters]: ");
					guestName = scan.nextLine();
					if (guestName.length() >= 3 && guestName.length() <= 10) break;
					else System.out.println("Input characters must be 3 - 10 character");
				}
				
				while (true);
				
				do {
					System.out.print("Input the total guest [> 0]: ");
					guest = scan.nextInt();
					scan.nextLine();
					if (guest > 0) break;
					else System.out.println("Guest must be > 0!");
				}
				
				while (true);
				
				do {
					System.out.print("Input the total day [> 0]: ");
					day = scan.nextInt();
					scan.nextLine();
					if (day > 0) break;
					else System.out.println("Day must be > 0!");
				}
				
				while (true);
				
				do {
					
					System.out.print("Are you sure want to booking villa [Y | N]: ");
					String validation = scan.nextLine();
					char firstChar = validation.charAt(0);
					
					if (firstChar == 'Y') {
						
						// Discount
						
						int disc = rand.nextInt(4);
						long totalPrice = day * villaCounter.getPrice();
						
						if (disc == 0) {
							
							long discount = villaCounter.getPrice() * 20 / 100;
							long newPrice = villaCounter.getPrice() - (discount);
							totalPrice = newPrice * day;
							
						}
						
						// Generate Bill ID
						
						String billID = generateID();
						
						// Add to Array List using OOP Encapsulation from Booking Class
						
						Booking newBook = new Booking(villaCounter.getId(), billID, totalPrice, guestName, guest, day);
				        booking.add(newBook);
				        
				        villaCounter.setVillaStatus("Not Available");
						
						System.out.print("Press enter to exit...");
				        scan.nextLine();
				        break;
				        
					}
					
					else if (firstChar == 'N'){
				        System.out.print("Press enter to exit...");
				        scan.nextLine();
				        break;
					}
					
					else System.out.println("The input must be either 'Y' or 'N' (case sensitive)!");
					
				}
				
				while (true);
				
			}
			
		}
		
		if (!found) {
			System.out.println("ID not exist!");
			scan.nextLine();
			bookingVilla();
		}
		
	}
	
	public static void userMenu() {
		
		int action;
		
		do {
			
			print.clearScreen();
			
			System.out.println("1. Booking Villa");
			System.out.println("2. Exit");
			System.out.print(">> ");
			action  = scan.nextInt();
			scan.nextLine();
			
			if (action == 1) {
				bookingVilla();
			}
			
			else if (action  == 2) break;
			
			else {
				System.out.println("Input must be between 1 - 2");
				System.out.println("Press enter to continue...");
				scan.nextLine();
			}
			
		}
		
		while (true);
		
	}
	
	public static void viewTransaction() {
		
		print.clearScreen();
		
		for (int i = 0; i < 99; i++) System.out.print("=");
		System.out.printf("\n| %-10s | %-18s | %-15s | %-15s | %-10s | %-12s |\n", "Bill ID", "Villa Number", "Reserved By", "Total Guest", "Total Day", "Total Price");
		for (int i = 0; i < 99; i++) System.out.print("=");
		System.out.println("");
		
		if (booking.size() == 0) System.out.printf("| %-95s |\n", "The data is empty!");
		
		else {
			for (Booking bookingCounter : booking) {
				System.out.printf("| %-10s | %-18d | %-15s | %-15d | %-10d | %-12d |\n", bookingCounter.getBillID(), bookingCounter.getVillaNumber(), bookingCounter.getName(), bookingCounter.getGuest(), bookingCounter.getDay(), bookingCounter.getPrice());
			}
		}
			
		for (int i = 0; i < 99; i++) System.out.print("=");
		System.out.println("\n");
		
		System.out.println("\nPress enter to exit");
		scan.nextLine();
		
	}
	
	public static void printVilla() {
		
		print.clearScreen();
		
		for (int i = 0; i < 77; i++) System.out.print("=");
		System.out.printf("\n| %-3s | %-18s | %-15s | %-15s | %-10s |\n", "ID", "Type", "Total Bedroom", "Status", "Price");
		for (int i = 0; i < 77; i++) System.out.print("=");
		System.out.println("");
		
		if (villa.size() == 0) System.out.printf("| %-73s |\n", "The data is empty!");
		
		else {
			for (Villa villaCounter : villa) {
				System.out.printf("| %-3d | %-18s | %-15d | %-15s | %-10d |\n", villaCounter.getId(), villaCounter.getVillaType(),villaCounter.getBedRoom(), villaCounter.getVillaStatus(), villaCounter.getPrice());
			}
		}
			
		for (int i = 0; i < 77; i++) System.out.print("=");
		System.out.println("\n");
		
	}
	
	public static void viewVilla() {
		
		printVilla();
		
		System.out.println("Press enter to exit");
		scan.nextLine();
			
	}
	
	public static void addVilla() {
		
		print.clearScreen();
		
		int bedRoom;
		String villaType;
		long price;
		
		do {
			System.out.print("Input the total of the bedroom [1 - 3]: ");
			bedRoom = scan.nextInt();
			scan.nextLine();
			if (bedRoom >= 1 && bedRoom <= 3) break;
			else System.out.println("Input must be between 1 - 3!");
		}
		
		while (true);
		
		do {
			System.out.print("Input the type of the villa [River Room | Garden Room]: ");
			villaType = scan.nextLine();
			if (villaType.equals("River Room") || villaType.equals("Garden Room")) break;
			else System.out.println("The type must be either [River Room | Garden Room]!");
		}
		
		while (true);
		
		do {
			System.out.print("Input the price [> 0]: ");
			price = scan.nextInt();
			scan.nextLine();
			if (price > 0) break;
			else System.out.println("The price must be more than 0!");
		}
		
		while (true);
		
		String villaStatus = "Available";
		
		// Add to Array List using OOP Encapsulation from Villa Class
		
		Villa newVilla = new Villa(bedRoom, villaType, price, villaStatus, idCounter);
        villa.add(newVilla);
        
        idCounter++;
        
        System.out.println("Villa Added Successfully");
        System.out.println("Press enter to continue...");
        scan.nextLine();
		
	}
	
	public static void editVilla() {
		
		printVilla();
		
		System.out.print("\nInput the villa id [0 for exit]: ");
		int id = scan.nextInt();
		scan.nextLine();
		
		if (id == 0) return;
		
		Boolean found = false;
		
		for (Villa villaCounter : villa) {
			if (villaCounter.getId() == id && villaCounter.getVillaStatus().equals("Available")) {
				
				int bedRoom;
				String villaType;
				long price;
				
				do {
					System.out.print("Input the total of the bedroom [1 - 3]: ");
					bedRoom = scan.nextInt();
					scan.nextLine();
					if (bedRoom >= 1 && bedRoom <= 3) break;
					else System.out.println("Input must be between 1 - 3!");
				}
				
				while (true);
				
				do {
					System.out.print("Input the type of the villa [River Room | Garden Room]: ");
					villaType = scan.nextLine();
					if (villaType.equals("River Room") || villaType.equals("Garden Room")) break;
					else System.out.println("The type must be either [River Room | Garden Room]!");
				}
				
				while (true);
				
				do {
					System.out.print("Input the price [> 0]: ");
					price = scan.nextInt();
					if (price > 0) break;
					else System.out.println("The price must be more than 0!");
				}
				
				while (true);
				
				villaCounter.setBedRoom(bedRoom);
				villaCounter.setVillaType(villaType);
				villaCounter.setPrice(price);
				
				System.out.println("Villa Edited Successfully");
		        System.out.println("Press enter to continue...");
		        scan.nextLine();
				
				found = true;
				return;
				
			}
		}
		
		if (!found) {
			System.out.println("ID not exist!");
	        scan.nextLine();
			editVilla();
		}
		
	}
	
	public static void deleteVilla() {
		
		printVilla();
		
		System.out.print("\nInput the villa id [0 for exit]: ");
		int id = scan.nextInt();
		scan.nextLine();
		
		if (id == 0) return;
		
		Boolean found = false;
		
		for (Villa villaCounter : villa) {
			if (villaCounter.getId() == id && villaCounter.getVillaStatus().equals("Available")) {
				
				villa.remove(villaCounter);
				
				System.out.println("Villa Deleted Successfully");
		        System.out.println("Press enter to continue...");
		        scan.nextLine();
				
				found = true;
				return;
				
			}
		}
		
		if (!found) {
			System.out.println("ID not exist!");
	        scan.nextLine();
			editVilla();
		}
		
	}
	
	public static void adminMenu() {
		
		int action;
		
		do {
			
			print.clearScreen();
			
			System.out.println("1. View Transaction");
			System.out.println("2. View Villa");
			System.out.println("3. Add New Villa");
			System.out.println("4. Edit Villa");
			System.out.println("5. Delete Villa");
			System.out.println("6. Exit");
			System.out.print(">> ");
			action  = scan.nextInt();
			scan.nextLine();
			
			if (action == 1) {
				viewTransaction();
			}
			
			else if (action == 2) {
				viewVilla();
			}
			
			else if (action == 3) {
				addVilla();
			}
			
			else if (action == 4) {
				editVilla();
			}
			
			else if (action == 5) {
				deleteVilla();
			}
			
			else if (action  == 6) break;
			
			else {
				System.out.println("Input must be between 1 - 6");
				System.out.println("Press enter to continue...");
				scan.nextLine();
			}
			
		}
		
		while (true);
		
	}
	
	public static void loginValidation() {
		
		print.clearScreen();
		
		String username;
		String password;
		
		// No validation needed just checking the credential
		
		System.out.print("Username: ");
		username = scan.nextLine();
		System.out.print("Password: ");
		password = scan.nextLine();
		
		if (username.equals("User") && password.equals("User")) {
			userMenu();
		}
		
		else if (username.equals("Admin") && password.equals("Admin")) {
			adminMenu();
		}
		
		else {
			System.out.println("Wrong credentials");
			System.out.println("Press enter to exit...");
			scan.nextLine();
		}
		
	}

	public static void main(String[] args) {

		new Main();

	}

}
