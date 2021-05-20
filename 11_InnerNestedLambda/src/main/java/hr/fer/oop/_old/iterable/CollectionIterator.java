package hr.fer.oop._old.iterable;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class CollectionIterator<T> implements Iterator<T> {

	private FixedSizeCollection<T> col;
	private int index = 0;		
	public CollectionIterator(FixedSizeCollection<T> col){
		this.col = col;			
	}
	@Override
	public boolean hasNext() {
		return index < col.getSize();
	}

	@Override
	public T next() {
		if(!hasNext()) {
			throw new NoSuchElementException("No more elements are available.");
		} 
		return col.getElement(index++);
	}		
}
