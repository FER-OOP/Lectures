package hr.fer.oop.homework_08.e07;

import hr.fer.oop.homework_08.e03.KeyValueMapEntry;

public class Main {
	
	public static void main(String[] args) {
		
			
		CountableKeyValueMapEntry<String> c1 = new CountableKeyValueMapEntry<String>(1, "Dinamo");
		KeyValueMapEntry<Integer, String> c2 = new CountableKeyValueMapEntry<String>(9, "Varazdin");
		KeyValueMapEntry<Integer, String> c3 = new KeyValueMapEntry<Integer, String>(4, "Rijeka");	 
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		// e.g. output interpretation:
		
		
		// "KeyValueParameterized [key=1, value=Dinamo] id:0"
		// id:0 - c1 has the first CountableKeyValueMapEntry instance in our main method
		// key=1 - the club leads the Croatian First Football League
		// value - the club is Dinamo
		
		// "KeyValueParameterized [key=9, value=Varazdin] id:1"
		// id:1 - c2 has the second CountableKeyValueMapEntry instance in our main method
		// key=9 - the club is in the 9th position of the Croatian First Football League
		// value - the club is Varazdin
		
		// "KeyValueParameterized [key=4, value=Rijeka]" - note that we do not have "id:1" because we instantiated an object with "new KeyValueMapEntry", not "new CountableKeyValueMapEntry".
		// key=4 - the club is in the 4th position of the Croatian First Football League
		// value - the club is Rijeka
		
		
		
	}

}
