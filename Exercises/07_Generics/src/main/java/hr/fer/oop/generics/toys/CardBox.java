package hr.fer.oop.generics.toys;

public class CardBox<T extends Toy> extends Container<T> {
	public CardBox() {
		super(50000);
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Card box of capacity:");
		sb.append(super.capacity);
		sb.append(", total occupance:");
		sb.append(getTotalOccupance());
		sb.append("\n");
		sb.append(super.toString());
		return sb.toString();
	}
}
