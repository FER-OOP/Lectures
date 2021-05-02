package hr.fer.oop.homework_09.t08;

public class Main {

	public static void main(String[] args) {
		Polynomial a = new Polynomial(-2, 4, 2, 2, 3, 1, 5, 0);
		System.out.println(a); // -2x^4+2x^2+3x+5
		
		Polynomial b = new Polynomial(-2, 1, -3, 6, 1, 3, -2, 2);
		System.out.println(b); // -3x^6+x^3-2x^2-2x
		
		Polynomial c = a.plus(b);
		System.out.println(c); // -3x^6-2x^4+x^3+x+5
	}

}
