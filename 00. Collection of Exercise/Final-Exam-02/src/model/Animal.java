package model;

public abstract class Animal implements Abilityable {
	
	private String name;
	private Integer age;
	private Boolean ability;
	
	public Animal(String name, Integer age, Boolean ability) {
		super();
		this.name = name;
		this.age = age;
		this.ability = ability;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getAbility() {
		return ability;
	}

	public void setAbility(Boolean ability) {
		this.ability = ability;
	}
	
	// Abstract Method
	
	public abstract void printing();
	public abstract void sound();
	public abstract void generalAbility();

}
