package hr.fer.oop.generics.example3;

public class Main {
	public static void main(String[] args) {
		Wrapper<Integer> iNumber = new Wrapper<>(5);
		Wrapper<Double> dNumber = new Wrapper<>(15.0);
		
		iNumber.printWith(dNumber);
		iNumber.printWith("OOP");
		
		iNumber.printWithWrapper(dNumber);
		iNumber.printWithWrapper(iNumber);
		//iNumber.printWithWrapper("OOP"); //compile error
		
	}
}
