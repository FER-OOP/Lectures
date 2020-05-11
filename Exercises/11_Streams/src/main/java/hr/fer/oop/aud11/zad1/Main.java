package hr.fer.oop.aud11.zad1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> gradesMap = Loader.loadData();

        System.out.println("Average grade: " + getAverageGrade(gradesMap));

        increaseGradesWithCompute(gradesMap, "arts");

        System.out.println("Average grade: " + getAverageGrade(gradesMap));
    }

    private static void increaseGradesWithCompute(Map<String, Map<String, Integer>> gradesMap, String course) {
        Map<String, Integer> gradesArt = gradesMap.get(course);
        for (String student : gradesArt.keySet()) {
            gradesArt.compute(student, (key, value) -> value < 5 ? value + 1 : value);
        }
    }

    private static double getAverageGrade(Map<String, Map<String, Integer>> gradesMap) {
        OptionalDouble averageGrade = gradesMap.entrySet().stream()
                .flatMap(courseGrades -> courseGrades.getValue().entrySet().stream())
                .mapToInt(studentGrade -> studentGrade.getValue())
                .average();

        return averageGrade.getAsDouble();
    }
}
