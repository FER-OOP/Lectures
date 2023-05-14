package hr.fer.oop.lambda.example3a;

import java.util.List;
import java.util.function.Predicate;

import hr.fer.oop.lambda.Car;
import hr.fer.oop.lambda.CarCatalog;
import hr.fer.oop.lambda.CarType;


public class Main {

	public static void main(String[] args) {
		List<Car> cars = CarCatalog.loadCars();
		printCars(cars, new Predicate<Car>(){
			@Override
			public boolean test(Car car) {
				return car.getPrice() < 120000;
			}
		});
		
		System.out.println();
		
		printCars(cars, new PricePredicate(120000){
			int randomPower;
			{
				randomPower = 70 + (int) (Math.random() * 50);
				System.out.println("Random power: " + randomPower);
			}
			
			@Override
			public boolean test(Car car) {
				return super.test(car) && car.getPower() > randomPower;
			}
		});
	}
	
	private static void printCars(Iterable<Car> cars, Predicate<Car> predicate) {
		for(Car car : cars){
			if (predicate.test(car)){
				System.out.println(car);
			}
		}		
	}
}