package hr.fer.oop.exceptions.example3;

public class Main {

	public static void main(String[] args) {
		String[] arr = new String[]{ "12", "15", "abc"};			
		for(int i=0; i<4; i++){
			try{
				int num = Integer.parseInt(arr[i]);
				System.out.println(num);
			}
			catch(NumberFormatException exc){
				System.err.println(exc);
			}
			catch(ArrayIndexOutOfBoundsException exc){
				System.err.println(exc);
			}
		}
		System.out.println("Done");
	}
}
