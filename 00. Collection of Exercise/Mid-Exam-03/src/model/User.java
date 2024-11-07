package model;

import java.util.ArrayList;
import java.util.Random;

public class User {

	private String id;
	private String name;
	private ArrayList<Toys> toyList;
	private Random rand = new Random();
	
	public User(String name) {
		super();
		this.id = String.format("US%03d", rand.nextInt(999)+1);
		this.name = name;
		this.toyList = new ArrayList<>();
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
	
	public ArrayList<Toys> getToyList() {
		return toyList;
	}

	public void setToyList(ArrayList<Toys> toyList) {
		this.toyList = toyList;
	}

	public void addToys(Toys toys) {
		
		if(toyList.size() >= 2) {
			System.out.println("You already rent 2x");
		}
		
		else {
			
			if(toys instanceof PhysicalToys) {
				if (((PhysicalToys) toys).getStock() <= 0) {
					System.out.println("No more stock!");
				}
				else {
					toyList.add(toys);
					((PhysicalToys) toys).setStock(((PhysicalToys) toys).getStock() - 1);
				}	
			} 
			
			else if(toys instanceof OnlineToys) {
				toyList.add(toys);
			}
			
		}
		
	}
	
	public void removeToys(Toys toys) {
		
		toyList.remove(toys);
		
		if(toys instanceof PhysicalToys) {
			((PhysicalToys) toys).setStock(((PhysicalToys) toys).getStock() + 1);
		}
		
	}
	
}
