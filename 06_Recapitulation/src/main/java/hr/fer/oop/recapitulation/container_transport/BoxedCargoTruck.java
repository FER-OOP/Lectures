package hr.fer.oop.recapitulation.container_transport;

public class BoxedCargoTruck extends WeightLimitedCargoHolder {
    
    public BoxedCargoTruck(double weight, double maxCargoWeight) {
        super(weight, maxCargoWeight);
    }   

    @Override
    public boolean add(Cargo cargo) {
        if (!(cargo instanceof BoxedCargo)) {
            return false;
        }
        
        return super.add(cargo);        
    }

    @Override
    public boolean remove(Cargo cargo) {
        if (!(cargo instanceof BoxedCargo)) {
            return false;
        }
        
        return super.remove(cargo);
    }         
}
