package hr.fer.oop.iterable;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DigitIterator implements Iterator<Integer> {
	private int expOf10;
	private int num;
	public DigitIterator(int num) {
		this.num = num;
		expOf10 = (int) Math.pow(10, (int) Math.log10(num));		
	}

	@Override
	public boolean hasNext() {
		return num > 0;
	}

	@Override
	public Integer next() {
		if (hasNext()) {
			int digit = num / expOf10;
			num %= expOf10;
			expOf10 /= 10;
			return digit;
		}
		else 
			throw new NoSuchElementException("No more digits");
	}
}
