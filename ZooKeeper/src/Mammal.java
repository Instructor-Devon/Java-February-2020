
public abstract class Mammal{
	protected String species;
	protected int health;
	
	public abstract void makeSound();
	
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}

	public Mammal(String species, int health) {
		this.species = species;
		this.health = health;
	}
	
	
	public void attack(Attackable target) {
		// decrement health
		int currentHealth = target.getHealth();
		currentHealth -= 5;
		target.setHealth(currentHealth);
	}
	
}
