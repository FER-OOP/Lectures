package hr.fer.oop.practice.generics;

public class RoomFloatNodeCreator extends RoomNodeCreator<Float> {
	
	public RoomFloatNodeCreator(String description) {
		super(description);
	}
	@Override
	protected String getTemperatureNode() {
		return "Temp";
	}
	@Override
	protected String getHumidityNode() {
		return "Hum";
	}
}
