package hr.fer.oop.iterable.wrong;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyNumber implements Iterable<Integer> {
	private int num;

	public MyNumber(int num) {
		if (num <=0)
			throw new IllegalArgumentException("Number must be positive");
		this.num = num;		
	}

	@Override
	public Iterator<Integer> iterator() {
		List<Integer> list = new LinkedList<>();
		int temp = num;
		while(temp > 0) {
			list.add(0, temp % 10);
			temp /= 10;
		}
		return list.iterator();
	}
	
}
