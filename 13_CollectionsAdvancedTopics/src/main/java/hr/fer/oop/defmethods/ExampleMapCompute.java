package hr.fer.oop.defmethods;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ExampleMapCompute {

    public static Map<String, Integer> createMap() {
        Map<String, Integer> grades = new HashMap<>();

        grades.put("Ante", 3);
        grades.put("Ivana", 5);
        grades.put("Jasna", 4);

        return grades;
    }

    public static void main(String[] args) {
        Map<String, Integer> grades = createMap();

        Integer newGrade = grades.compute("Ante", new BiFunction<String, Integer, Integer>() {
            @Override
            public Integer apply(String key, Integer value) {
                return value == null ? 1 : value + 1;
            }
        });
        System.out.println("Now Ante has grade: " + newGrade);

        Integer newGrade2 = grades.compute("Ante", (key, value) -> value == null ? 1 : value + 1);
        System.out.println("Now Ante has grade: " + newGrade2);
        
        //Obrisati Antu
        System.out.println("Map has Ante: " + grades.containsKey("Ante"));
        Integer newGrade3 = grades.compute("Ante", (key, value) -> null);
        System.out.println("Map has Ante: " + grades.containsKey("Ante"));
    }
}
