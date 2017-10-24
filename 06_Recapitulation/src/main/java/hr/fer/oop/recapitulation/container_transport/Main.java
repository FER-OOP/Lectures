package hr.fer.oop.recapitulation.container_transport;

public class Main {
    public static void main(String[] args) {
        Cargo boxedCargo1 = new BoxedCargo(32.5, 56.7, 0);
        Cargo boxedCargo2 = new BoxedCargo(18.9, 23.5, 1);
        
        Container container = new Container(10, 100, 80, 3);
        System.out.println(container.add(boxedCargo1));//true
        System.out.println(container.add(boxedCargo2));//false
        System.out.println(container.getWeight());//10 + 32.5 -> 42.5
        
        System.out.println(container.remove(boxedCargo2));//false
        System.out.println(container.remove(boxedCargo1));//true
        System.out.println(container.getWeight());//10
        
        CargoHolder truck = new BoxedCargoTruck(8.2, 60);
        System.out.println(truck.add(boxedCargo1));//true
        System.out.println(truck.add(boxedCargo2));//true
        System.out.println(truck.getWeight());//8.2 + 32.5 + 18.9 -> 59.6
        
        CargoHolder ship = new ContainerShip(120.3, 567.2, 60);
        System.out.println(ship.add(container));//true
        System.out.println(ship.remove(container));//true
        
        System.out.println(truck.add(container));//false
        System.out.println(ship.add(boxedCargo2));//false
    }
}
