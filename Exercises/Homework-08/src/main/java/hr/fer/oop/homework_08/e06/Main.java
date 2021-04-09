package hr.fer.oop.homework_08.e06;

import hr.fer.oop.homework_08.e03.KeyValueMapEntry;

public class Main {

	public static void main(String[] args) {
		
		KeyValueMapEntry<Integer, String> real = new KeyValueMapEntry<>(5, "Real Madrid");
		KeyValueMapEntry<Integer, String> dinamo = new KeyValueMapEntry<>(3, "Dinamo");
		//KeyValueMapEntry<Integer, Boolean> fake = new KeyValueMapEntry<>(1, false);
		//KeyValueMapEntry<Double, String> fake2 = new KeyValueMapEntry<>(1.0d, "Varazdin");
		System.out.println(calculateAverageKey(real, dinamo));//, fake, fake2));
		

	}
	
	public static <K extends Number, V> double calculateAverageKey(KeyValueMapEntry<K, V> ...entries ) {
		double sum = 0;
		int cnt = 0;
		for (KeyValueMapEntry<K, ?> entry : entries) {
			K key = entry.getKey();
			sum+= key.doubleValue();
			cnt++;
		}
		
		return sum/cnt;
	}

}