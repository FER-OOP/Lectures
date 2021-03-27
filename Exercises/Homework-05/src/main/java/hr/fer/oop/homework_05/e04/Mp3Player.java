package hr.fer.oop.homework_05.e04;

public class Mp3Player extends Device implements PortableDevice {

	private int batteryCapacity;
	private int memorySize;
	
	public Mp3Player(String model, String manufacturer, int batteryCapacity, int memorySize) {
		super(model, manufacturer);
		this.batteryCapacity = batteryCapacity;
		this.memorySize = memorySize;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public int getMemorySize() {
		return memorySize;
	}

	public void setMemorySize(int memorySize) {
		this.memorySize = memorySize;
	}

	@Override
	public String toString() {
		return "Mp3Player [batteryCapacity=" + batteryCapacity + ", memorySize=" + memorySize + "]";
	}
	
}
