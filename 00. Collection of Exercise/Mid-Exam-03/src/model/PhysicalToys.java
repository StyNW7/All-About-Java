package model;

public class PhysicalToys extends Toys{

	private Integer stock;

	public PhysicalToys(String toyName, Integer stock) {
		super(toyName);
		this.stock = stock;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
}
