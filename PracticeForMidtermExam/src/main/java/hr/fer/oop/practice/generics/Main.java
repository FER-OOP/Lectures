package hr.fer.oop.practice.generics;


public class Main {

	public static void main(String[] args) {
		NodeCreator<RoomData> creator = new RoomDoubleNodeCreator("DoubleNodeCreator");
				
		Communicator communicator = new Communicator("D");
		RoomData data = communicator.readNodes(creator);
		System.out.format("Temperature: %d - Humidity %d %n", 
				data.getTemperature(), data.getHumidity() 
		);
						
		communicator = new Communicator("F");
		creator = new RoomFloatNodeCreator("DoubleFloatCreator");
		data = communicator.readNodes(creator);
		System.out.format("Temperature: %d - Humidity %d %n", 
				data.getTemperature(), data.getHumidity() 
		);
	}
}
