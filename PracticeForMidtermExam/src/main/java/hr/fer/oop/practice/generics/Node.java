package hr.fer.oop.practice.generics;

public interface Node {	
	public String getDescription();		
	public String getId() ;	
	public abstract Object getValue();
	public abstract void setValue(Object value);
}
