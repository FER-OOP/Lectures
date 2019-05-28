package hr.fer.oop.aud11.zad2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.lang.Integer;

public class PopulationDataLoader {
	
	public static List<PopulationSample> loadData() {	
		List<PopulationSample> ret = new ArrayList<PopulationSample>();
		Path filepath = Paths.get("data.csv");
		
		try {
			Files.lines(filepath).forEach(row -> {
													var fragments = row.split(";");
													String fileName = fragments[0];
													String label = fragments[1];
													Integer age = Integer.parseInt(fragments[2]);
													
													var newSample = new PopulationSample(fileName, label, age);
													ret.add(newSample);
												});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
