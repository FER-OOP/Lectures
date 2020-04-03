package hr.fer.oop.exceptions.example6;

public class ThrowingAnException {

	public static void main(String[] args) {
		try{
			if (perimiter(5, 4, 3) > perimiter(3, 2, 1)) {
				//do something...
			}					
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
