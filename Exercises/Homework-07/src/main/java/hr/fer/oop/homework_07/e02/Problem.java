package hr.fer.oop.homework_07.e02;

public class Problem {

	public static void main(String[] args) {
		String[] input1 = { "a", "b", "c", "d" };
		exceptionalMethod(input1);

		String[] input2 = { "a", "b", "c", "" };
		exceptionalMethod(input2);

		String[] input3 = { "a", "b", "c", null };
		exceptionalMethod(input3);
	}

	private static void exceptionalMethod(String[] input) {
		String result = "";
		for (String string : input) {
			String upper = string.toUpperCase();
			result += upper.toCharArray()[0];
		}
		System.out.println(result);
	}

}
