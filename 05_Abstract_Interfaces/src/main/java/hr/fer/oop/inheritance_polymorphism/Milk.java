package hr.fer.oop.inheritance_polymorphism;

import java.time.LocalDate;

public final class Milk extends Beverage implements Perishable {
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
		
	public Milk(String productId, String name, double price, double volume, MilkType milkType, LocalDate bestBefore){
		super(productId, name, price, volume);
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
