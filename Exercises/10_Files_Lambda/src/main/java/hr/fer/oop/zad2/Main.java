package hr.fer.oop.zad2;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Main {

	public static void main(String[] args) {
		List<Sweet> sweets = SweetCatalog.loadSweets();
		theMostDifferent(sweets,  	
				(a, b) -> (int) Math.abs(a.getSweetness()-b.getSweetness()),
				(a, b) -> {	a.setPrice(a.getPrice()+1); 
							b.setPrice(b.getPrice()+1);
							System.out.println("Price " + a.getName() + " = " + a.getPrice());
							System.out.println("Price "  + b.getName() +  " = " + b.getPrice());}
 			);		
	}

	public static void theMostDifferent(Iterable<Sweet> sweets, BiFunction<Sweet, Sweet, Integer> distanceFunction, BiConsumer<Sweet, Sweet> action) {
		
		class SweetPair {
			public Sweet first, second;
			public SweetPair(Sweet first, Sweet second) {
				this.first = first;
				this.second = second;
			}
		}
		
		SweetPair pair = null;
		int max = Integer.MIN_VALUE;
		
		for (Sweet first : sweets) {
			for (Sweet second : sweets) {
				if (first == second) continue;
				int distance = distanceFunction.apply(first, second);
				if (pair == null || distance > max) {
					pair = new SweetPair(first, second);
					max = distance;
				}
			}
		}
		if (pair != null) {
			action.accept(pair.first, pair.second);
		}
	}
}
