package hr.fer.oop.recapitulation.container_transport;

public abstract class WeightLimitedCargoHolder extends CargoHolder {

    private final double maxCargoWeight;

    public WeightLimitedCargoHolder(double weight, double maxCargoWeight) {
        super(weight);
        this.maxCargoWeight = maxCargoWeight;
    }

    public double getMaxCargoWeight() {
        return maxCargoWeight;
    }    
    
    @Override
    public boolean add(Cargo cargo) {
        if (cargo.getWeight() + this.getCargoWeight() <= maxCargoWeight) {
            return super.add(cargo);
        }

        return false;
    }
}
