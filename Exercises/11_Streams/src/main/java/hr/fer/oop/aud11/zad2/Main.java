package hr.fer.oop.aud11.zad2;

import hr.fer.oop.aud11.zad1.Loader;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

public class Main {

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> gradesMap = Loader.loadData();

        System.out.println(getAverageCourseGrades(gradesMap));
        System.out.println(getAverageStudentGrades(gradesMap));
    }

    private static Map<String, Double> getAverageCourseGrades(Map<String, Map<String, Integer>> gradesMap) {

        return gradesMap.entrySet().stream()
                .map(courseNameGradeMap -> new SimpleEntry<>(courseNameGradeMap.getKey(),
                courseNameGradeMap.getValue().values().stream().mapToInt(Integer::intValue).average().getAsDouble())).
                collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
    }

    private static Map<String, Double> getAverageStudentGrades(Map<String, Map<String, Integer>> gradesMap) {
        Map<String, List<Integer>> nameGradesMap = new HashMap<>();

        gradesMap.values().stream()
                .flatMap(nameGradeMap -> nameGradeMap.entrySet().stream())
                .forEach(nameGradePair -> nameGradesMap.merge(nameGradePair.getKey(), new LinkedList<>(Arrays.asList(nameGradePair.getValue())),
                (oldGradeList, passedGradeList) -> {
                    oldGradeList.addAll(passedGradeList);//faster than passedGradeList.addAll(oldGradeList)
                    return oldGradeList;
                }));

        return nameGradesMap.entrySet().stream().
                map(nameGradeList -> new SimpleEntry<>(nameGradeList.getKey(),
                nameGradeList.getValue().stream().mapToInt(Integer::intValue).average().getAsDouble()))
                .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
    }

//    private static Map<String, Double> getAverageStudentGrades(Map<String, Map<String, Integer>> gradesMap) {
//        return gradesMap.values().stream()
//                .flatMap(studentGradeMap -> studentGradeMap.entrySet().stream())
//                .collect(groupingBy(Map.Entry::getKey, averagingDouble(Map.Entry::getValue)));
//    }
}
