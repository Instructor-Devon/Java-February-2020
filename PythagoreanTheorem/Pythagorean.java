package PythagoreanTheorem;

public class Pythagorean {
    public static void test() {
        System.out.println("I am inside of Pythagorean!");
    }

    public static double calculateHypotenuse(int legA, int legB) {
        // the hypotenuse is the side across the right angle. 
        // calculate the value of c given legA and legB

        // A2 + B2 = C2
        double c = Math.pow(legA, 2) + Math.pow(legB, 2);

        // return sq root of c!
        double cRoot = Math.sqrt(c);

        return cRoot;
    }
}