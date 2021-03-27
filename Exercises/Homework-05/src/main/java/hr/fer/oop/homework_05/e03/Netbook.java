package hr.fer.oop.homework_05.e03;

import hr.fer.oop.homework_05.e02.Laptop;

public final class Netbook extends Laptop {

	public Netbook(String model, String manufacturer, String operatingSystem, int batteryCapacity, double weight) {
		super(model, manufacturer, operatingSystem, batteryCapacity, weight);
	}
	
	@Override
	public String getComputerType() {
		return "netbook " + super.getComputerType();
	}

	@Override
	public int calculatePortabilityScore() {
		return 1;
	}

}
