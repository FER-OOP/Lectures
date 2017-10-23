package hr.fer.oop.inheritance_polymorphism;

public class Item {	
	private final String sku; //Stock Keeping Unit (ProductNumber)
	private String name;
	private double netSalePrice;
	public String getSku() {
		return sku;
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
	
	public Item(String sku, String name){
		this(sku, name, 0);		
	}
	
	public Item(String sku, String name, double price){		
		this.sku = sku;
		this.name = name;
		this.netSalePrice = price;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s", getSku(), getName());
	}
}
