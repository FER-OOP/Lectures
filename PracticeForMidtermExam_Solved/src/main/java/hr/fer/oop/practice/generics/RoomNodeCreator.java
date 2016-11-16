package hr.fer.oop.practice.generics;

import java.util.ArrayList;
import java.util.List;

public abstract class RoomNodeCreator<T extends Number> implements NodeCreator<RoomData>{
	protected abstract String getTemperatureNode();
	protected abstract String getHumidityNode();
	private final String description;
	
	public RoomNodeCreator(String description){
		this.description = description;
	}
	
	public final String getDescription(){
		return description;
	}
	
	@Override
	public List<Node> getNodes() {
		List<Node> list = new ArrayList<>(2);
		list.add(new CustomNode<T>(getTemperatureNode(), "Temperature node"));
		list.add(new CustomNode<T>(getHumidityNode(), "Humidity node"));
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public RoomData parseResult(List<Node> nodes) {
		RoomData data = new RoomData();
		CustomNode<T> tempNode = (CustomNode<T>) nodes.get(0);
		data.setTemperature(tempNode.getValue().intValue());
		CustomNode<T> humNode = (CustomNode<T>) nodes.get(1);
		data.setHumidity(humNode.getValue().intValue());
		return data;
	}
}