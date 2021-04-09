package hr.fer.oop.homework_08.e07;

import hr.fer.oop.homework_08.e03.KeyValueMapEntry;

public class Main {
	
	public static void main(String[] args) {
		
		CountableKeyValueMapEntry<String> c1 = new CountableKeyValueMapEntry<String>(1, "Dinamo");
		KeyValueMapEntry<Integer, String> c2 = new CountableKeyValueMapEntry<String>(1, "Zagreb");
		KeyValueMapEntry<Integer, String> c3 = new KeyValueMapEntry<Integer, String>(1, "Rijeka");
		
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		
	}

}
