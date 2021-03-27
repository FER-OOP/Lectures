package hr.fer.oop.homework_05.e07;

public class Main {

	public static void main(String[] args) {
		
		//Vehicle v = new Vehicle("DA1234AA", "Renault Clio");
		Vehicle car = new Car("DA8818BB", "Renault Megane Grandtour", "caravan", 4, 800);
		PassengerVan van3 = new PassengerVan("DA6282EA", "IMV 1600", 212, 8);
		Limo limo = new Limo("DA2238AB", "Zastava 750 LE", 320, 4, false);

		PassengerVehicle[] passengerVehicles = new PassengerVehicle[] {limo, (PassengerVehicle) car, van3}; //Zašto cast na car?
		
		for (PassengerVehicle pv : passengerVehicles) {
			System.out.println(pv);
			if (pv instanceof CargoVehicle) {
				System.out.println(" - this passenger vehicle can also transport cargo!");
				System.out.println("   max cargo space: " + ((CargoVehicle)pv).getMaxSpace());
			}
		}
		
	}

}
