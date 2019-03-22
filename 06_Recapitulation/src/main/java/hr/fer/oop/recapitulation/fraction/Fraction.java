package hr.fer.oop.recapitulation.fraction;

public class Fraction {

    private int numerator; //brojnik
    private int denominator; //nazivnik
    
    private Fraction() { } 
    
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    private void simplify() {
        int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;

        //put minus before numerator
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
    }

    public Fraction add(Fraction fraction) {
    	Fraction f = new Fraction();
        f.numerator = this.numerator * fraction.denominator + fraction.numerator * this.denominator;
        f.denominator = this.denominator * fraction.denominator;
        f.simplify();
        return f;
    }
   
    public Fraction subtract(Fraction fraction) {
        Fraction negatedFraction = new Fraction(-fraction.numerator, fraction.denominator);
        return add(negatedFraction);        
    }

    public Fraction multiply(Fraction fraction) {
    	Fraction f = new Fraction();
        f.numerator = this.numerator * fraction.numerator;
        f.denominator = this.denominator * fraction.denominator;
        f.simplify();
        return f;
    }

    public Fraction divide(Fraction fraction) {       
        return multiply(fraction.invert());
    }

    public Fraction negate() {
    	return new Fraction(-numerator, denominator);
    }
    
    public Fraction invert() {
    	Fraction inverted = new Fraction(denominator, numerator);
        
    	//put minus before numerator
        if (inverted.denominator < 0) {
        	inverted.denominator = -inverted.denominator;
        	inverted.numerator = -inverted.numerator;
        }
        return inverted;
    }
    
    private static int gcd(int x, int y) {
        while(y != 0){
        	int t = y;
        	y = x % y;
        	x = t;
        }
        return x;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
