package hr.fer.oop.exceptions.example5;

public class Resource implements AutoCloseable {
	private int i;
	public Resource(int n){
		System.out.println("Creating #" + n);
		i = n;
	}
	@Override
	public void close()  {
		System.out.println("Closing #" + i);			
	}

}
