package hr.fer.oop.aud11.zad1;

import java.util.*;
import java.util.stream.Collectors;
import java.lang.String;


public class Main {

	public static void main(String[] args) {		
		var gradeMaps = GradeData.LoadData();
		
		printStats(gradeMaps);
		
		var gradesArt = gradeMaps.get("arts");
		for(String student : gradesArt.keySet()) {
			gradesArt.compute(student, (key, value) -> value < 5 ? value + 1 : value);
		}
		
		printStats(gradeMaps);
	}
	
	public static void printStats(Map<String, Map<String, Integer>> gradeMaps) {
		var averageGrades = gradeMaps.entrySet().stream()
												.flatMap(x -> x.getValue().entrySet().stream())
												.collect(Collectors.groupingBy(Map.Entry::getKey, 
														 Collectors.averagingDouble(Map.Entry::getValue)));

		try {
			Double averageGradeOfAll = gradeMaps.entrySet().stream()
													.flatMap(x -> x.getValue().entrySet().stream())
													.mapToInt(s -> s.getValue())
													.average()
													.getAsDouble();
			System.out.println("Average grade: " + averageGradeOfAll.toString());
		} catch (NoSuchElementException e) {
			System.err.println("ERROR: OptionalDouble contains no value");
		}
		System.out.println("Average grades per person: " + averageGrades.toString());
	}

}
