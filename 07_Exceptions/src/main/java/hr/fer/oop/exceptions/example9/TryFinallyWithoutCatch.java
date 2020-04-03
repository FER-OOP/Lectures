package hr.fer.oop.exceptions.example9;

public class TryFinallyWithoutCatch {

	public static void main(String[] args) {
		String s = "a13";
		try {
			try 
			{
				int i = Integer.parseInt(s);
			} 
			finally {
				System.out.println("Finally 1");
			}
		} 
		catch (Exception e) {
			System.out.println("Catch");
		} 
		finally {
			System.out.println("Finally 2");
		}

	}
}
