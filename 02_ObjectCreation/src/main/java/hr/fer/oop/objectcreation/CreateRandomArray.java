package hr.fer.oop.objectcreation;

public class CreateRandomArray {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Program requires one argument (array size)");
			System.exit(1);
		}
		int n = Integer.parseInt(args[0]);
		if (n < 1) {
			System.out.println("Array size must be a positive number");
			System.exit(2);
		}
		
		double[] arr = create(n); 
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%.4f ", arr[i]);
		}						
		System.out.println();
		
		// meaning of operator =  
		double[] another = arr; //what happens here?		
		another[0] = 2.5;		
		System.out.printf("#1 = %.4f %.4f %n", arr[0], another[0]);
		
		another = arr.clone(); //what happens here?		
		another[0] = 7.5;		
		System.out.printf("#2 = %.4f %.4f %n", arr[0], another[0]);
		
		int z = n;
		z = 42;		
		System.out.printf("#3 = %d %d %n", n, z);		
	}

	private static double[] create(int n) {
		double[] arr = new double[n];
		for(int i=0; i<n; i++) {
			arr[i] = Math.random();
		}
		return arr;
	}

}
