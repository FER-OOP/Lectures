package hr.fer.oop.lambda;

import java.util.ArrayList;
import java.util.List;

public class CarCatalog {
	public static List<Car> loadCars(){
		List<Car> list = new ArrayList<>();
		list.add(new Car("Fiat 500L 1.2 POP",CarType.PETROL, 150, 95, 6.2, 118575));
		list.add(new Car("Opel Astra Selection 1.4",CarType.PETROL, 180, 100, 5.5, 114091));
		list.add(new Car("Toyota Corolla",CarType.PETROL, 175, 90, 4.1, 114900));		
		list.add(new Car("Renault Clio 1.5dci",CarType.DIESEL, 160, 80, 4.5, 95000 ));
		list.add(new Car("Ford Mondeo", CarType.DIESEL, 200, 130, 6, 200000 ));
		list.add(new Car("Peugeot 308", CarType.PETROL, 160, 82, 5, 117285 ));
		list.add(new Car("Peugeot 308", CarType.DIESEL, 190, 100, 3.6, 144427 ));
		list.add(new Car("Renault Clio",CarType.PETROL, 150, 70, 4.5, 85000 ));
		return list;
	}
}
