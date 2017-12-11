package hr.fer.oop.lambda;

public class Car {
	private String name;
	private int maxSpeed;
	private int power;//in horsepowers
	private double consumption;//consumption of fuel type units per 100km
	private double price;
	private CarType type;
	
	public Car(){}
	public Car(String name, CarType type, int maxSpeed, int power, double consumption, double price){
		this.name = name;
		this.type = type;
		this.maxSpeed = maxSpeed;
		this.power = power;
		this.consumption = consumption;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public double getConsumption() {
		return consumption;
	}
	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CarType getType() {
		return type;
	}
	public void setType(CarType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {		
		return String.format("%s %s %dKS, max speed: %d, %.2f/100km, %.2fKn",
				getName(), getType(),getPower(), getMaxSpeed(),
				getConsumption(), getPrice());

	}
}
