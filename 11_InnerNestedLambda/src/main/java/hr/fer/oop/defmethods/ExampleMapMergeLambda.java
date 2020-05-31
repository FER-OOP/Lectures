package hr.fer.oop.defmethods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hr.fer.oop.lambda.Car;
import hr.fer.oop.lambda.CarCatalog;
import hr.fer.oop.lambda.CarType;

public class ExampleMapMergeLambda {

    
	public static void main(String[] args) {
		Map<CarType, Integer> carTypesCount = new HashMap<>();
		List<Car> cars = CarCatalog.loadCars();

		cars.forEach(car -> carTypesCount.merge(car.getType(), 1, (oldValue, value) -> oldValue + value));
		System.out.println(carTypesCount);
	}

}
