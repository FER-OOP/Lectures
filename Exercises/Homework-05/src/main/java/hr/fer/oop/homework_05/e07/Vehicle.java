package hr.fer.oop.homework_05.e07;

public abstract class Vehicle {

	private String registrationNo;
	private String model;
	
	public Vehicle(String registrationNo, String model) {
		this.registrationNo = registrationNo;
		this.model = model;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return registrationNo + ", " + model;
	}
	
}
