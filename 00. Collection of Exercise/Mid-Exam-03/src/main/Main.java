package main;

import java.util.ArrayList;

import model.OnlineToys;
import model.PhysicalToys;
import model.Toys;
import model.User;

public class Main {

	ArrayList<User> users = new ArrayList<>();
	ArrayList<Toys> toys = new ArrayList<>();
	
	public Main() {
		
		// Scenario 1 - Insert and Print 3 Users
		
		User user1 = new User("Stanley");
		User user2 = new User("Nathanael");
		User user3 = new User("Wijaya");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		for (User user : users) {
			System.out.printf("[%s] - %s\n", user.getId(), user.getName());
		}
		
		// Scenario 2 - Insert and Print 3 toys
		
		PhysicalToys physicalToy1 = new PhysicalToys("Pokeball", 5);
		PhysicalToys physicalToy2 = new PhysicalToys("Baby Shark", 1);
		OnlineToys onlineToy = new OnlineToys("Gravity Simulator", 45.9, "bit.ly/physics-simulation");
		
		toys.add(physicalToy1);
		toys.add(physicalToy2);
		toys.add(onlineToy);
		
		int counter = 1;
		
		for (Toys toyss : toys) {
			
			if(toyss instanceof PhysicalToys) {
				if(((PhysicalToys) toyss).getStock() > 0) {
					System.out.printf("[%d] - [%s] - [%d]\n", counter, toyss.getToyName(), ((PhysicalToys) toyss).getStock());
				}
			}
			
			else if(toyss instanceof OnlineToys) {
				System.out.printf("[%d] - [%s] - [%.2f] - [%s]\n", counter, toyss.getToyName(), ((OnlineToys) toyss).getFileSize(), ((OnlineToys) toyss).getLink());				
			}
			
			counter++;
			
		}
		
		System.out.println("");
		
		// Scenario 3 - Customer can rent toys but there is a validation needed
		
		user1.addToys(physicalToy2);
		user1.addToys(physicalToy2);
		user1.addToys(onlineToy);
		user1.addToys(onlineToy);
		user3.addToys(onlineToy);
		
		user2.addToys(physicalToy1);
		user2.addToys(physicalToy1);
		user2.addToys(physicalToy1);
		
		user1.removeToys(physicalToy2);
		user2.removeToys(physicalToy1);
		
		// Scenario 4 - Print all members and toys owned by each members
		
		counter = 1;
		
		for (User user : users) {
			
			System.out.printf("[%d] - [%s] - [%s] :\n", counter, user.getId(), user.getName());
			
			for (Toys toys2 : user.getToyList()) {
				if(toys2 instanceof PhysicalToys) {
					if(((PhysicalToys) toys2).getStock() > 0) {						
						System.out.printf("(PT) - %s - %d\n", toys2.getToyName(), ((PhysicalToys) toys2).getStock());
					}
				}
				else if(toys2 instanceof OnlineToys) {
					System.out.printf("(OT) - %s - %.2f - %s\n", toys2.getToyName(), ((OnlineToys) toys2).getFileSize(), ((OnlineToys) toys2).getLink());
				}
			}
			
			counter++;
			
		}
		
	}

	public static void main(String[] args) {
		new Main();
	}

}
