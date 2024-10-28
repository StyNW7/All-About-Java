package main;

import java.util.ArrayList;

import model.Customer;
import model.Order;
import model.Product;
import model.Store;

public class Main {

	
	public Main() {
		
		// Static Testing
		
		Store store = new Store("MyStore", null, null);

        // Adding products to the store (Composition)
		
        store.addProduct(new Product("Laptop", 199));
        store.addProduct(new Product("Mouse", 59));
        store.addProduct(new Product("Keyboard", 79));

        // Print available products
        
        store.printProducts();

        // Creating a customer (Association)
        
        Customer customer = new Customer("Stanley");

        // Creating an order (Aggregation)
        
        Order order = store.createOrder(customer);

        // Adding products to the order
        
        Product apple = store.findProduct("Laptop");
        Product milk = store.findProduct("Mouse");

        if (apple != null) {
            order.addProduct(apple);
        }
        if (milk != null) {
            order.addProduct(milk);
        }

        // Display order details
        
        System.out.println("Orders:");
        
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Total cost: $" + order.calculateTotal());
        
        ArrayList<Product> myProduct = order.getProducts();
        
        System.out.println("Products:");
        for (Product product : myProduct) {
			System.out.println("- " + product.getName());
		}
		
	}
	
	
	public static void main(String[] args) {
		new Main();
	}

}
