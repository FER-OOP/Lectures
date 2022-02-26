package hr.fer.oop.task3;

public class Main {

	public static void main(String[] args) {
		MyInt num = new MyInt(55660);
		for (Integer i : num) {
			System.out.print(" " + i);
		}
		
		System.out.println();

		num = new MyInt(12);
		for (Integer i : num) {
			for (Integer j : num) {
				System.out.print(" " + i * j);
			}
		}
		
		System.out.println();
		
		for(int i=1; i<=100; i++) {
			System.out.print(i + " = ");
			for(Integer x : new MyInt(i)) {
				System.out.print(" " + x);
			}
			System.out.println();
		}

	}

}
