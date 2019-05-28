package hr.fer.oop.aud11.zad2;

import java.util.*;
import java.util.stream.Collectors;
import java.lang.String;

public class Main {

	public static void main(String[] args) {
		var data = PopulationDataLoader.loadData();
		
		var labelsToCalculate = new ArrayList<String>();
		labelsToCalculate.add("F");
		labelsToCalculate.add("M");
		
		for(String label : labelsToCalculate) {
			System.out.println(String.format("# Stats for label %s", label));
			CalculateAndPrintPopulationStats(data, label);
			
			System.out.println("");
		}
	}
	
	public static void CalculateAndPrintPopulationStats(List<PopulationSample> data, String label) {
		data = data.stream()
				   .filter(sample -> sample.getLabel().equals(label))
				   .collect(Collectors.toList());
		
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
		
		System.out.println(String.format("\tNumber of samples: %d",  numberOfSamples));
		System.out.println(String.format("\tAge stats: (min: %d, max: %d, average: %.2f)", minimumAge, maximumAge, averageAge));
		System.out.println("\tYoungest population sample: " + youngestSample.toString());
		System.out.println("\tOldest population sample: " + oldestSample.toString());
	}

}
