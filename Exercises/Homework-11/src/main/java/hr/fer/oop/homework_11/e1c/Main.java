package hr.fer.oop.homework_11.e1c;

import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) {
		Integer[] array = { 0, -53, 4, 25, 8};
		ImmutableContainer ic = new ImmutableContainer(array);
		
		for(Integer i : ic) 
			System.out.format("%d ", i);

		System.out.println();
		Iterator<Integer> iterator = ic.iterator();
		while (iterator.hasNext()) 
			System.out.format("%d ", iterator.next());
		
		System.out.println();
		for(Integer i : ic)
			for(Integer j : ic)
				System.out.format("(%3d, %3d)\n", i, j);			
	}
}
