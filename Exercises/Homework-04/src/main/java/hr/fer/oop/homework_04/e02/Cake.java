package hr.fer.oop.homework_04.e02;

import hr.fer.oop.homework_04.e01.Dessert;

public class Cake extends Dessert{
	
	private boolean containsGluten;
	private String cakeType;

	public Cake(String name, double weight, int calories, boolean containsGluten, String cakeType) {
		super(name, weight, calories);
		this.containsGluten = containsGluten;
		this.cakeType = cakeType;
	}

	public boolean isContainsGluten() {
		return containsGluten;
	}

	public void setContainsGluten(boolean containsGluten) {
		this.containsGluten = containsGluten;
	}

	public String getCakeType() {
		return cakeType;
	}

	public void setCakeType(String cakeType) {
		this.cakeType = cakeType;
	}

	@Override
	public String toString() {
		return super.toString() + ", containsGluten=" + containsGluten + ", cakeType=" + cakeType;
	}

	@Override
	public String getDessertType() {
		return this.cakeType + " cake";
	}
}
