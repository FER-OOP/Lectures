package hr.fer.oop.recapitulation.container_transport;

public class Container extends VolumeLimitedCargoHolder implements Cargo {

    private final double volume;
    private final int id;

    public Container(double weight, double volume, double maxVolume, int id) {
        super(weight, maxVolume);
        this.volume = volume;
        this.id = id;
    }

    @Override
    public double getVolume() {
        return volume;
    }         

    @Override
    public int getId() {
        return this.id;
    } 
}
