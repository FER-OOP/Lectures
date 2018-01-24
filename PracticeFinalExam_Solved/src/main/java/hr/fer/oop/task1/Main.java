package hr.fer.oop.task1;

import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Set<Driver> drivers = DBLoader.loadDrivers();

        drivers.stream()
                .filter((d) -> d.getAddress().contains("Zagreb"))
                .sorted((d1, d2) -> Long.compare(d1.getPid(), d2.getPid()))
                .forEach(d -> System.out.println(d));
        
        Set<Long> oibs = drivers.stream()
                .filter((d) -> d.getSurName().startsWith("M"))
                .map((d) -> d.getPid())
                .collect(Collectors.toSet());
        
        //print oibs
        oibs.forEach(o -> System.out.println(o));
        
        drivers.stream()
                .mapToInt(d -> d.getFirstName().length())
                .average()
                .ifPresent(avg -> System.out.println(avg));
    }
}
