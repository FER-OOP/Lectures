package hr.fer.oop.lists;

// Using only given array...

public class Example2a {

	public static void main(String[] args) {

		String[] names = { "Eva", "Ivan", "Eva", "Ante", "Ivan", "Jasna", "Stjepan", "Jasna" };

		writeInReverse(names);
	}

	private static void writeInReverse(String[] names) {
		for (int i = names.length - 1; i >= 0; i--) {
			if (!isPresentInRange(names[i], names, i + 1, names.length - 1)) {
				System.out.println(names[i]);
			}
		}
	}

	private static boolean isPresentInRange(String element, String[] array, int fromIndex, int toIndex) {
		for (int i = fromIndex; i <= toIndex; i++) {
			if (array[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

}
