package hr.fer.oop.collections;
import java.util.ArrayList;

public class ArrayListMain {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(10);
		System.out.println("Size: " + arr.size());
		for(int i=0; i<1000; i++) {
			arr.add(2*i);
		}
		System.out.println("Size: " + arr.size());
		System.out.println("ELement at pos. 750: " + arr.get(750));
	}
}
