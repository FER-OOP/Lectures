package hr.fer.oop.lambda.example2;

import java.util.function.Predicate;

import hr.fer.oop.lambda.Car;
import hr.fer.oop.lambda.CarType;

public class DieselCarPredicate implements Predicate<Car> {
	@Override
	public boolean test(Car car) {
		return car.getType() == CarType.DIESEL;
	}

}
