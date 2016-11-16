package hr.fer.oop.practice.generics;

public class CustomNode<T> implements Node {
	private String nodeId;
	private String description;
	
	private T value;

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
	
	@Override
	public T getValue() {
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setValue(Object value) {
		this.value = (T) value;
	}

}
