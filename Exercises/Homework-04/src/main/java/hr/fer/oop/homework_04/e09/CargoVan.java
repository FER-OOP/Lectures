package hr.fer.oop.homework_04.e09;

public class CargoVan extends Van {

	private double maxLoad;

	public CargoVan(String regNo, String model, int year, double price, double height, short noOfSeats, double maxLoad) {
		super(regNo, model, year, price, height, noOfSeats);
		this.maxLoad = maxLoad;
	}

	public double getMaxLoad() {
		return maxLoad;
	}

	public void setMaxLoad(double maxLoad) {
		this.maxLoad = maxLoad;
	}
	
}
