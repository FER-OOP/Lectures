package hr.fer.oop.recapitulation.fraction;

public class Fraction {

    private int numerator; //brojnik
    private int denominator; //nazivnik

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void add(Fraction fraction) {
        numerator = numerator * fraction.denominator + fraction.numerator * denominator;
        denominator *= fraction.denominator;
        simplify();
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

    public void subtract(Fraction fraction) {
        Fraction negatedFraction = new Fraction(fraction.numerator, fraction.denominator);
        negatedFraction.negate();
        add(negatedFraction);
    }

    public void multiply(Fraction fraction) {
        numerator *= fraction.numerator;
        denominator *= fraction.denominator;
        simplify();
    }

    public void divide(Fraction fraction) {
        Fraction invertedFraction = new Fraction(fraction.numerator, fraction.denominator);
        invertedFraction.invert();
        multiply(invertedFraction);
    }

    public void invert() {
        int oldNumerator = numerator;
        numerator = denominator;
        denominator = oldNumerator;
    }

    private void negate() {
        numerator = -numerator;
    }

    private static int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }

    @Override
    public String toString() {
        return numerator + " / " + denominator;
    }
}
