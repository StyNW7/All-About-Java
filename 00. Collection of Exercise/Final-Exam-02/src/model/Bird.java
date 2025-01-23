package model;

public class Bird extends Animal {

	public Bird(String name, Integer age, Boolean ability) {
		super(name, age, ability);
	}
	
	@Override
	public void ability() {
		if (getAbility()) System.out.printf("He can sing\n\n");
		else System.out.printf("He can't sing\n\n");
	}

	@Override
	public void printing() {
		System.out.printf("This bird is named %s\n", getName());
		System.out.printf("He's %d years old\n", getAge());
	}

	@Override
	public void sound() {
		System.out.println("Sound:");
		System.out.printf("%s chrips\n\n", getName());
	}

	@Override
	public void generalAbility() {
		System.out.println("Abilities");
		System.out.printf("%s soars gracefully\n\n", getName());
	}

}
