package hr.fer.oop.generics.toys;

public class TeddyBearToy extends Toy {
	public TeddyBearToy(int volume,String name) {
		super(volume,name);
	}
	public TeddyBearToy() {
		super(5000,"Tedddyy");
	}
	
	@Override
	public String toString() {
		return "Teddy bear:"+super.name+"("+super.volume+" cm3)";
	}
}
