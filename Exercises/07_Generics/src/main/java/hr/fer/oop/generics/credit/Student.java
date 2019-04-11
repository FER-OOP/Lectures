package hr.fer.oop.generics.credit;

public class Student extends Client {
	private double motherSalary,fatherSalary;
	public Student(String name,double motherSalary,double fatherSalary) {
		super.name=name;
		this.motherSalary=motherSalary;
		this.fatherSalary=fatherSalary;
	}
	
	public double getCreditAbility(int rates) {
		return rates*0.05*(this.motherSalary+this.fatherSalary);
	}
	
	public int getMaxAllowedRates() {
		return 48;
	}
}
