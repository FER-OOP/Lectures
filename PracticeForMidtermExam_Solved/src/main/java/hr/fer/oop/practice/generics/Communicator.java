package hr.fer.oop.practice.generics;

import java.util.List;

public class Communicator {
	private FakeServer server;	
	
	public Communicator(String serverName){		
		this.server = new FakeServer(serverName);
	}
			
	public <T> T readNodes(NodeCreator<T> creator){
		List<Node> nodes = creator.getNodes();
		for(Node node : nodes){
			Object value = server.getValue(node.getId());
			node.setValue(value);
		}
		T result = creator.parseResult(nodes);
		return result;		
	}
}
