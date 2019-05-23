package hr.fer.oop.zad3;

import java.util.Arrays;
import java.util.List;

public class Loader {
	
	public static List<Bicycle> loadBicycle(){ 
		List<Person> persons = Loader.loadPerson();
        List<Bicycle> bicycles = Arrays.asList(
               new Bicycle("345", "Pinarello", (float) 10.5, persons.get(0)),
               new Bicycle("556", "Scott", (float) 12, persons.get(1)),
               new Bicycle("879", "Rog", (float) 17.5, persons.get(2)),
               new Bicycle("621", "Merida", (float) 9.5, persons.get(3))
        );
        return bicycles;
	}

	public static List<Person> loadPerson() {
	       List<Person> persons = Arrays.asList(
	             new Person("QWE10975", "Ivan", "Horvat", 25, "Student"),
	             new Person("ASD11796", "Petra", "Pavlović", 17, "Učenik"),
	             new Person("YXC86327", "Sven", "Grgić", 67, "Umirovljenik"),
	             new Person("GHJ08548", "Jasna", "Brkić", 20, "Student")
	        );
	        return persons;
	    }
	}
