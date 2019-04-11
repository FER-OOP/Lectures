package hr.fer.oop.generics.credit;

public abstract class Client {
	protected String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract double getCreditAbility(int rates);
	public abstract int getMaxAllowedRates();
}
