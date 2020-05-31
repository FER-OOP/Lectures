package hr.fer.oop.iterable.wrong;

public class Main {
	public static void main(String[] args) {
		MyNumber number = new MyNumber(12345);
		for(Integer digit : number)
			System.out.println(digit); // prints 1 2 3 4 5 respectively

	}
}
