import java.util.ArrayList;

public class Program {
	public static void main(String[] args) {
		Dog dunkin = new Dog();

		ArrayList<Mammal> animals = new ArrayList<Mammal>();
		animals.add(dunkin);
		Gorilla koko = new Gorilla();
		animals.add(koko);
		Barrel b1 = new Barrel();
		dunkin.attack(koko);
		dunkin.attack(b1);
		
		for(Mammal m:animals) {
			m.makeSound();
		}
	}
}
