package hr.fer.oop.defmethods;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ExampleMapMerge {

    public static Map<String, Integer> createMap() {
        Map<String, Integer> grades = new HashMap<>();

        grades.put("Ante", 3);
        grades.put("Ivana", 5);
        grades.put("Jasna", 4);

        return grades;
    }

    public static void main(String[] args) {
        Map<String, Integer> grades = createMap();

        // Slično kao compute - drugi parametar predstavlja novu vrijednost ako stara ne postoji
        grades.merge("Ante", 1, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer oldValue, Integer value) {
                return oldValue + value;
            }
        });

        grades.merge("Ante", 1, (oldValue, value) -> oldValue + value);

        System.out.println(grades);
    }

}
