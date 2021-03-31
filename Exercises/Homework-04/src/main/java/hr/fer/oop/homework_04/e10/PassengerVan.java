package hr.fer.oop.homework_04.e10;

public class PassengerVan extends Van {

	private int noOfPassengers;

	public PassengerVan(String regNo, String model, int year, double price, int height, short noOfSeats, int noOfPassengers) {
		super(regNo, model, year, price, height, noOfSeats);
		this.noOfPassengers = noOfPassengers;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	
	@Override
	public double getPricePerDay() {
		return super.getPricePerDay() * 0.8;
	}
	
}
