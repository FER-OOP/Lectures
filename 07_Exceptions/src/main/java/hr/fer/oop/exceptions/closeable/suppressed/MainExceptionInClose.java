package hr.fer.oop.exceptions.closeable.suppressed;

public class MainExceptionInClose {

	public static void main(String[] args) {
		try(ResourceCloseExc r1 = new ResourceCloseExc(1); ResourceCloseExc r2 = new ResourceCloseExc(2)){
			 int a = 5, b = 0;
			 a = a / b;
			 System.out.println("Try block ends.");
		} 
		catch (Exception e) {	
			System.out.println("Catch...");
			e.printStackTrace(System.out);
		}
		finally{
			System.out.println("finally");
		}
		System.out.println("Main continues...");
	}	
}
