package hr.fer.oop.practice.generics;

public class RoomDoubleNodeCreator  extends RoomNodeCreator<Double> {
	
	public RoomDoubleNodeCreator(String description) {
		super(description);
	}
	@Override
	protected String getTemperatureNode() {
		return "Temperature";
	}
	@Override
	protected String getHumidityNode() {
		return "Humidity";
	}
}