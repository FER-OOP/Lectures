package hr.fer.oop.defmethods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import hr.fer.oop.lambda.Car;
import hr.fer.oop.lambda.CarCatalog;
import hr.fer.oop.lambda.CarType;

public class ExampleMapMerge {

    
    public static void main(String[] args) {
    	 Map<CarType, Integer> carTypesCount = new HashMap<>();
         List<Car> cars = CarCatalog.loadCars();
            
         //using anonymous classes
         cars.forEach(new Consumer<Car> () {

			@Override
			public void accept(Car car) {
				// Similar to compute - the second parameter is used for new values if the old one does not exists
		        carTypesCount.merge(car.getType(), 1, new BiFunction<Integer, Integer, Integer>() {
		            @Override
		            public Integer apply(Integer oldValue, Integer value) {		            	
		                return oldValue + value;
		            }
		        });				
			}        	 
         });
         
         System.out.println(carTypesCount);                
    }

}
