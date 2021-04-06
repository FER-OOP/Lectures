package hr.fer.oop.homework_08.e07;

import hr.fer.oop.homework_08.e03.KeyValueMapEntry;

public class Main {
	
	public static void main(String[] args) {
		
		CountableKeyValueMapEntry<Integer, String> c1 = new CountableKeyValueMapEntry<Integer, String>(1, "Dinamo");
		KeyValueMapEntry<Integer, String> c2 = new CountableKeyValueMapEntry<Integer, String>(1, "Zagreb");
		KeyValueMapEntry<Number, String> c3 = new CountableKeyValueMapEntry<Number, String>(1, "Varazdin");
		KeyValueMapEntry<Integer, String> c4 = new KeyValueMapEntry<Integer, String>(1, "Rijeka");
		
		// not allowed, the first parameter does not match (Number vs Integer, should be both Number or both Integer):
		//KeyValueMapEntry<Number, String> c5 = new CountableKeyValueMapEntry<Integer, String>(1, "Zagreb");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		
		
	}

}
