package model;

public class PhysicalServer extends Server {
	
	private Integer warranty;
	private Integer stock;

	public PhysicalServer(String serverName, Integer serverPrice, Integer warranty, Integer stock) {
		super(serverName, serverPrice);
		this.warranty = warranty;
		this.stock = stock;
	}

	public Integer getWarranty() {
		return warranty;
	}

	public void setWarranty(Integer warranty) {
		this.warranty = warranty;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
