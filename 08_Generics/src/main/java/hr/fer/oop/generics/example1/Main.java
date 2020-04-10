package hr.fer.oop.generics.example1;

public class Main {

	public static void main(String[] args) {
		IntPair ip = new IntPair(3, 5);
		System.out.println("First = " + ip.getFirst());
		System.out.println("Second = " + ip.getFirst());
		System.out.println("Pair = " + ip.toString());
		
		StringPair sp = new StringPair("A", "B");
		System.out.println("First = " + sp.getFirst());
		System.out.println("Second = " + sp.getFirst());
		System.out.println("Pair = " + sp.toString());

	}

}
