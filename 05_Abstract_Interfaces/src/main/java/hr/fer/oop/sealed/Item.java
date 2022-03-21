package hr.fer.oop.sealed;

public abstract sealed class Item permits Food, Cloth, Beverage {	
	private String sku; //Stock Keeping Unit / ProductNumber
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
	public abstract String getItemType();
	
	protected Item(String sku, String name){
		this(sku, name, 0);		
	}
	
	protected Item(String sku, String name, double price){		
		this.sku = sku;
		this.name = name;
		this.netSalePrice = price;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s (%s)", getSku(), getName(), getItemType());
	}
}
