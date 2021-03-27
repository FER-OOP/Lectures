package hr.fer.oop.homework_05.e02;

public class Laptop extends Computer {

	private int batteryCapacity;
	private double weight;
	
	public Laptop(String model, String manufacturer, String operatingSystem, int batteryCapacity, double weight) {
		super(model, manufacturer, operatingSystem);
		this.batteryCapacity = batteryCapacity;
		this.weight = weight;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return super.toString() + ", batteryCapacity=" + batteryCapacity + ", weight=" + weight;
	}

	@Override
	public String getComputerType() {
		return "laptop computer";
	}

	@Override
	public int calculatePortabilityScore() {
		return (int)Math.round(weight);
	}
	
}