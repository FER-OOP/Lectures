package hr.fer.oop.generics.example4;

public class Main {
	public static void main(String[] args) {
		Pair<Number> num1 = new Pair<>(10, 5);
		Pair<Integer> num2 = new Pair<>(10, 3);
		m1(num1);
		//m1(num2);

		m2(num1);
		m2(num2);
		
		Pair<String> ps = new Pair<>("A", "B");
		//m2(ps); //compile error
	}

	static void m1(Pair<Number> num) {
		System.out.println(num);
	}

	static <T extends Number> void m2(Pair<T> num) {
		System.out.println(num);
	}
}
