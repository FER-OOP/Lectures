package hr.fer.oop.homework_11.e1a;

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
		return new StaticNestedClassIterator(this);
	}

	// Backward skipping iterator  
	private static class StaticNestedClassIterator implements Iterator<Integer> {
		private int index; 
		private ImmutableContainer col;
		public StaticNestedClassIterator(ImmutableContainer col) {
			this.col = col;
			this.index = col.numbers.length - 1;
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
			index = index - 2;
			return col.numbers[index + 2];
		}
	}	

}
