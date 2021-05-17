package hr.fer.oop.homework_11.e1c;

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
		 return createLocalIterator();
	}

	private Iterator<Integer> createLocalIterator() {
		// Common forward iterator
		class LocalNamedClassIterator implements Iterator<Integer> {

			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < numbers.length;
			}

			@Override
			public Integer next() {
				if(!hasNext()) {
					throw new NoSuchElementException("No more numbers are available.");
				}			
				return numbers[index++];
			}
		}

		return new LocalNamedClassIterator();
	}
		
}
