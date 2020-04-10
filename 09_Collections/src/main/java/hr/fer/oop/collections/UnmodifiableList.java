package hr.fer.oop.collections;

import java.util.Arrays;
import java.util.List;

public class UnmodifiableList {
	public static void main(String[] args) {
		List<Integer> list = List.of(1,  2,  3);
		//list.add(4); //throws an Exception
		//list.set(0, 5); //throws and Exception
		System.out.println(list);
		
		
		list = Arrays.asList(1, 2, 3);
		//list.add(4); //throws an Exception
		list.set(0, 5);
		System.out.println(list);
				
	}
}
