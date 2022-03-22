package hr.fer.oop.inheritance_polymorphism;

public abstract class Item {	
	private String productId; //Stock Keeping Unit / ProductNumber
	private String name;
	private double netSalePrice;
	public String getProductId() {
		return productId;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getNetSalePrice() {
		return netSalePrice;
	}
	public void setNetSalePrice(double netSalePrice) {
		this.netSalePrice = netSalePrice;
	}
	public double getVAT(){
		return 0.25;
	}
	public double getPrice(int count){
		return count * getNetSalePrice() * (1 + getVAT());
	}
	public abstract String getItemType();
	
	protected Item(String productId, String name){
		this(productId, name, 0);
	}
	
	protected Item(String productId, String name, double price){
		this.productId = productId;
		this.name = name;
		this.netSalePrice = price;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s (%s)", getProductId(), getName(), getItemType());
	}
}
