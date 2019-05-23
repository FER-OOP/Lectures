package hr.fer.oop.zad3;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) {
        List<Person> persons = Loader.loadPerson();
        List<Bicycle> bicycles = Loader.loadBicycle();

        Collections.sort(persons);
        for (Person person : persons) {
            System.out.println(person.toString());
        }
        System.out.println();
        
        Collections.sort(bicycles);
        for (Bicycle bicycle : bicycles) {
            System.out.println(bicycle.toString());
        }
        System.out.println();
        
        Set<Bicycle> bicyclesSort = new TreeSet<>(Bicycle.BY_BRAND.reversed().thenComparing(Bicycle.BY_OWNER));
        bicyclesSort.addAll(bicycles);

        for (Bicycle elem : bicyclesSort) {
            System.out.println(elem.toString());
        }
        System.out.println();

    }

}
