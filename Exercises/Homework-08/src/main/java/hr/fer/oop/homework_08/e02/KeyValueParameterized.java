package hr.fer.oop.homework_08.e02;


public class KeyValueParameterized<K, V>{
	
	private K key;
	private V value;	

	public KeyValueParameterized(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "KeyValueParameterized [key=" + key + ", value=" + value + "]";
	}
	
	

}
