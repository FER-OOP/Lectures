package hr.fer.oop.generics.toys;

public class PlasticBag<T extends Toy> extends Container<T> {
	public PlasticBag() {
		super(6000);
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("Plastic bag of capacity:");
		sb.append(super.capacity);
		sb.append(", total occupance:");
		sb.append(super.getTotalOccupance());
		sb.append("\n");
		sb.append(super.toString());
		return sb.toString();
	}
}
