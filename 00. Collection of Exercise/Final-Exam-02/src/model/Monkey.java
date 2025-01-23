package model;

public class Monkey extends Animal {

	public Monkey(String name, Integer age, Boolean ability) {
		super(name, age, ability);
	}

	@Override
	public void ability() {
		if (getAbility()) System.out.printf("He is wild\n\n");
		else System.out.printf("He is NOT wild\n\n");
	}

	@Override
	public void printing() {
		System.out.printf("This monkey is named %s\n", getName());
		System.out.printf("He's %d years old\n", getAge());
	}

	@Override
	public void sound() {
		System.out.println("Sound:");
		System.out.printf("%s says: Oohh ohh ahh ahh\n\n", getName());
	}

	@Override
	public void generalAbility() {
		System.out.println("Abilities");
		System.out.printf("%s climbs trees with ease.\n\n", getName());
	}

}
