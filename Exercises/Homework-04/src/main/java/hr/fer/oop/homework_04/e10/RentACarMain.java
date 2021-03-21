package hr.fer.oop.homework_04.e10;

public class RentACarMain {

	public static void main(String[] args) {
		
		Vehicle v = new Car("DA1234AA", "Renault Clio", 2001, 20, "coupe", 200);
		Car car = new Car("DA8818BB", "Renault Megane Grandtour", 2007, 25, "caravan",800);
		Van van1 = new CargoVan("DA0009PO", "Volkswagen Transporter", 2018, 28, 2, (short)3, 4500);
		PassengerVan van2 = new PassengerVan("DA6282EA", "IMV 1600", 1978, 35, 2, (short)3, 0);
		Vehicle limo = new Limo("DA2238AB", "Zastava 750 LE", 1983, 220, 3.2, false, false);
		
		System.out.println(v.getModel() + " price per day: " + v.getPricePerDay());
		System.out.println(van1.getModel() + " price per day: " + van1.getPricePerDay());
		System.out.println(van2.getModel() + " price per month: " + van2.getPricePerMonth());
		
		Vehicle newest = Vehicle.getNewestVehicle(v, car, van1, van2, limo);
		System.out.println("Newest: " + newest.getModel() + ", " + newest.getYear());
		
		Vehicle.printAllVehiclesWithCargoSpaceGreaterThan(500, v, car, van1, van2, limo);

	}

}
