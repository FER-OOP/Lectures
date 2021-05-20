package hr.fer.oop.collections_and_customclasses.example7;

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {

	private Comparator<T> original;

	public ReverseComparator(Comparator<T> original) {
		this.original = original;
	}

	@Override
	public int compare(T o1, T o2) {
		int r = original.compare(o1, o2);
		return -r;
	}

}
