package hr.fer.oop.lambda.example6;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import hr.fer.oop.lambda.Car;
import hr.fer.oop.lambda.CarCatalog;

public class Main {

	public static void main(String[] args) {
		List<Car> cars = CarCatalog.loadCars();
		theMostSimilarCar(cars, 
				(a, b) -> (int) Math.abs(a.getPrice() - b.getPrice()),
				(a, b) -> System.out.format("The most similar are: %n\t%s%n\t%s%n", a, b)
		);		
	}
	
	public static void theMostSimilarCar(Iterable<Car> cars, BiFunction<Car, Car, Integer> distanceFunction, BiConsumer<Car, Car> action){			
					
		class CarPair{
			public Car first, second;
			public CarPair(Car first, Car second){
				this.first = first;
				this.second = second;
			}
		}
		
		CarPair pair = null;
		int min = Integer.MAX_VALUE;
		
		for(Car first : cars){
			for(Car second : cars){
				if (first == second) continue;
				int distance = distanceFunction.apply(first, second);
				if (pair == null || distance < min){
					pair = new CarPair(first, second);
					min = distance;
				}				
			}
		}
		
		if (pair != null){
			action.accept(pair.first,  pair.second);
		}
	
	}
}
