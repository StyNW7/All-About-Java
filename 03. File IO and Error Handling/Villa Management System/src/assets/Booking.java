package assets;

public class Booking {
	
	// Global Variable
	
	private Integer villaNumber;
    private String billID;
    private Long price;
    private String name;
    private Integer guest;
    private Integer day;
	
	// Constructor

	public Booking(Integer villaNumber, String billID, Long price, String name, Integer guest, Integer day) {
		this.villaNumber = villaNumber;
		this.billID = billID;
		this.price = price;
		this.name = name;
		this.guest = guest;
		this.day = day;
	}

	public Integer getVillaNumber() {
		return villaNumber;
	}

	public void setVillaNumber(Integer villaNumber) {
		this.villaNumber = villaNumber;
	}

	public String getBillID() {
		return billID;
	}

	public void setBillID(String billID) {
		this.billID = billID;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGuest() {
		return guest;
	}

	public void setGuest(Integer guest) {
		this.guest = guest;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}
	
}
