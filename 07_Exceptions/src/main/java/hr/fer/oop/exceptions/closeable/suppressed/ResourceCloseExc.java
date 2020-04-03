package hr.fer.oop.exceptions.closeable.suppressed;

public class ResourceCloseExc implements AutoCloseable {
	private int i;
	public ResourceCloseExc(int n){
		System.out.println("Creating #" + n);
		i = n;
	}
	@Override
	public void close()  {
		System.out.println("Closing and throwing exception #" + i);	
		throw new RuntimeException("Oh, exception in close..."); 
	}

}
