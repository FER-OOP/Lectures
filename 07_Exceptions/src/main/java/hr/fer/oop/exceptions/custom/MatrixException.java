package hr.fer.oop.exceptions.custom;

/**
 * This is an general exception which is parent of all 
 * more specific exceptions in this matrix library. Each
 * specific exception will usually have an reference to
 * offending matrices as well as appropriate getters.
 * 
 * @author marcupic
 */
public class MatrixException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param message description of exception
	 */
	public MatrixException(String message) {
		super(message);
	}
	
}

