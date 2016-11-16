package hr.fer.oop.practice.generics;

public class Communicator {
	private FakeServer server;	
	
	public Communicator(String serverName){		
		this.server = new FakeServer(serverName);
	}
			
	public <T> T readNodes(NodeCreator<T> creator){
		//TO DO: Take nodes list from creator, 
		//read values from server
		//store values back in the list
		//and create T based on nodes and their values		
	}
}
