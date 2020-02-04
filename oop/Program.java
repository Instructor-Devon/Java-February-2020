public class Program {
    public static void main(String[] args) {
        Animal dog = new Animal("dog", 'f');
        Animal cat = new Animal("cat", 'm');
        
        cat.attack(dog).attack(dog);
    }
}