package hr.fer.oop.task1;

import java.util.HashSet;
import java.util.Set;

public class DBLoader {   
    public static Set<Driver> loadDrivers() {

        Set<Driver> drivers = new HashSet<>();

        drivers.add(new Driver("Ivana", "Ivanković", "Unska 1, 10000 Zagreb, Hrvatska", 34219825481L));
        drivers.add(new Driver("Zoran", "Zorić", "Duga ulica 17, 32100 Vinkovci, Hrvatska", 7463984731L));
        drivers.add(new Driver("Marko", "Markić", "Vodovodna, 51000 Rijeka, Hrvatska", 47384529473L));
        drivers.add(new Driver("Pero", "Perić", "Nova cesta 16, 10000 Zagreb, Hrvatska", 84273632443L));
        drivers.add(new Driver("Franjo", "Franjić", "Zagrebačka cesta 34, 10000 Zagreb, Hrvatska", 53832832823L));
        drivers.add(new Driver("Mijo", "Mijić", "Županijska 10, 32000 Vukovar, Hrvatska", 53832832823L));
        
        return drivers;
    }
}
