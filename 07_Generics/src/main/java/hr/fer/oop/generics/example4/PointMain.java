package hr.fer.oop.generics.example4;

public class PointMain {
	public static void main(String[] args) {
		Point<Number> num1 = new Point<>(new Integer(10), new Integer(5));
		Point<Integer> num2 = new Point<>(new Integer(10), new Integer(3));
		m1(num1);
		//m1(num2);

		m2(num1);
		m2(num2);
	}

	static void m1(Point<Number> num) {
		System.out.println(num);
	}

	static <T extends Number> void m2(Point<T> num) {
		System.out.println(num);
	}
}
