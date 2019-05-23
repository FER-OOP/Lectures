package hr.fer.oop.zad1;

import java.nio.file.Path;

public class Item implements Comparable<Item>{
	private Path name;
	private long size;
	
	public Item(Path name, long size) {
		this.name = name;
		this.size = size;
	}
	
	public Path getName() {
		return this.name;
	}
	
	public long getSize() {
		return this.size;
	}

	@Override
	public int compareTo(Item o) {
		if (this.size > o.getSize())
			return -1;
		else if (this.size < o.getSize())
			return 1;
		else 
			return 0;
	}	
	

}
