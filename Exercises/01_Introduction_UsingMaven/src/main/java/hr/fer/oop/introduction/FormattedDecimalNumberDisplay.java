package hr.fer.oop.introduction;
import java.text.DecimalFormat;
/**
 * @author OOP course
 * @version 1.0
 */
public class FormattedDecimalNumberDisplay {
	/**
	 * The method prints the array of decimal numbers according to a set format. 
	 * @param array array of decimal numbers to be printed according to the format
	 * @param format format describing how to print an array
	 * @see DecimalFormat
	*/
	public static void print(double[] array, String format) { DecimalFormat formatter = new DecimalFormat(format);
	  for(int i = 0; i < array.length; i++) { 
		 System.out.println("(" + i + "): [" + 
		    formatter.format(array[i]) + "]");
	   }
	}
	/**
	 * This method is called once the program is run.   
	 * Arguments are described below
	 * @param args Command line arguments.
	*/
	public static void main(String[] args) { 
	   double[] numbers = new double[] {3.712, 55.813, 55.816, 
		  -4.18};
	   print(numbers, "000.00");
	   print(numbers, "+00.00;-00.00");
	}
}
