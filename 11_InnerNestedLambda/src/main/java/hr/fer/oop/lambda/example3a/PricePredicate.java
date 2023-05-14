package hr.fer.oop.lambda.example3a;
import java.util.function.Predicate;

import hr.fer.oop.lambda.Car;

public class PricePredicate implements Predicate<Car> {
	private int maxPrice;
	
	public PricePredicate(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	@Override
	public boolean test(Car car) {
		return car.getPrice() < maxPrice;
	}	
}
