package hr.fer.oop.homework_11.e2;

public class Main {

	public static void main(String[] args) {
		Airplane airplane = new Airplane("Croatia Airlines");
		Airplane.Captain captain = airplane.new Captain("Sully"); 
		Airplane.Cargo mail = new Airplane.Cargo("mail", 50);
		airplane.addCargo(mail);
        airplane.addCargo(new Airplane.Cargo("luggage", 500));  
        // ready to fly
		captain.sayWelcomeAndPilot("Rijeka", "Venice");
        
    }
}
