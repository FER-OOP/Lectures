package hr.fer.oop.zad3;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        List<Person> persons = Loader.loadPerson();
        List<Bicycle> bicycles = Loader.loadBicycle();
     
        //it seems that commented lines work with wrongly implemented natural order
//        Collections.sort(persons);
//        for(Person person:persons) {
//            System.out.println(person.toString());
//        }

        Set<Person> sortedPersons = new TreeSet<>(persons);
        for (Person person : sortedPersons) {
            System.out.println(person.toString());
        }
        System.out.println();

        //the commented line is wrong as it isn't consistent with equals  
        //Set<Bicycle> sortedBicycles = new TreeSet<>(Bicycle.BY_BRAND.thenComparing(Bicycle.BY_OWNER.reversed()));
        
        Set<Bicycle> sortedBicycles = new TreeSet<>(Bicycle.BY_BRAND.thenComparing(Bicycle.BY_OWNER.reversed()).thenComparing(Bicycle.BY_PRICE));
        
        sortedBicycles.addAll(bicycles);

        for (Bicycle elem : sortedBicycles) {
            System.out.println(elem.toString());
        }
        System.out.println();

    }

}
