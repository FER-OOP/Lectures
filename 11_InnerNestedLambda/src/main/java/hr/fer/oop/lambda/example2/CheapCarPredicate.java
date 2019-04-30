package hr.fer.oop.lambda.example2;
import java.util.function.Predicate;

import hr.fer.oop.lambda.Car;

public class CheapCarPredicate implements Predicate<Car> {
	@Override
	public boolean test(Car car) {
		return car.getPrice() < 100000;
	}	
}
