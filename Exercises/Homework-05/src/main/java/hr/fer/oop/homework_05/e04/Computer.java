package hr.fer.oop.homework_05.e04;

public abstract class Computer extends Device {


	private String operatingSystem;
	
	public Computer(String model, String manufacturer, String operatingSystem) {
		super(model, manufacturer);
		this.operatingSystem = operatingSystem;
	}
	
	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", operatingSystem=" + operatingSystem;
	}
	
	public abstract String getComputerType(); 
	
	public abstract int calculatePortabilityScore();
}