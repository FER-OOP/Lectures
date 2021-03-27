package hr.fer.oop.homework_05.e07;

public class Car extends Vehicle  implements PassengerVehicle, CargoVehicle {
	
	private String carType;
	private int noOfSeats;
	private double cargoSpace;
	
	public Car(String registrationNo, String model, String carType, int noOfSeats, double cargoSpace) {
		super(registrationNo, model);
		this.carType = carType;
		this.noOfSeats = noOfSeats;
		this.cargoSpace = cargoSpace;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public double getCargoSpace() {
		return cargoSpace;
	}

	public void setCargoSpace(double cargoSpace) {
		this.cargoSpace = cargoSpace;
	}

	@Override
	public String toString() {
		return super.toString() + ", carType=" + carType + ", noOfSeats=" + noOfSeats + ", cargoSpace=" + cargoSpace;
	}

	@Override
	public double getMaxSpace() {
		return this.cargoSpace;
	}

	@Override
	public double getMaxPassengers() {
		return this.noOfSeats;
	}

}
