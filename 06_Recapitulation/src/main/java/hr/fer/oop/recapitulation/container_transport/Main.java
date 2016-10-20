package hr.fer.oop.recapitulation.container_transport;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class Main {
    public static void main(String[] args) {
        Cargo boxedCargo1 = new BoxedCargo(32.5, 56.7, 0);
        Cargo boxedCargo2 = new BoxedCargo(18.9, 23.5, 1);
        
        Container container = new Container(10, 100, 80, 3);
        System.out.println(container.add(boxedCargo1));//true
        System.out.println(container.add(boxedCargo2));//false
        
        System.out.println(container.remove(boxedCargo2));//false
        System.out.println(container.remove(boxedCargo1));//true
        
        CargoHolder truck = new BoxedCargoTruck(8.2, 60);
        System.out.println(truck.add(boxedCargo1));//true
        System.out.println(truck.add(boxedCargo2));//true
        
        CargoHolder ship = new ContainerShip(120.3, 567.2, 60);
        System.out.println(ship.add(container));//true
        System.out.println(ship.remove(container));//true
        
        System.out.println(truck.add(container));//false
        System.out.println(ship.add(boxedCargo2));//false
    }
}
