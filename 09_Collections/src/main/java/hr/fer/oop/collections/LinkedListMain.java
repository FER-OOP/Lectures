package hr.fer.oop.collections;
import java.util.LinkedList;

public class LinkedListMain {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		System.out.println("Size: " + list.size());
		for(int i=0; i<1000; i++) {
			list.add(2*i);
		}
		System.out.println("Size: " + list.size());
		System.out.println("ELement at pos. 750: " + list.get(750));
	}
}
