package hr.fer.oop.lab6.task2;

import java.util.Iterator;

public class PrimeNumbers implements Iterable<Integer> {

	private int startFrom;
	public PrimeNumbers(int startFrom) {
		this.startFrom = startFrom;
	}
	@Override
	public Iterator<Integer> iterator() {
		return new MyPrimeNumbersIterator();
	}
	
	private class MyPrimeNumbersIterator implements Iterator<Integer> {
		int last = startFrom - 1;

		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public Integer next() {
			boolean found = false;
			while(!found) {
				++last;
				int limit = (int) Math.sqrt(last);
				boolean isPrime = true;
	            for (int divisor = 2; divisor <= limit; divisor++) {
	                if (last % divisor == 0) {
	                    isPrime = false;
	                    break;
	                }
	            }	            
	            found = isPrime;
			}
			return last;
		}
		
	}

}
