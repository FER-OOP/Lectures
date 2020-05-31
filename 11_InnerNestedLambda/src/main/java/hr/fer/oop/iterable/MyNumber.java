package hr.fer.oop.iterable;
import java.util.Iterator;

public class MyNumber implements Iterable<Integer> {
	private int num;

	public MyNumber(int num) {
		if (num <=0)
			throw new IllegalArgumentException("Number must be positive");
		this.num = num;		
	}

	@Override
	public Iterator<Integer> iterator() {
		return new DigitIterator(num);
	}	
}
