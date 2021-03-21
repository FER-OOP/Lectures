package hr.fer.oop.homework_04.e01;

public class Dessert {

	private String name;
	private double weight;
	private int calories;
	
	public Dessert(String name, double weight, int calories) {
		this.name = name;
		this.weight = weight;
		this.calories = calories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return name + " weight=" + weight + ", calories=" + calories;
	}
	
	public String getDessertType() {
		return "dessert";
	}
	
}
