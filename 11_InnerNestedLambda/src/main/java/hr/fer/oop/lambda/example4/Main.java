package hr.fer.oop.lambda.example4;

import java.util.List;
import java.util.function.Predicate;

import hr.fer.oop.lambda.Car;
import hr.fer.oop.lambda.CarCatalog;
import hr.fer.oop.lambda.CarType;


public class Main {

	public static void main(String[] args) {
		List<Car> cars = CarCatalog.loadCars();
		printCars(cars, (car) -> {return car.getPrice() < 100000;});
		printCars(cars, (car) -> car.getType() == CarType.DIESEL);		
	}	
	
	private static void printCars(Iterable<Car> cars, Predicate<Car> predicate) {
		for(Car car : cars){
			if (predicate.test(car)){
				System.out.println(car);
			}
		}		
	}
}