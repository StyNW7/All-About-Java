package model;

import java.util.ArrayList;

public class Store {
	
	private String name;
    private ArrayList<Product> inventory;
    private ArrayList<Order> orders;
    
    // Constructor
    
	public Store(String name, ArrayList<Product> inventory, ArrayList<Order> orders) {
		super();
		this.name = name;
		this.inventory = new ArrayList<>();
		this.orders = new ArrayList<>();
	}
	
	// Getter and Setter

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Product> getInventory() {
		return inventory;
	}
	
	public void setInventory(ArrayList<Product> inventory) {
		this.inventory = inventory;
	}
	
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
    
	public void addProduct(Product product) {
        inventory.add(product);
    }

    public Product findProduct(String productName) {
        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public Order createOrder(Customer customer) {
        return new Order(customer);
    }

    public void printProducts() {
        System.out.println("Products available in " + name + ":\n");
        for (Product product : inventory) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
        System.out.println();
    }

}
