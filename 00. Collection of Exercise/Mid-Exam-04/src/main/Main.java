package main;

import java.util.ArrayList;

import model.CloudServer;
import model.PhysicalServer;
import model.Server;
import model.User;

public class Main {
	
	
	ArrayList<User> userList = new ArrayList<>();
	ArrayList<Server> serverList = new ArrayList<>();
	

	public Main() {
		
		// Scenario 1 - Add Users
		
		User user1 = new User("Stanley");
		User user2 = new User("Nathanael");
		User user3 = new User("Wijaya");
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		int index = 1;
		
		System.out.println("User List");
		System.out.println("===================");
		
		for (User user : userList) {
			System.out.printf("Customer %d:\n", index++);
			System.out.printf("Name: %s\n", user.getName());
			System.out.printf("ID: %s\n\n", user.getId());
		}
		
		
		// Scenario 2 - Add Servers
		
		
		PhysicalServer server1 = new PhysicalServer("Server 1", 10000000, 3, 2);
		PhysicalServer server2 = new PhysicalServer("Server 2", 100000, 0, 1);
		CloudServer server3 = new CloudServer("AWS EC2", 10000, 5000.5);
		
		serverList.add(server1);
		serverList.add(server2);
		serverList.add(server3);
		
		
		System.out.println("Server List");
		System.out.println("===================");
		
		index = 1;
		int index2 = 1;
		
		for (Server server : serverList) {
			if (server instanceof PhysicalServer) {
				System.out.printf("Physical Server %-3d: %-10s, %-10d, %d, %d\n", index++, server.getServerName(), server.getServerPrice(),
						((PhysicalServer) server).getWarranty(), ((PhysicalServer) server).getStock());
			}
			else {
				System.out.printf("Cloud Server %-6d: %-10s, %-10d, %.2f\n", index2++, server.getServerName(), server.getServerPrice(),
						((CloudServer) server).getRentHour());
			}
		}
		
		
		
		// Scenario 3 - Add Server and Remove Server
		
		System.out.println();
		
		user1.addServer(server3);
		user1.addServer(server1);
		
		user2.addServer(server2);
		
		user3.addServer(server3);
		
		
		user3.addServer(server2);
		user1.addServer(server1);
		
		user2.removeServer(server2);
		user1.removeServer(server1);
		user1.removeServer(server3);
		
		
		// Scenario 4 - Calculate Cost
		
		System.out.println();
		
		for (User user : userList) {
			System.out.printf("%s: %d\n", user.getName(), user.calculateCost());
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		new Main();
	}

}
