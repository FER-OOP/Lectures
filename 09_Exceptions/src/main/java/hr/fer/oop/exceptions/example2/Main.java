package hr.fer.oop.exceptions.example2;

public class Main {

	public static void main(String[] args) {
		String[] arr = new String[]{ "12", "15", "abc"};			
		for(int i=0; i<3; i++){
			try{
				int num = Integer.parseInt(arr[i]);
				System.out.println(num);
			}
			catch(NumberFormatException exc){
				System.err.println("Error: " + exc);
			}
		}
		System.out.println("Done");
	}
}
