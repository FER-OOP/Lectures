package hr.fer.oop.practice.generics;

public class FakeServer {
	private String server;
	public FakeServer(String server){
		this.server = server;
	}
	public Object getValue(String key){
		//few hard coded values just to demonstrate the example
		if (server.equals("F") && key.equals("Temp")){
			return Float.valueOf(21.5f);
		}
		else if (server.equals("F") && key.equals("Hum")){
			return Float.valueOf(32f);
		}
		else if (server.equals("D") && key.equals("Temperature")){
			return Double.valueOf(13.1);
		}
		else if (server.equals("D") && key.equals("Humidity")){
			return Double.valueOf(71.8);
		}
		else
			return null;
	}

}
