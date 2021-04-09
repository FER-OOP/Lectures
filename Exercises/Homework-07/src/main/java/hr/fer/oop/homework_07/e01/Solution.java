package hr.fer.oop.homework_07.e01;

import java.util.NoSuchElementException;
import java.util.Scanner;

import hr.fer.oop.homework_07.e01.model.Person;
import hr.fer.oop.homework_07.e01.model.Student;

public class Solution {

	public static void main(String[] args) {

		// Identified problem: NumberFormatException
		// Solution 1: call the method with the correct parameter
		// Solution 2: check for correctness within the method (validation)
		// We present solution 1, you try both
		problem01Incrementer("5");

		// Identified problem: NullPointerException
		// Solution 1: call the method with the correct parameter
		// Solution 2: check for null within the method
		// We present solution 1, you try both
		problem02Ping(new Scanner(System.in));

		// Identified problem: Student is a person, but person may not be a student.
		// ClassCastException
		// Solution 1: validate the input within the method
		// Solution 2: call the method with the correct parameter
		// We present solution 1, you try both
		problem03PrintGrade(new Person("John", "Bambo"));

		// Identified problem: Iterating over an array which may not have the length of
		// 3. In that case: ArrayIndexOutofBoundsException.
		// Solution 1: fix the for loop so that it does not contain a hardcoded value
		// Solution 2: call the method with "correct" parameter ("correct" = an array
		// with at least 3 elements)
		// We present solution 1, you try both. Note: solution 2 (without implementation
		// of solution 1) is bad and should be discouraged.
		problem04PrintArray(args);

		// Identified problem: A bad case of recursion, StackOverflowError.
		// Solution 1: make sure there is no recursion
		// Solution 2: try to catch the error
		// We present solution 1. Note that solution 2 is not really a solution. In
		// general, the errors should not be catched because they indicate severe
		// problems from which the program can't recover.
		String result = problem05Print();

	}

	private static void problem01Incrementer(String numberAsString) {
		System.out.println("problem01Incrementer()");

		int result = Integer.parseInt(numberAsString);
		result++;
		System.out.println("When we increment the number " + numberAsString + " we get: " + result);
	}

	/**
	 * More comments related to exceptions. 
	 * 
	 * Observe that the code contains "hasNext()" which may throw {@link IllegalStateException}. 
	 * Such an unchecked exception may happen if the scanner is closed. In our solution, System.in will not be closed so we do not have to deal with this, but be aware of the possibility for such an exception in other cases.
	 * 
	 * Next, observe that the code contains "nextLine()" which may throw {@link NoSuchElementException} or {@link IllegalStateException}.
	 * Check for NoSuchElementException is not necessary because we use hasNext() to check whether we have something for scanner to interpret as the line.
	 * IllegalStateException will also not happen because we use System.in which we do not close. 
	 * 
	 * 
	 * @param s
	 */
	private static void problem02Ping(Scanner s) {
		System.out.println("problem02Ping()");

		System.out.println("Type something. If you type q we will finish with this problem.");
		while (s.hasNext()) {
			String line = s.nextLine();
			if (line.equals("q")) {
				break;
			} else
				System.out.println(line);
		}
	}

	/**
	 * 
	 * More comments related to exceptions.
	 * 
	 * A person may be null and that seems like a potential issue. 
	 * However, in this particular code, nothing bad will happen.
	 * If we pass null as person, the "instanceof" operator will return false.
	 * 
	 * @param person
	 */
	private static void problem03PrintGrade(Person person) {
		System.out.println("problem03PrintGrade()");

		// FIX: use instance of for safe casting
		if (person instanceof Student) {
			Student student = (Student) person;
			System.out.println("Grade: " + student.getGrade());
		} else {
			System.out.println("Sorry, this person is not a student: " + person);
		}

	}

	private static void problem04PrintArray(String[] array) {
		System.out.println("problem04PrintArray()");

		// FIX: use array.length instead of 3
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	private static String problem05Print() {
		// FIX: just put the quotation marks and prevent the method from recursion
		System.out.println("problem05Print()");

		return "problem05Print()";
	}

}
