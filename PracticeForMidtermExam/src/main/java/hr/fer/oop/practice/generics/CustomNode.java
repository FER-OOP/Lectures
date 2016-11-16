package hr.fer.oop.practice.generics;

public class CustomNode<T> implements Node {
	private String nodeId;
	private String description;
	//TO DO: Add appropriate variable for storing node value

	public CustomNode(String id, String description) {
		this.nodeId = id;
		this.description = description;
	}

	@Override
	public String getId() {
		return nodeId;
	}

	@Override
	public String getDescription() {
		return description;
	}

	//TO DO: finish getValue and setValue

}
