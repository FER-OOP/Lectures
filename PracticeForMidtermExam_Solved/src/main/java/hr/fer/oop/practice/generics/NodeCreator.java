package hr.fer.oop.practice.generics;

import java.util.List;

public interface NodeCreator<T> {
	public List<Node> getNodes(); 
	public T parseResult(List<Node> nodes);
}
