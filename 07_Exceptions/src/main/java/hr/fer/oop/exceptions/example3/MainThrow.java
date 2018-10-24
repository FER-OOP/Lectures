package hr.fer.oop.exceptions.example3;

public class MainThrow {

	public static void main(String[] args) {
		try{
			System.out.println(perimiter(5, 4, 3));
			System.out.println(perimiter(4, 3, 2));
			System.out.println(perimiter(3, 2, 1));
		}
		catch(Exception exc){
			System.out.println(exc);
		}
	}
	
	public static int perimiter(int a, int b, int c){		
		if (!(a + b > c && a + c > b && b + c > a))
			throw new IllegalArgumentException(
					String.format("%d %d and %d cannot make triangle",
							a, b, c));
		return a + b + c;		
	}
}
