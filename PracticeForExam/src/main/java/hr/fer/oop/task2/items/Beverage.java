package hr.fer.oop.task2.items;

public class Beverage extends Item {
	private double volume;
	public Beverage(String sku, String name, double volume){
		super(sku, name);
		this.volume = volume;
	}
	
	public Beverage(String sku, String name, double price, double volume){
		super(sku, name, price);
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
