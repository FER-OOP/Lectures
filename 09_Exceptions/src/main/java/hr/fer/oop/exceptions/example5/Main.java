package hr.fer.oop.exceptions.example5;

public class Main {

	public static void main(String[] args) {
		try{
			System.out.println(isTriangle(5, 3, 2));
			System.out.println(isTriangle(4, 3, 2));
			System.out.println(isTriangle(-1, 3, 2));
		}
		catch(Exception exc){
			System.err.println(exc);
		}
	}
	
	public static boolean isTriangle(int a, int b, int c){
		if (a <= 0 || b <=0 || c<=0)
			throw new IllegalArgumentException("Arguments must be greater than 0");
		if (a + b > c && a + c > b && b + c > a)
			return true;
		else
			return false;		
	}
}
