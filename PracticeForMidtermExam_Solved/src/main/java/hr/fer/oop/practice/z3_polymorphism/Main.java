package hr.fer.oop.practice.z3_polymorphism;

public class Main {

	public static void main(String[] args) {
	   C c1 = new C();
	   C c2 = new C(1, 2, 3, 4);
	   System.out.println(c1); // ispisuje: x=0 y=0 z=0 w=0
	   System.out.println(c2); // ispisuje: x=1 y=2 z=3 w=4
	}
}
