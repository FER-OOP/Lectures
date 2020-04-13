package hr.fer.oop.generics.toys;

import hr.fer.oop.generics.list.MyList;

public abstract class Container<T extends Toy> {
	protected int capacity;
	protected MyList<T> list;

	public Container(int capacity) {
		this.capacity = capacity;
		this.list = new MyList<T>();
	}

	public void addToy(T obj) throws TooLittleSpace {
		int fin = obj.getVolume() + getTotalOccupance();
		if (capacity < fin)
			throw new TooLittleSpace("Container exceedes capacity by " + (fin - capacity));
		this.list.add(obj);
	}

	public T getToy(int index) {
		return (this.list.elementAt(index));
	}

	public int getNoOfToys() {
		return (this.list.size());
	}

	public int getTotalOccupance() {
		int total = 0;
		for (int i = 0; i < getNoOfToys(); i++)
			total += getToy(i).getVolume();
		return (total);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < getNoOfToys(); i++) {
			sb.append(getToy(i));
			sb.append("\n");
		}
		return sb.toString();
	}
}
