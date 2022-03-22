package hr.fer.oop.inheritance_polymorphism;

public class Beverage extends Item {
	private double volume;
	public Beverage(String productId, String name, double volume){
		super(productId, name);
		this.volume = volume;
	}
	
	public Beverage(String productId, String name, double price, double volume){
		super(productId, name, price);
		this.volume = volume;
	}
	
	@Override
	public String getItemType() {
		return "Beverage";
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	
}
