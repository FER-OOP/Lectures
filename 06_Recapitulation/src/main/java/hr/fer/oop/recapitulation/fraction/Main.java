package hr.fer.oop.recapitulation.fraction;

public class Main {

    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 4);
        Fraction f2 = new Fraction(2, 3);
        
        f1.add(f2);
        System.out.println(f1);
        
        f1 = new Fraction(1, 4);
        f1.subtract(f2);
        System.out.println(f1);
        

        f1 = new Fraction(1, 4);
        f1.multiply(f2);
        System.out.println(f1);

        f1 = new Fraction(1, 4);
        f1.divide(f2);
        System.out.println(f1);        
    }
}
