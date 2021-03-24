package hr.fer.oop.homework_04.e10;

public class Vehicle {

	private String regNo;
	private String model;
	private int year; 
	private double price;
	
	public Vehicle(String regNo, String model, int year, double price) {
		this.regNo = regNo;
		this.model = model;
		this.year = year;
		this.price = price;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Vehicle [regNo=" + regNo + ", model=" + model + ", year=" + year + ", price=" + price + "]";
	}
	
	public double getPricePerDay() {
		return price*24;
	}
	
	public final double getPricePerMonth() {
		return this.getPricePerDay()*30;
	}
	
	public static Vehicle getNewestVehicle(Vehicle...vehicles ) {
		if (vehicles.length==0)
			return null;
		
		Vehicle youngestVehicle = vehicles[0];
		for (Vehicle v : vehicles) {
			if (v.year > youngestVehicle.year)
				youngestVehicle = v;
		}
		
		return youngestVehicle;
		
	}
	
	public static void printAllVehiclesWithCargoSpaceGreaterThan(double cargoSize, Vehicle...vehicles) {
		System.out.println("Vehicles with cargo space greater than " + cargoSize + " liters:");
		for (Vehicle v: vehicles) {
			if (v instanceof Car)
				if (((Car)v).getCargoSpace() > cargoSize)
					System.out.println(" - " + v.getModel() + ": " + ((Car)v).getCargoSpace());
			if (v instanceof CargoVan)
				if (((CargoVan)v).getMaxLoad() > cargoSize)
					System.out.println(" - " + v.getModel() + ": " + ((CargoVan)v).getMaxLoad());		
		}
	}
	
}
