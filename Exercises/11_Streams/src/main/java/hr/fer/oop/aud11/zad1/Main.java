package hr.fer.oop.aud11.zad1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> gradesMap = Loader.loadData();

        System.out.println("Average grade: " + getAverageGrade(gradesMap));

        increaseGrades(gradesMap, "arts");

        System.out.println("Average grade: " + getAverageGrade(gradesMap));
    }

    private static void increaseGrades(Map<String, Map<String, Integer>> gradesMap, String course) {
        Map<String, Integer> nameGradeMap = gradesMap.get(course);
        for (String name : nameGradeMap.keySet()) {
            nameGradeMap.compute(name, (key, value) -> value < 5 ? value + 1 : value);
        }
    }

    private static double getAverageGrade(Map<String, Map<String, Integer>> gradesMap) {
        OptionalDouble averageGrade = gradesMap.values().stream()
                .flatMap(nameGradeMap -> nameGradeMap.values().stream())
                .mapToInt(Integer::intValue)
                .average();

        return averageGrade.getAsDouble();
    }
}
