package hr.fer.oop.homework_07.e04;

public class Solution {

	public static void main(String[] args) {

		String[] input3 = { "a", "b", "c", null };
		exceptionalMethod(input3);
	}

	private static void exceptionalMethod(String[] input) {
		String result = "";
		for (String string : input) {
			try {
				String upper = string.toUpperCase();
				result += upper.toCharArray()[0];
			} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.println("finally");
			}
		}
		System.out.println(result);
	}

}
