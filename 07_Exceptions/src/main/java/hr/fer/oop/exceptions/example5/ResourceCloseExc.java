package hr.fer.oop.exceptions.example5;

public class ResourceCloseExc implements AutoCloseable {
	private int i;
	public ResourceCloseExc(int n){
		System.out.println("Creating #" + n);
		i = n;
	}
	@Override
	public void close()  {
		System.out.println("Closing and throwing exception #" + i);	
		throw new RuntimeException("Proba"); 
	}

}
