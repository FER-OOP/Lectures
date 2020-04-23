package hr.fer.oop.lab4;

public class SimpleArrayList<T> {

	private T[] elementData;
	private int size;

	@SuppressWarnings("unchecked")
	public SimpleArrayList() {
		elementData = (T[]) new Object[2];
		size = 0; // Was not necessary
	}

	// Appends the specified element to the end of this list.
	public void add(T t) {
		ensureCapacity(size + 1);
		elementData[size++] = t;		
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns the element at the specified position in this list.
	public T get(int index) {		
		if (index < size) {
			return elementData[index];
		}
		else
			throw new OutOfRangeException(String.format("%d is not valid index", index));
	}

	// Set the element at the specified position in this list (no gaps allowed)
	public void set(int index, T t) {
		if (index < size)
		{			
			elementData[index] = t;			
		}
		else if (index == size) {
			add(t);			
		}
		else 
			throw new OutOfRangeException(String.format("%d is not valid index", index));
	}
	
	public void insertAt(int index, T t) {
		if (index <= size)
		{
			ensureCapacity(size + 1);
			for(int i=size; i> index; i--) {
				elementData[i] = elementData[i-1];
			}
			elementData[index] = t;
			++size;			
		}		
		else
			throw new OutOfRangeException(String.format("%d is not valid index", index));
	}
	
	public void removeAt(int index) {
		if (index < size)
		{			
			for(int i=index; i<size; i++) {
				elementData[i] = elementData[i+1];
			}			
			--size;			
		}		
		else
			throw new OutOfRangeException(String.format("%d is not valid index", index));
	}

	// Returns the index of the first occurrence of the specified element in
	// this
	// list, or -1 if this list does not contain the element.
	public int indexOf(T t) {
		int found = -1;
		for (int i = 0; i < size; i++) {
			if (elementData[i].equals(t)) {
				found = i;
				break;
			}
		}
		return found;
	}	

	// Increases the capacity of this SimpleArrayList instance, if
	// necessary, to ensure that it can hold at least the number of elements
	// specified by the minimum capacity argument.
	public void ensureCapacity(int minCapacity) {
		int current = elementData.length;
		if (minCapacity > current) {
			// Ensure some extra space so as not to copy too many times
			@SuppressWarnings("unchecked")
			T[] newData = (T[]) new Object[Math.max(current * 2, minCapacity)];
			System.arraycopy(elementData, 0, newData, 0, size);
			elementData = newData;
		}

	}
}
