package model;

public class CloudServer extends Server {
	
	private Double rentHour;

	public CloudServer(String serverName, Integer serverPrice, Double rentHour) {
		super(serverName, serverPrice);
		this.rentHour = rentHour;
	}

	public Double getRentHour() {
		return rentHour;
	}

	public void setRentHour(Double rentHour) {
		this.rentHour = rentHour;
	}
	
}
