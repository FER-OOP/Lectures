package hr.fer.oop.task3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SkipEven implements Iterable<Integer> {

	private Iterable<Integer> col;

	public SkipEven(Iterable<Integer> col) {
		this.col = col;		
	}

	@Override
	public Iterator<Integer> iterator() {
		return new SkipEvenIterator(col.iterator());
	}
	
	private static class SkipEvenIterator implements Iterator<Integer> {

		private Iterator<Integer> iterator;
		private Integer nextToReturn = null;

		public SkipEvenIterator(Iterator<Integer> iterator) {
			this.iterator = iterator;
		}

		@Override
		public boolean hasNext() {
			while(nextToReturn == null && iterator.hasNext()) {
				Integer current = iterator.next();
				if (current % 2 == 1) {
					nextToReturn = current;
					break;
				}
			}
			return nextToReturn != null;	
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Integer retValue = nextToReturn;
			nextToReturn = null;
			return retValue;
		}
		 
	}
}
