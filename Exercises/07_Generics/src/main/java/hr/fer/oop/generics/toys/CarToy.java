package hr.fer.oop.generics.toys;

public class CarToy extends Toy {
	public CarToy(int volume,String name) {
		super(volume,name);
	}
	public CarToy() {
		super(100,"Brmbrm");
	}
	
	@Override
	public String toString() {
		return "Car:"+super.name+"("+super.volume+" cm3)";
	}
}
