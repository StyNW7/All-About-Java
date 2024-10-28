package model;

import java.util.ArrayList;

public class Order {
	
	private ArrayList<Product> products;
    private Customer customer;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public Customer getCustomer() {
        return customer;
    }
    
    public ArrayList<Product> getProducts() {
        return products;
    }

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
