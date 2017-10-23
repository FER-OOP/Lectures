package hr.fer.oop.exceptions.example5;

public class Main {

	public static void main(String[] args) {
		try(Resource r1 = new Resource(1); Resource r2 = new Resource(2)){
			 int a = 5, b = 0;
			 a = a / b;
		} 
		catch (Exception e) {			
			e.printStackTrace();
		}		
	}	
}
