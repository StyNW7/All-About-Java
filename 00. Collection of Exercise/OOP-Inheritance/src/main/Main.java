package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.Jeep;
import model.SUV;
import model.Sedan;
import model.Showroom;

public class Main {
	
	Scanner scan = new Scanner(System.in);

	ArrayList <Showroom> myCars = new ArrayList<>();
	
	public Main() {
		
		int action;
		
		do {
			
			System.out.println("My Showroom Menu:\n");
			System.out.println("1. Buy Car");
			System.out.println("2. Show Cars");
			System.out.println("3. Exit");
			System.out.print(">> ");
			
			action = scan.nextInt();
			scan.nextLine();
			
			if (action == 1) buyCar();
			else if (action == 2) showCars();
			else if (action == 3) break;
			else System.out.println("\nInvalid Input\n");
			
		}
		
		while (true);
		
	}
	
	
	public void buyCar() {
		
		int action;
		String carName;
		
		do {
			
			System.out.println("Choose car type:");
			System.out.println("1. Jeep");
			System.out.println("2. SUV");
			System.out.println("3. Sedan");
			System.out.print(">> ");
			
			action = scan.nextInt();
			scan.nextLine();
			
			System.out.print("Enter car name: ");
			carName = scan.nextLine();
			
			if (action == 1) {
				myCars.add(new Jeep(carName, 30, 120));
				System.out.println("Jeep added to the showroom\n");
			}
			else if (action == 2) {
				myCars.add(new SUV(carName, 15, 100));
				System.out.println("SUV added to the showroom\n");
			}
			else if (action == 3) {
				myCars.add(new Sedan(carName, 10, 120));
				System.out.println("Sedan added to the showroom\n");
			}
			else System.out.println("\nInvalid Input\n");
			
			if (action == 1 || action == 2 || action == 3) break;
			
		}
		
		while (true);
		
	}
	
	
	public void showCars() {
		
		System.out.println("\n\nCars in the showroom:\n");
		for (Showroom showroom : myCars) {
			showroom.displayInfo();
		}
		
	}
	
	
	public static void main(String[] args) {
		new Main();
	}

}
