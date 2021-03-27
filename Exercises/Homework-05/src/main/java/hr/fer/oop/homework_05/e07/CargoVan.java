package hr.fer.oop.homework_05.e07;

public class CargoVan extends Van implements CargoVehicle {
	
	private double maxSpace;

	public CargoVan(String registrationNo, String model, double height, double maxSpace) {
		super(registrationNo, model, height);
		this.maxSpace = maxSpace;
	}

	public double getMaxSpace() {
		return maxSpace;
	}

	public void setMaxSpace(double maxSpace) {
		this.maxSpace = maxSpace;
	}

	@Override
	public String toString() {
		return super.toString() + ", maxSpace=" + maxSpace;
	}
	
	

}
