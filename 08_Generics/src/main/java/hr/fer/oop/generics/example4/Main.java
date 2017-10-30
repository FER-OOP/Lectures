package hr.fer.oop.generics.example4;

public class Main {
	public static void main(String[] args) {
		Wrapper<Number> num1 = new Wrapper<>(new Integer(10));
		Wrapper<Integer> num2 = new Wrapper<>(new Integer(10));
		m1(num1);
		//m1(num2);
		
		m2(num1);
		m2(num2);
	}

	static void m1(Wrapper<Number> num) {
		System.out.println(num);
	}
	
	static <T extends Number> void m2(Wrapper<T> num) {
		System.out.println(num);
	}
}
