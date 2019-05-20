package hr.fer.oop.defmethods;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class ExampleMapForEach {

    public static Map<String, Integer> createMap() {
        Map<String, Integer> grades = new HashMap<>();

        grades.put("Ante", 3);
        grades.put("Ivana", 5);
        grades.put("Jasna", 4);

        return grades;
    }

    public static void main(String[] args) {
        Map<String, Integer> grades = createMap();

        //classic way
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.format("%s => %d%n", entry.getKey(), entry.getValue());
        }
        System.out.println();

        //forEach and anonymous class
        grades.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String key, Integer value) {
                System.out.format("%s => %d%n", key, value);
            }
        });
        System.out.println();

        //forEach and lambda expression
        grades.forEach((key, value) -> System.out.format("%s => %d%n", key, value));
        System.out.println();
    }
}
