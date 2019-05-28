package hr.fer.oop.aud11.zad3;

import java.util.*;
import java.util.stream.Collectors;

import java.lang.String;

public class Main {

	public static void main(String[] args) {
		var data = PopulationDataLoader.loadData();
		
		// a) svi muški mlađe od 30
		var listA = data.stream()
						.filter(sample -> sample.getLabel().equals("M"))
						.filter(sample -> sample.getAge() < 30)
						.collect(Collectors.toList());
		CalculateAndPrintPopulationStats(listA);
		System.out.println();
		
		
		// b) sve žene starije od 20, mlađe od 40
		var listB = data.stream()
						.filter(sample -> sample.getLabel().equals("F"))
						.filter(sample -> sample.getAge() > 20)
						.filter(sample -> sample.getAge() < 40)
						.collect(Collectors.toList());
		CalculateAndPrintPopulationStats(listB);
		System.out.println();
		
		// c) svi muškarci iznad 50 i sve žene iznad 40
		var listC = data.stream()
				        .filter(sample -> (sample.getLabel().equals("M") && sample.getAge() > 50) || (sample.getLabel().equals("F") && sample.getAge() > 40))
				        .collect(Collectors.toList());
		CalculateAndPrintPopulationStats(listC);
		System.out.println();

		
		// d) ispis svih mlađih od 20 sortiranih po labeli
		data.stream()
		    .filter(sample -> sample.getAge() < 20)
		    .sorted(Comparator.comparing(PopulationSample::getLabel))
		    .forEach(sample -> System.out.println(sample));
	}
	
	public static void CalculateAndPrintPopulationStats(List<PopulationSample> data) {
		long numberOfSamples = data.size();

		var youngestSample = data.stream()
				 				 .min(Comparator.comparing(PopulationSample::getAge))
								 .get();

		var oldestSample = data.stream()
							   .max(Comparator.comparing(PopulationSample::getAge))
							   .get();
		
		double averageAge = data.stream()
								.mapToInt(sample -> sample.getAge())
								.average()
								.getAsDouble();
		
		int minimumAge = data.stream()
			                 .mapToInt(sample -> sample.getAge())
			                 .min()
			                 .getAsInt();
		
		int maximumAge = data.stream()
			                 .mapToInt(sample -> sample.getAge())
			                 .max()
			                 .getAsInt();
		
		System.out.println(String.format("Number of samples: %d",  numberOfSamples));
		System.out.println(String.format("Age stats: (min: %d, max: %d, average: %.2f)", minimumAge, maximumAge, averageAge));
		System.out.println("Youngest population sample: " + youngestSample.toString());
		System.out.println("Oldest population sample: " + oldestSample.toString());
	}

}
