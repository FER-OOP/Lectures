package hr.fer.oop.task2.items;

import java.time.LocalDate;

public final class Milk extends Beverage implements IPerishable {
	private MilkType type;
	private double fatPercentage;
	
	private LocalDate bestBefore;	
	
	@Override
	public LocalDate getBestBefore() {
		return bestBefore;
	}
	@Override
	public void setBestBefore(LocalDate bestBefore) {
		this.bestBefore = bestBefore;
	}
			
	public MilkType getType() {
		return type;
	}
	public void setType(MilkType type) {
		this.type = type;
	}
	public double getFatPercentage() {
		return fatPercentage;
	}
	public void setFatPercentage(double fatPercentage) {
		this.fatPercentage = fatPercentage;
	}
		
	public Milk(String sku, String name, double price, double volume, MilkType milkType, LocalDate bestBefore){
		super(sku, name, price, volume);
		this.bestBefore = bestBefore;
		this.type = milkType;
	}
		
	@Override
	public String getItemType() {
		return "Milk";
	}
	
	@Override
	public double getVAT() {
		return 0.05;
	}
}
