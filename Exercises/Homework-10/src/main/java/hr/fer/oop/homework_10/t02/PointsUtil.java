package hr.fer.oop.homework_10.t02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PointsUtil {
	
	public static Map<String, Integer> getForYear(int year) throws IOException {
		Map<String, Integer> standings = new HashMap<>();
		Path path = Paths.get(String.format("data/%d/voting", year));
		if (Files.exists(path)) {			
			try(DirectoryStream<Path> stream = Files.newDirectoryStream(path, new VotingFilter())) {
				for(Path p : stream) {
					updateStandings(p, standings);					
				}
			}				
		}		
		return standings;
	}
	
	public static void updateStandings(Path path, Map<String, Integer> standings) throws IOException {		
//		try(Scanner sc = new Scanner(path, StandardCharsets.UTF_8)) {
//			while(sc.hasNextLine()) {
//				String line = sc.nextLine();
//				String country = line.substring(3);
//				int points = Integer.parseInt(line.substring(0, 2).trim());
//				Integer current = standings.getOrDefault(country, 0);
//				standings.put(country, current + points);
//			}
//		}
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8); //use in case of small files
		for(String line : lines) {			
			String country = line.substring(3);
			int points = Integer.parseInt(line.substring(0, 2).trim());
			Integer current = standings.getOrDefault(country, 0);
			standings.put(country, current + points);
		}
	}
}
