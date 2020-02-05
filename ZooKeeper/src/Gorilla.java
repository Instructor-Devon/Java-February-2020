
public class Gorilla extends Mammal implements Attackable {
	public Gorilla() {
		// directly calling Mammal constructor
		super("gorilla", 500);
	}
	public void makeSound() {
		System.out.println("*grunt* *grunt*");
	}
	public void climbTree() {
		System.out.printf("I am a %s climbing a tree!\n", this.species);
	}
	public void takeDamage(int damageAmount) {
		this.health -= (damageAmount/2);
	}
}