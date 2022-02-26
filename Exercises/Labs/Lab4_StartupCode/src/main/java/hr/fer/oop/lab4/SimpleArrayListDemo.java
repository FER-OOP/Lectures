package hr.fer.oop.lab4;

public class SimpleArrayListDemo {

	public static void main(String[] args) {
		
		SimpleArrayList<String> stringList = new SimpleArrayList<>();
		SimpleArrayList<Integer> integerList = new SimpleArrayList<>();
		SimpleArrayList<Double> doubleList = new SimpleArrayList<>();
				
		stringList.add("A");		
		stringList.set(1, "B");
		try {
			stringList.set(3, "C");
		}
		catch(OutOfRangeException exc) {
			System.out.println(exc.getMessage());
		}
		stringList.insertAt(0, "D");						
		stringList.add("F");
		stringList.add("E");
		stringList.add("R");
		stringList.removeAt(3);
		try {
			stringList.removeAt(6);
		}
		catch(OutOfRangeException exc) {
			System.out.println(exc.getMessage());
		}
		stringList.set(3, "A");		
					
		for(int i = 0; i<stringList.size(); i++){
			System.out.print(stringList.get(i) + " ");
		}
		
		System.out.println();
		System.out.println("Searching for R: " + stringList.indexOf("R"));
		
		integerList.add(1);
		integerList.add(2);
		integerList.add(5);
		integerList.add(10);
		System.out.println(average(integerList));
		
		doubleList.add(3.2);
		doubleList.add(4.3);
		doubleList.add(5.5);
		doubleList.add(10.0);
		System.out.println(average(doubleList));
		
	}	
}
