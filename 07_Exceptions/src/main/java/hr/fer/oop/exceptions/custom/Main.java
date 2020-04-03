package hr.fer.oop.exceptions.custom;

/**
* An example of matrix library usage and 
* custom exceptions.
*  
* @author marcupic
*/
public class Main {
	
	/**
	 * Program starts with this method.
	 * @param args command line arguments - not used here
	 */
	public static void main(String[] args) {
		
		Matrix m1 = new Matrix(2, 3);
		Matrix m2 = new Matrix(new double[][] {
			{1, 2, 3},
			{4, 5, 6}
		});
		Matrix m3 = new Matrix(new double[][] {
			{1, 2, 3, 4},
			{4, 5, 6, 7}
		});
		
		Matrix m4 = m1.add(m2);
		System.out.format("Result at row 1, column 2 is %f%n", m3.get(1, 2));
		
		// Next should result with exception which we will catch:
		
		try {
			Matrix m5 = m4.add(m3);
			System.out.println("OK, if you see this, something is seriously wrong!");
		} catch(IncompatibleMatrixException ex) {
			System.out.println("All is well! An exception has been thrown.");
		}
	}
	
}

