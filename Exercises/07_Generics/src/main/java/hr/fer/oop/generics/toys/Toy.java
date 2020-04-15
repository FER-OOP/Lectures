package hr.fer.oop.generics.toys;

public abstract class Toy {
	private int volume;
	private String name;
	
	protected Toy(int volume, String name) {
		this.name = name;
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}

	public String getName() {
		return name;
	}
	
	public abstract String getType();
	
	public String toString() {		
		return String.format("%s: %s (%d cm3)", getType(), getName(), getVolume());
	}

}
