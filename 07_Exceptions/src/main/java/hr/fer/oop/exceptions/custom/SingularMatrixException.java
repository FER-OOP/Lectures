package hr.fer.oop.exceptions.custom;


/**
 * This is an exception that is thrown when some matrix operation
 * has failed due to singular matrix (e.g. matrix inversion).
 * 
 * @author marcupic
 */
public class SingularMatrixException extends MatrixException {

	private static final long serialVersionUID = 1L;

	/**
	 * Reference to a matrix that is singular.
	 */
	private Matrix matrix;
	
	/**
	 * Constructor.
	 * @param message description of exception
	 * @param matrix matrix that is singular
	 */
	public SingularMatrixException(String message, Matrix matrix) {
		super(message);
		this.matrix = matrix;
	}
	
	/**
	 * Getter for matrix.
	 * @return matrix
	 */
	public Matrix getMatrix() {
		return matrix;
	}
}


