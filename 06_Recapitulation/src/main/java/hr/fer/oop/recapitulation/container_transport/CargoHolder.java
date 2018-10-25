package hr.fer.oop.recapitulation.container_transport;

import hr.fer.oop.recapitulation.mylist.MyList;

public abstract class CargoHolder {

    private final double weight;
    private final MyList content;

    public CargoHolder(double weight) {
        this.weight = weight;
        this.content = new MyList();
    }

    protected double getCargoWeight() {
        double cargoWeight = 0;
        for (int i = 0; i < content.size(); i++) {
            cargoWeight += ((Cargo) content.elementAt(i)).getWeight();
        }
        return cargoWeight;
    }

    protected double getCargoVolume() {
        double cargoVolume = 0;
        for (int i = 0; i < content.size(); i++) {
            cargoVolume += ((Cargo) content.elementAt(i)).getVolume();
        }
        return cargoVolume;
    }

    public double getWeight() {
        return this.weight + getCargoWeight();
    }
    
    protected int cargoCount() {
    	return content.size();
    }

    public boolean add(Cargo cargo) {
        content.addLast(cargo);
        return true;
    }

    public boolean remove(Cargo cargo) {
        for (int i = 0; i < content.size(); i++) {
            if (cargo.getId() == ((Cargo) content.elementAt(i)).getId()) {
                //cargo found
                content.removeAt(i);
                return true;
            }
        }
        return false;
    }
}
