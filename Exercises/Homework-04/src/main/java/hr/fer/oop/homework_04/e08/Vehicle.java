package hr.fer.oop.homework_04.e08;

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
	
}
