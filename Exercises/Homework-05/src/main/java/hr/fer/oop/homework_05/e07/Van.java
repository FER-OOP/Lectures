package hr.fer.oop.homework_05.e07;

public abstract class Van extends Vehicle {

	private double height;

	public Van(String registrationNo, String model, double height) {
		super(registrationNo, model);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return super.toString() + ", height=" + height;
	}
	
}
