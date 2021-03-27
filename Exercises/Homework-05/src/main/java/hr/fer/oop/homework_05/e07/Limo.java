package hr.fer.oop.homework_05.e07;

public class Limo extends Vehicle implements PassengerVehicle {
	
	private double length;
	private int noOfSeats;
	private boolean sunRoof;
	
	public Limo(String registrationNo, String model, double length, int noOfSeats, boolean sunRoof) {
		super(registrationNo, model);
		this.length = length;
		this.noOfSeats = noOfSeats;
		this.sunRoof = sunRoof;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public boolean isSunRoof() {
		return sunRoof;
	}

	public void setSunRoof(boolean sunRoof) {
		this.sunRoof = sunRoof;
	}

	@Override
	public String toString() {
		return super.toString() + ", length=" + length + ", noOfSeats=" + noOfSeats + ", sunRoof=" + sunRoof;
	}

	@Override
	public double getMaxPassengers() {
		return this.noOfSeats;
	}
	
}
