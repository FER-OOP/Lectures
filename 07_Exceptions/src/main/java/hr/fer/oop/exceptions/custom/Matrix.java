package hr.fer.oop.exceptions.custom;


/**
 * Simple unmodifiable matrix of real numbers.
 * Indexes are zero based, so top-left element
 * is at (0,0).
 * 
 * @author marcupic
 */
public class Matrix {

	/**
	 * Array for matrix elements storage.
	 */
	private double[][] data;
	/**
	 * Number of rows in matrix.
	 */
	private int rows;
	/**
	 * Number of columns in matrix.
	 */
	private int cols;
	
	/**
	 * Constructor. Creates matrix of given dimensions
	 * whose all elements are zero.
	 * 
	 * @param rows number of rows
	 * @param cols number of cols
	 */
	public Matrix(int rows, int cols) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.data = new double[rows][cols];
	}

	/**
	 * Constructor. Creates matrix whose elements are
	 * copy of given array. In order for this to succeed,
	 * array must have at least one row, and in case when
	 * there is more than one row, each row must contain
	 * same number of elements.
	 * 
	 * @param data matrix elements to be copied
	 */
	public Matrix(double[][] data) {
		super();
		if(data.length < 1 || data[0].length < 1) {
			throw new IllegalArgumentException("Could not initialize matrix from given array.");
		}
		this.rows = data.length;
		this.cols = data[0].length;
		this.data = new double[rows][cols];
		for(int r = 0; r < rows; r++) {
			if(data[r].length != cols) {
				throw new IllegalArgumentException("Could not initialize matrix from given array.");
			}
			for(int c = 0; c < cols; c++) {
				this.data[r][c] = data[r][c];
			}
		}
	}

	/**
	 * Getter for selected matrix element.
	 * @param row element row
	 * @param col element column
	 * @return value stored in matrix at (row, column)
	 */
	public double get(int row, int col) {
		return data[row][col];
	}

	/**
	 * Creates (and returns) new matrix which corresponds
	 * to the result of addition of this matrix and other 
	 * matrix. Operands remain unchanged.
	 *  
	 * @param other matrix to add
	 * @return the result of addition
	 * @throws IncompatibleMatrixException if current matrix and other matrix are not of same dimensions
	 */
	public Matrix add(Matrix other) {
		if (rows != other.rows || cols != other.cols) {
			throw new IncompatibleMatrixException("Addition is not possible.",
					this, other);
		}
		Matrix result = new Matrix(this.data);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				result.data[r][c] += other.data[r][c];
			}
		}
		return result;
	}
	
	/**
	 * Calculates and returns an inverse of this matrix.
	 * This matrix remains unchanged.
	 * 
	 * @return matrix inverse of current matrix
	 * @throws SingularMatrixException if current matrix is singular (i.e. non-invertible)
	 */
	public Matrix invert() {
		boolean singular = false;
		// check somehow to see if it is singular...
		if(singular) {
			throw new SingularMatrixException("Matrix inversion is not possible.", this);
		}
		// otherwise calculate invers and return it...
		return null;
	}
}

