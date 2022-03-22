package hr.fer.oop.inheritance_polymorphism;

public class Cloth extends Item {
	private double size;
	public Cloth(String productId, String name, double size){
		super(productId, name);
		this.size = size;
	}
	
	public Cloth(String productId, String name, double price, double size){
		super(productId, name, price);
		this.size = size;
	}
	
	@Override
	public String getItemType() {
		return "Cloth";
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}
	
}
