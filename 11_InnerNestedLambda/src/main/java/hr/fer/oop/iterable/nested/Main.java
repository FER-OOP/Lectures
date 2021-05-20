package hr.fer.oop.iterable.nested;

public class Main {
	public static void main(String[] args) {
		MyNumber number = new MyNumber(12345);
		for(Integer digit : number)
			System.out.println(digit); // prints 1 2 3 4 5 respectively
		
		System.out.println();
		
		for(Integer digit1 : number)
			for(Integer digit2 : number)
				System.out.printf("%d - %d %n", digit1 , digit2); 

	}
}
