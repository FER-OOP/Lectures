package hr.fer.oop.collections_and_customclasses.example8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompositeComparator<T> implements Comparator<T> {
	private List<Comparator<T>> comparators;

	@SafeVarargs
	public CompositeComparator(Comparator<T>... comparators) {
		this.comparators = new ArrayList<>(comparators.length);
		Collections.addAll(this.comparators, comparators);
		// or instead we can do this like
//		for (Comparator<T> c : comparators) {
//			this.comparators.add(c);
//		}
	}

	public CompositeComparator(List<Comparator<T>> comparators) {
		this.comparators = new ArrayList<>(comparators.size());
		this.comparators.addAll(comparators);		
	}

	@Override
	public int compare(T o1, T o2) {
		for (Comparator<T> c : comparators) {
			int r = c.compare(o1, o2);
			if (r != 0)
				return r;
		}
		return 0;

	}

}
