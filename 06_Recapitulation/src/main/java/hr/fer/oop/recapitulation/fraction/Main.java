package hr.fer.oop.recapitulation.fraction;

public class Main {

    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 4);
        Fraction f2 = new Fraction(2, 3);
        
        Fraction f = f1.add(f2);
        System.out.println(f); //should print 11/12
        
        f = f1.subtract(f2);
        System.out.println(f); //should print -5/12
        
        System.out.println(f2.invert().negate()); // -3/2

        f = f1.multiply(f2);
        System.out.println(f); // 1/6

        f = f1.divide(f2);
        System.out.println(f); // 3/8  
        
        
    }
}
