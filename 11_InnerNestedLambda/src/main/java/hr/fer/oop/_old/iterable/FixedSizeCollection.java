package hr.fer.oop._old.iterable;

import java.util.Iterator;

public class FixedSizeCollection<T> implements Iterable<T> {	
	private T[] elements; 
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
		return new CollectionIterator<>(this);
	}	
}
