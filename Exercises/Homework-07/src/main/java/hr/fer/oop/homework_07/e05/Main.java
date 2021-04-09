package hr.fer.oop.homework_07.e05;

public class Main {

	public static void main(String[] args) throws CheckedException {
		m1();
		m2();
	}

	public static void m1() {
		throw new UncheckedException();
	}

	public static void m2() throws CheckedException {
		throw new CheckedException();
	}

}
