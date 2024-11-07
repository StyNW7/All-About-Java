package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	
	ArrayList<Menu> menuList = new ArrayList<>();
	
	public Main() {
		
		int action;
		
		do {
			
			printingMenu();
			
			action = scan.nextInt();
			scan.nextLine();
			
			if (action == 1) addRegular();
			else if (action == 2) addSpecial();
			else if (action == 3) showMenu();
			else if (action == 4) deleteRegular();
			else if (action == 5) deleteSpecial();
			else if (action == 6) {
				System.out.println("Thank you :)");
				break;
			};
			
		}
		
		while (action != 6);
		
	}
	
	
	public void addRegular() {
		
		String menuCode;
		String menuName;
		int menuPrice;
		
		do {
			
			System.out.println("Input Menu Code [R...]:" );
			menuCode = scan.nextLine();
			if (menuCode.charAt(0) == 'R' && menuCode.length() == 4) {
				boolean flag = true;
				for (int i = 1; i <= 3; i++) {
					if (!(menuCode.charAt(i) >= '0' && menuCode.charAt(i) <= '9')){
						flag = false;
					}
				}
				if (flag && checkingCode(menuCode)) break;
			}
			
		}
		
		while (true);
		
		do {
			
			System.out.println("Input Menu Name [5-20]: " );
			menuName = scan.nextLine();
			if (menuName.length() >= 5 && menuName.length() <= 20) break;
			
		}
		
		while (true);
		
		do {
			
			try {
				
				System.out.println("Input Menu Price [10.000 - 100.000]: " );
				menuPrice = scan.nextInt();
				
				if (menuPrice >= 10000 && menuPrice <= 100000) break;
				
			} catch (NumberFormatException e) {
				System.out.println("Must be a number");
			}
			
		}
		
		while (true);
		
		menuList.add(new Regular(menuCode, menuName, menuPrice));
		System.out.println("Add Sucess");
		
	}
	
	
	public void addSpecial() {
		
		String menuCode;
		String menuName;
		int menuPrice;
		int menuDiscount;
		
		do {
			
			System.out.println("Input Menu Code [S...]:" );
			menuCode = scan.nextLine();
			if (menuCode.charAt(0) == 'S' && menuCode.length() == 4) {
				boolean flag = true;
				for (int i = 1; i <= 3; i++) {
					if (!(menuCode.charAt(i) >= '0' && menuCode.charAt(i) <= '9')){
						flag = false;
					}
				}
				if (flag && checkingCode(menuCode)) break;
			}
			
		}
		
		while (true);
		
		do {
			
			System.out.println("Input Menu Name [5-20]: " );
			menuName = scan.nextLine();
			if (menuName.length() >= 5 && menuName.length() <= 20) break;
			
		}
		
		while (true);
		
		do {
			
			try {
				
				System.out.println("Input Menu Price [10.000 - 100.000]: " );
				menuPrice = scan.nextInt();
				
				if (menuPrice >= 10000 && menuPrice <= 100000) break;
				
			} catch (NumberFormatException e) {
				System.out.println("Must be a number");
			}
			
		}
		
		while (true);
		
		do {
			
			try {
				
				System.out.println("Input Menu Discount [10 | 25 | 50]: " );
				menuDiscount = scan.nextInt();
				
				if (menuDiscount == 10 || menuDiscount == 25 || menuDiscount == 50) break;
				
			} catch (NumberFormatException e) {
				System.out.println("Must be a number");
			}
			
		}
		
		while (true);
		
		menuList.add(new Special(menuCode, menuName, menuPrice, menuDiscount));
		System.out.println("Add Sucess");
			
	}
		
	
	public void showMenu() {
		
		System.out.println("Menu List");
		System.out.println("=====================\n");
		
		System.out.println("Regular Menu");
		
		for (int i = 0; i < 58; i++) System.out.print("=");
		System.out.printf("\n| %-3s | %-7s | %-25s | %-10s |\n", "No.", "Kode", "Nama", "Harga");
		for (int i = 0; i < 58; i++) System.out.print("=");
		
		int index = 1;
		
		for (Menu menu : menuList) {
			if (menu instanceof Regular) {
				System.out.printf("\n| %-3d | %-7s | %-25s | %-10d |\n", index++, menu.getMenuCode(), menu.getMenuName(), menu.getMenuPrice());
			}
		}
		
		
		
		for (int i = 0; i < 58; i++) System.out.print("=");
		System.out.println("\n");
		
		
		
		System.out.println("Special Menu");
		
		for (int i = 0; i < 67; i++) System.out.print("=");
		System.out.printf("\n| %-3s | %-7s | %-25s | %-10s | %-5s |\n", "No.", "Kode", "Nama", "Harga", "Diskon");
		for (int i = 0; i < 67; i++) System.out.print("=");
		System.out.println();
		
		index = 1;
		
		for (Menu menu : menuList) {
			if (menu instanceof Special) {
				Special specialMenu = (Special) menu;
				System.out.printf("| %-3d | %-7s | %-25s | %-10d | %-6d |\n", index++, specialMenu.getMenuCode(), 
						specialMenu.getMenuName(), specialMenu.getMenuPrice(), specialMenu.getMenuDiscount());
			}
		}
		
		for (int i = 0; i < 67; i++) System.out.print("=");
		
		System.out.println("\n");
		
		entering();
		
	}
	
	
	public void deleteRegular() {
		
		String menuCode;
		boolean found = false;
		
		System.out.println("Delete Regular Menu");
		System.out.println("================================");
		
		do {
			
			System.out.println("Input Menu Code [R...]:" );
			menuCode = scan.nextLine();
			if (menuCode.charAt(0) == 'R' && menuCode.length() == 4) {
				boolean flag = true;
				for (int i = 1; i <= 3; i++) {
					if (!(menuCode.charAt(i) >= '0' && menuCode.charAt(i) <= '9')){
						flag = false;
					}
				}
				if (flag) break;
			}
			
		}
		
		while (true);
		
		for (Menu menu : menuList) {
			if (menu.getMenuCode().equals(menuCode)) {
				menuList.remove(menu);
				System.out.print("Delete Success\n");
				found = true;
				break;
			}
		}
		
		if (!found) System.out.println("Code is wrong!");
		
		entering();
		
	}
	
	
	public void deleteSpecial() {
		
		String menuCode;
		boolean found = false;
		
		System.out.println("Delete Special Menu");
		System.out.println("================================");
		
		do {
			
			System.out.println("Input Menu Code [s...]:" );
			menuCode = scan.nextLine();
			if (menuCode.charAt(0) == 'S' && menuCode.length() == 4) {
				boolean flag = true;
				for (int i = 1; i <= 3; i++) {
					if (!(menuCode.charAt(i) >= '0' && menuCode.charAt(i) <= '9')){
						flag = false;
					}
				}
				if (flag) break;
			}
			
		}
		
		while (true);
		
		for (Menu menu : menuList) {
			if (menu.getMenuCode().equals(menuCode)) {
				menuList.remove(menu);
				System.out.print("Delete Success\n");
				found = true;
				break;
			}
		}
		
		if (!found) System.out.println("Code is wrong!");
		
		entering();
		
	}
	
	
	public boolean checkingCode(String menuCode) {
		for (Menu menu : menuList) {
			if (menu.getMenuCode().equals(menuCode)) return false;
		}
		return true;
	}

	
	public void entering() {
		System.out.println("\nPress enter to continue...");
		scan.nextLine();
	}
	
	
	public void printingMenu() {
		
		System.out.println("Family Restaurant");
		System.out.println("============================");
		System.out.println("1. Add Regular Menu");
		System.out.println("2. Add Special Menu");
		System.out.println("3. Show All Menu");
		System.out.println("4. Delete Regular Menu");
		System.out.println("5. Delete Special Menu");
		System.out.println("6. Exit");
		System.out.print(">> ");
		
	}

	public static void main(String[] args) {
		
		new Main();

	}

}
