package hr.fer.oop.homework_11.e2;

import java.util.ArrayList;
import java.util.List;

public class Airplane {
    private String name;  
    private int currentSpeed;
    private List<Cargo> cargo = new ArrayList<>();
    private String from, to;

    public Airplane(String name) {
        this.name = name;
        this.currentSpeed = 0;
    }  
    public void addCargo(Cargo c) {
    	cargo.add(c);
    }
    private void increaseSpeed(int increment) { 
    	currentSpeed += increment; 
    }
 
	public class Captain /*extends Thread*/{
        private String name;

        public Captain(String name) {
				this.name = name;
		}

		public void sayWelcomeAndPilot(String from, String to){  
			Airplane.this.from = from;
			Airplane.this.to = to;
			for(Cargo c: cargo) c.checkCargo();
			increaseSpeed(200);
			System.out.format( "This is your captain %s speaking. %nThe %s plane on flight from %s " 
					+ "to %s is loaded with %d kg. %nEnjoy your flight. Currently, our speed is %d%n" 
					,/*this.*/name, Airplane.this.name, Airplane.this.from, Airplane.this.to, 
					getOverallCargoWeight(), currentSpeed);
			// Rijeka airport geo pos: 45.216944,14.570278
			// Venice airport geo pos: 45.503164654 12.351165262
	        flyAround(new Pair<>(45.216944, 14.570278), new Pair<>(45.503164654, 12.351165262));
        }
    }

    public static class Cargo {
        private String type;
        private int weight;

        public Cargo(String type, int weight) {
            this.type = type;
            this.weight = weight;
        }

        private void checkCargo() {  
        	System.out.println(type + ", " + weight + " kg, checked." );
        }
    
    }

    private int getOverallCargoWeight() {
    	int sum = 0;
    	for(Cargo c: cargo) 
    		sum += c.weight;	
    	return sum;
    }
   
    @SafeVarargs
	private void flyAround(Pair<Double, Double>... airportsCoord){   // first = lat, second = long
    	final class Distance {
    		private final double distance; // in km
    		public Distance(Pair<Double, Double> airport1, Pair<Double, Double> airport2) {
    			// haversine formula
    			double dlon = Math.toRadians(airport2.getSecond()) - Math.toRadians(airport1.getSecond());
    			double dlat = Math.toRadians(airport2.getFirst()) - Math.toRadians(airport1.getFirst());
    			double a = Math.pow(Math.sin(dlat / 2), 2)
    					+ Math.cos(Math.toRadians(airport1.getFirst())) * Math.cos(Math.toRadians(airport2.getFirst()))
    					* Math.pow(Math.sin(dlon / 2),2);
    				
    			double c = 2 * Math.asin(Math.sqrt(a));
    			double r = 6371; 
    			distance = c * r;
    		}
			public double getDistance() { 
				return distance;
			}
    	}
    	if(airportsCoord.length < 2) throw new IllegalArgumentException();
    	double endDestinationDistance = 0.;
    	for(int i = 0; i<airportsCoord.length-1; i++) {
    		endDestinationDistance += new Distance(airportsCoord[i], airportsCoord[i+1]).getDistance(); 
    	}
        System.out.format("We have approx %7.2f km to our end destination.", endDestinationDistance); 	
    }
    
}
