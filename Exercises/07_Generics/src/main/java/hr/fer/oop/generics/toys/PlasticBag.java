package hr.fer.oop.generics.toys;

public class PlasticBag<T extends Toy> extends Container<T> {

	public PlasticBag() {
		super(6000);		
	}

	@Override
	protected String getContainerType() {
		return "Plastic bag";
	}

}
