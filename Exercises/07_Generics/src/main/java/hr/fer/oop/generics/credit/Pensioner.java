package hr.fer.oop.generics.credit;

public class Pensioner extends Client {
	private double monthlyPension;
	public Pensioner(String name,double averageMonthlyPension) {
		super.name=name;
		this.monthlyPension=averageMonthlyPension;
	}
	
	public double getCreditAbility(int rates) {
		return rates*0.3*this.monthlyPension;
	}
	
	public int getMaxAllowedRates() {
		return 24;
	}
}
