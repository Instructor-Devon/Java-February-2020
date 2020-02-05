// Things Animals have
public class Animal {
    // private: only access from WITHIN the class
    private String species;
    private boolean isFurry;
    private int strength; // (1 - 100)
    private int health; // (100)
    private char gender; //(f/m)

    // Contructor
    public Animal(String species, boolean isFurry, int strength, char gender) {
        this.species = species;
        this.isFurry = isFurry;
        this.strength = strength;
        this.gender = gender;
        this.health = 100;
    }
    public Animal(String species, char gender) {
        this.species = species;
        this.gender = gender;
        this.isFurry = true;
        this.strength = 40;
        this.health = 100;
    }
    public boolean getIsFurry() {
        return this.isFurry;
    }
    public void setIsFurry(boolean isFurry) {
        this.isFurry = isFurry;
    }
    public char getGender() {
        return this.gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public int getHealth() {
        return this.health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getStrength() {
        return this.strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    // getters
    public String getSpecies() {
        return this.species;
    }

    // setters
    public void setSpecies(String newSpecies) {
        if(newSpecies.equals("")) {
            return;
        }
        this.species = newSpecies;
    }

    // attacks another animal, user defines damage amount
    public Animal attack(Animal target, int damage) {
        // define logic of how animal attacks/is attacked
        // multiply strength x damage
        int effectiveDmg = damage * this.strength;
        System.out.printf("%s attacks %s for %d points\n", this.species, target.species, effectiveDmg);

        // reduce target.health by effectiveDmg
        target.health -= effectiveDmg;

        return this;
    }
    // attacks another animal, default damage amount
    public Animal attack(Animal target) {
        this.attack(target, 2);
        return this;
    }


}
// Things Animals do
    // makeSound()
    // eat()
    // attack()
    // move()
    // sleep()