package hr.fer.oop.lab6.task2;

public class Main {

	public static void main(String[] args) {
		PrimeNumbers pn1 = new PrimeNumbers(50);
		int count = 0;
		for(Integer outer : pn1) {
			int innerCount = 0;
			for(Integer inner : pn1) {
				System.out.printf("%d %d%n", outer, inner);
				if (++innerCount >= 3) break;
			}
			if (++count >= 4) break;
		}
	}
}
