package hr.fer.oop.exceptions.custom;


/**
 * This is an exception that is thrown when some matrix operation
 * has failed due to operation on two incompatible matrices 
 * (e.g. matrix addition).
 * 
 * @author marcupic
 */
public class IncompatibleMatrixException extends MatrixException {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Reference to first matrix operand.
	 */
	private Matrix m1;
	/**
	 * Reference to second matrix operand.
	 */
	private Matrix m2;
	
	/**
	 * Constructor.
	 * @param message description of exception
	 * @param m1 first matrix operand
	 * @param m2 second matrix operand
	 */
	public IncompatibleMatrixException(String message, Matrix m1, Matrix m2) {
		super(message);
		this.m1 = m1;
		this.m2 = m2;
	}
	
	/**
	 * Getter for first matrix operand.
	 * @return first matrix operand
	 */
	public Matrix getMatrix1() {
		return m1;
	}
	
	/**
	 * Getter for second matrix operand.
	 * @return second matrix operand
	 */
	public Matrix getMatrix2() {
		return m2;
	}
}
