package hr.fer.oop.generics.toys;

import hr.fer.oop.generics.list.MyList;

public abstract class Container<T extends Toy> {
	private final int capacity;
	private MyList<T> list = new MyList<>();;
	
	public Container(int capacity) {
		this.capacity = capacity;		
	}
	
	public void addToy(T toy) throws TooLittleSpace {
		int fin = toy.getVolume() + getTotalOccupance();
		if (capacity < fin) 
			throw new TooLittleSpace("Container exceedes capacity by " + (fin - capacity));
		list.add(toy);
	}
	
	public T getToy(int index) {
		return list.elementAt(index);
	}
	
	public int getNoOfToys() {
		return list.size();
	}

	private int getTotalOccupance() {
		int total = 0;
		for(int i = 0, cnt = getNoOfToys(); i < cnt ; i++) {
			total += getToy(i).getVolume();
		}
		return total;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getContainerType());
		sb.append(" of capacity: ");
		sb.append(capacity);
		sb.append(", total occupance:");
		sb.append(getTotalOccupance());
		sb.append("\n");		
		return sb.toString();
	}

	protected abstract String getContainerType();

}
