package model;

public class Duck extends Animal {

	public Duck(String name, Integer age, Boolean ability) {
		super(name, age, ability);
	}
	
	@Override
	public void ability() {
		if (getAbility()) System.out.printf("He can quack loudly\n\n");
		else System.out.printf("He can't quack loudly\n\n");
	}

	@Override
	public void printing() {
		System.out.printf("This duck is named %s\n", getName());
		System.out.printf("He's %d years old\n", getAge());
	}

	@Override
	public void sound() {
		System.out.println("Sound:");
		System.out.printf("The duck says: Quack!\n\n");
	}

	@Override
	public void generalAbility() {
		System.out.println("Abilities");
		System.out.printf("%s Ability Duck :(.\n\n", getName());
	}

}
