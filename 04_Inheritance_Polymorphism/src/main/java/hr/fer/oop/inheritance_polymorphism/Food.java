package hr.fer.oop.inheritance_polymorphism;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Food extends Item {
	private double weight;
	private LocalDate bestBefore;
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public LocalDate getBestBefore() {
		return bestBefore;
	}
	public void setBestBefore(LocalDate bestBefore) {
		this.bestBefore = bestBefore;
	}
		
	public Food(String productId, String name, LocalDate bestBefore){
		super(productId, name);
		this.bestBefore = bestBefore;
	}	
	public Food(String productId, String name, double price, LocalDate bestBefore){
		super(productId, name, price);
		this.bestBefore = bestBefore;
	}
	
	@Override
	public String toString() {
		String s = super.toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");		
		s += ", best before: " + bestBefore.format(formatter);
		return s;
	}
	
	@Override
	public String getItemType() {
		return "Food";
	}
	
	@Override
	public double getVAT() {
		return 0.13;
	}

	
	
}
