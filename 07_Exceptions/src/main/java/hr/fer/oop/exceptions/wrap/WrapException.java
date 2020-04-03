package hr.fer.oop.exceptions.wrap;

public class WrapException {

	public static void main(String[] args) {
		String s = "a13";
		try {
			try 
			{
				int i = Integer.parseInt(s);
			} 
			catch (NumberFormatException exc) {
				System.out.println("Caught NumberFormatException");
				throw new RuntimeException(exc);
			}
		} 
		catch (Exception e) {
			System.out.println("Caught " + e);
			System.out.println("Cause by " + e.getCause());
		} 
		finally {
			System.out.println("Finally 2");
		}

	}
}
