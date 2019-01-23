package hr.fer.oop.task3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyInt implements Iterable<Integer> {

	private int i;
	public MyInt(int i) {
		this.i = i;
	}
	@Override
	public Iterator<Integer> iterator() {
		return new MyIntIterator();
	}
	
	private class MyIntIterator implements Iterator<Integer> {
		private int number;
		private int factor = 2;
		public MyIntIterator() {
			number = i;
		}

		@Override
		public boolean hasNext() {
			return factor <= number;
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			while(number % factor != 0) 
				++factor;
			
			number /= factor;
			return factor;			
		}
		
	}

}
