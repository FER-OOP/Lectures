package hr.fer.oop.generics.toys;

public class CardBox<T extends Toy> extends Container<T> {

	public CardBox() {
		super(50000);		
	}

	@Override
	protected String getContainerType() {
		return "Card box";
	}

}
