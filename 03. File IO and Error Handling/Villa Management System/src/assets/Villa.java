package assets;

public class Villa {
	
	// Global Variable
	
	private Integer bedRoom;
    private String villaType;
    private Long price;
    private String villaStatus;
    private Integer id;
	
	// Constructor

	public Villa(int bedRoom, String villaType, long price, String villaStatus, int id) {
        this.bedRoom = bedRoom;
        this.villaType = villaType;
        this.price = price;
        this.villaStatus = villaStatus;
        this.id = id;
    }
	
	// Getter and Setter

	public Integer getBedRoom() {
		return bedRoom;
	}

	public void setBedRoom(Integer bedRoom) {
		this.bedRoom = bedRoom;
	}

	public String getVillaType() {
		return villaType;
	}

	public void setVillaType(String villaType) {
		this.villaType = villaType;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getVillaStatus() {
		return villaStatus;
	}

	public void setVillaStatus(String villaStatus) {
		this.villaStatus = villaStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
