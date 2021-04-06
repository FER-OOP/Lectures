package hr.fer.oop.homework_08.e07;

import hr.fer.oop.homework_08.e03.KeyValueMapEntry;

public class CountableKeyValueMapEntry<K, V> extends KeyValueMapEntry<K, V> {
	
	private static int counter = 0;
	
	private int id; 

	public CountableKeyValueMapEntry(K key, V value) {
		super(key, value);
		id = counter++;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return super.toString()+ " id:"+id;
	}

}
