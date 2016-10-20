package hr.fer.oop.recapitulation.container_transport;

public abstract class VolumeLimitedCargoHolder extends CargoHolder {

    private final double maxCargoVolume;

    public VolumeLimitedCargoHolder(double weight, double maxCargoVolume) {
        super(weight);
        this.maxCargoVolume = maxCargoVolume;
    }

    public double getMaxCargoVolume() {
        return maxCargoVolume;
    }

    @Override
    public boolean add(Cargo cargo) {
        if (cargo.getVolume() + this.getCargoVolume() <= maxCargoVolume) {
            return super.add(cargo);
        }

        return false;
    }
}
