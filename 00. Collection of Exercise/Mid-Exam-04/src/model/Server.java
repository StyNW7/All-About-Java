package model;

public class Server {
	
	private String serverName;
	private Integer serverPrice;
	
	public Server(String serverName, Integer serverPrice) {
		super();
		this.serverName = serverName;
		this.serverPrice = serverPrice;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Integer getServerPrice() {
		return serverPrice;
	}

	public void setServerPrice(Integer serverPrice) {
		this.serverPrice = serverPrice;
	}

}
