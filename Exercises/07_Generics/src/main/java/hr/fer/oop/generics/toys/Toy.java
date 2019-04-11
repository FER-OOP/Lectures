package hr.fer.oop.generics.toys;

public abstract class Toy {
	protected int volume;
	protected String name;
	
	public Toy(int volume,String name) {
		this.volume=volume;
		this.name=name;
	}
	
	public int getVolume() {
		return(this.volume);
	}
	
	public String getName() {
		return(this.name);
	}
}
