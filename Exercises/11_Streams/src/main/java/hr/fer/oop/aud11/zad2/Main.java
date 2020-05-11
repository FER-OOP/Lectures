package hr.fer.oop.aud11.zad2;

import hr.fer.oop.aud11.zad1.Loader;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> gradesMap = Loader.loadData();

        System.out.println(getAverageGradesWithMerge(gradesMap));
    }
    
    private static Map<String, Double> getAverageGradesWithMerge(Map<String, Map<String, Integer>> gradesMap) {
        Map<String, List<Integer>> allStudentGrades = new HashMap<>();

        gradesMap.entrySet().stream()
                .flatMap(courseGrades -> courseGrades.getValue().entrySet().stream())
                .forEach(studentGrade -> allStudentGrades.merge(studentGrade.getKey(), new LinkedList<>(Arrays.asList(studentGrade.getValue())),
                (oldList, list) -> {
                    oldList.addAll(list);
                    return oldList;
                }));

        return allStudentGrades.entrySet().stream().
                map(studentGrades -> new AbstractMap.SimpleEntry<>(studentGrades.getKey(),
                studentGrades.getValue().stream().mapToInt(Integer::intValue).average().getAsDouble()))
                .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
    }
//    private static Map<String, Double> getAverageGradesWithoutMerge(Map<String, Map<String, Integer>> gradesMap) {
//        return gradesMap.entrySet().stream()
//                .flatMap(courseGrades -> courseGrades.getValue().entrySet().stream())
//                .collect(groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue)));
//    }
}
