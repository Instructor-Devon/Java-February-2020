package PythagoreanTheorem;
public class Triangle {
    private int sideA;
    private int sideB;
    public Triangle(int a, int b){
        sideA = a;
        sideB = b;
    }
    public double getHypotenuse() {
        return Pythagorean.calculateHypotenuse(sideA, sideB);
    }
    public void printDetails() {
        System.out.printf("Side A: %d\n", sideA);
        System.out.printf("Side B: %d\n", sideB);
        System.out.printf("Side C: %.2f\n", getHypotenuse());
    }
}