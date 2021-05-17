package hr.fer.oop.homework_11.e1d;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ImmutableContainer implements Iterable<Integer> {
	private Integer[] numbers;   

	public ImmutableContainer(Integer... num) {
		numbers = new Integer[num.length];
		for(int i = 0; i<num.length; i++)
			numbers[i] = num[i];
	}
	
	@Override
	public Iterator<Integer> iterator() {
		// Backward iterator 
		return new Iterator<>() {  
			//private int index = numbers.length - 1;
			private int index;
			 // we have lost the ability to use constructor in an anonymous class, 
			 // so an instance block can be used instead
			{  
				index = numbers.length - 1;
			}
			
			@Override
			public boolean hasNext() {
				return index >= 0;
			}

			@Override
			public Integer next() {
				if(!hasNext()) {
					throw new NoSuchElementException("No more numbers are available.");
				}
				return numbers[index--];
			}
		};
	}
			
}
