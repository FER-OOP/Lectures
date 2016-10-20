package hr.fer.oop.recapitulation.container_transport;

public class BoxedCargo implements Cargo {

    private final double weight;
    private final double volume;
    private final int id;

    public BoxedCargo(double weight, double volume, int id) {
        this.weight = weight;
        this.volume = volume;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double getVolume() {
        return volume;
    }
}
