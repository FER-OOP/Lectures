package hr.fer.oop.inheritance_polymorphism;

public class Item {	
	private final String productId; //Stock Keeping Unit (ProductNumber)
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
	public String getItemType(){
		return "";
	}
	
	public Item(String productId, String name){
		this(productId, name, 0);
	}
	
	public Item(String productId, String name, double price){
		this.productId = productId;
		this.name = name;
		this.netSalePrice = price;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", getProductId(), getName());
	}
}
