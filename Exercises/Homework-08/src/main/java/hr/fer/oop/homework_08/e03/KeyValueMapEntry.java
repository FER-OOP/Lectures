package hr.fer.oop.homework_08.e03;

import java.util.Map;

public class KeyValueMapEntry<K, V> implements Map.Entry<K, V>{
	
	private K key;
	private V value;	

	public KeyValueMapEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public V setValue(V value) {
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}

	@Override
	public String toString() {
		return "KeyValueParameterized [key=" + key + ", value=" + value + "]";
	}
	
	

}
