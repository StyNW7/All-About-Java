package model;

import java.util.ArrayList;
import java.util.Random;

public class User {
	
	private String id;
	private String name;
	private ArrayList<Server> serverList;
	private Random rand = new Random();
	
	public User(String name) {
		super();
		this.id = String.format("ID%03d", rand.nextInt(999)+1);
		this.name = name;
		this.serverList = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Server> getServerList() {
		return serverList;
	}

	public void setServerList(ArrayList<Server> serverList) {
		this.serverList = serverList;
	}

	public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}
	
	
	public void addServer(Server server) {
		
		if (serverList.size() >= 2) {
			System.out.println("You cannot add more server!");
		}
		
		else {
			
			if (server instanceof PhysicalServer) {
				if (((PhysicalServer) server).getStock() > 0) {
					serverList.add(server);
					((PhysicalServer) server).setStock(((PhysicalServer) server).getStock()-1);
				}
				else System.out.println("No more stock :(");
			}
			
			else {
				serverList.add(server);
			}
			
		}
		
	}
	
	public long calculateCost() {
		
		long totalCost = 0;
		
		for (Server server : serverList) {
			if (server instanceof PhysicalServer) totalCost += server.getServerPrice();
			else totalCost += ((CloudServer) server).getRentHour() * server.getServerPrice();
		}
		
		return totalCost;
		
	}
	
	public void removeServer(Server server) {
		
		if (server instanceof PhysicalServer && ((PhysicalServer) server).getWarranty() >= 1) {
			serverList.remove(server);
			((PhysicalServer) server).setStock(((PhysicalServer) server).getStock()+1);
		}
		
		else if (server instanceof CloudServer) {
			System.out.println("You cannot stop the cloud server!");
		}
		
		else {
			System.out.println("There is no warranty for this server!");
		}
		
	}

}
