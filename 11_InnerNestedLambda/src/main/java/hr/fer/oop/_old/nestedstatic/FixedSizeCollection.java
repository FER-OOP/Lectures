package hr.fer.oop._old.nestedstatic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedSizeCollection<T> implements Iterable<T> {	
	private T[] elements; //
	@SuppressWarnings("unchecked")
	public FixedSizeCollection(int count){
		elements = (T[]) new Object[count]; //new T[count] not possible in Java
	}
	@SuppressWarnings("unchecked")
	public FixedSizeCollection(T... items){
		elements = (T[]) new Object[items.length]; //new T[count] not possible in Java
		for(int i=0; i<items.length ; i++){
			elements[i] = items[i];
		}
	}
	public int getSize() {
		return elements.length;
	}
	
	public T getElement(int index) {		
		return elements[index];
	}

	public void setElement(int index, T value) {		
		elements[index] = value;
	}
	
	@Override
	public Iterator<T> iterator() {
		// Create a new iterator which does not see this
		// collection's member variables and methods, so
		// we pass explicit reference to this collection:		
		return new CollectionIterator<>(this);
	}
	
	private static class CollectionIterator<T> implements Iterator<T> {

		private FixedSizeCollection<T> col;
		private int index = 0;		
		public CollectionIterator(FixedSizeCollection<T> col){
			this.col = col;			
		}
		@Override
		public boolean hasNext() {
			return index < col.elements.length;
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException("No more elements are available.");
			} 
			return col.elements[index++];
		}		
	}
}