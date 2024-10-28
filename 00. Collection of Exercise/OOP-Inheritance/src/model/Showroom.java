package model;

public class Showroom {
	
	private String name;
	private int capacity;
	private int speed;
	
	public Showroom(String name, int capacity, int speed) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void displayInfo() {
        System.out.println("Car Name: " + name + ", Capacity: " + capacity + ", Speed: " + speed + " km/h");
    }

}
