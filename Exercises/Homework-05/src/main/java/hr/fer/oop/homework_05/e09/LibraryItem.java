package hr.fer.oop.homework_05.e09;

public abstract class LibraryItem {
	
	private int id;
	private String name;
	
	public LibraryItem(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return id + "," + name;
	}
	
	public abstract int getLoanPeriod();

}