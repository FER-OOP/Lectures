package hr.fer.oop.lambda.example5;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import hr.fer.oop.lambda.Car;
import hr.fer.oop.lambda.CarCatalog;
import hr.fer.oop.lambda.CarType;


public class Main {

	public static void main(String[] args) {
		List<Car> cars = CarCatalog.loadCars();
		printCars(cars, 
				(car) -> car.getPrice() < 100000,
				(car) -> System.out.println("Cheap car: " + car)
		);
		printCars(cars, 
				(car) -> car.getType() == CarType.DIESEL,
				(car) -> System.out.println("Diesel car: " + car)
		);
	}	
	
	private static void printCars(Iterable<Car> cars, Predicate<Car> predicate, Consumer<Car> action) {
		for(Car car : cars){
			if (predicate.test(car)){
				action.accept(car);
			}
		}		
	}
}