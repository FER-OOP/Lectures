package hr.fer.oop.exceptions.example9;

public class ExampleWithFinally {

	private static void m2() {
		System.out.println("\t\tHello from m2");
		try {
			int num = Integer.parseInt("ABC"); 
			System.out.println("M2-This command is never run");		
		}
		catch(ArrayIndexOutOfBoundsException exc) {
			//catching "wrong exception";
			System.out.println("Catch in m2");
		}
		finally {
			System.out.println("\t\tFinally-M2");
		}
		
		System.out.println("\t\tEnd of m2");
	}
	
	private static void m1() {
		System.out.println("\tCalling m2 from m1");
		try {
			m2();	
			System.out.println("M1-This command is never run");		
		}
		catch(NumberFormatException exc) {			
			System.out.println("\tCatch in m1 - printing Stack trace");
			exc.printStackTrace(System.out);
			System.out.println();
		}
		finally {
			System.out.println("\tFinally-M1");
		}
		System.out.println("\tEnd of m1");
	}	
	
	public static void main(String[] args) {
		
		System.out.println("Before m1");
		m1();
		System.out.println("After m1");				
	}

}
