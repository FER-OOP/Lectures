package hr.fer.oop.homework_10.t07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import hr.fer.oop.homework_10.t02.PointsUtil;
import hr.fer.oop.homework_10.t02.VotingFilter;

public class Main {

	public static void main(String[] args) throws IOException {		
		Scanner sc = new Scanner(System.in);				
		System.out.println("Enter a year");
		int year = sc.nextInt();	
		var points = PointsUtil.getForYear(year);
		Set<String> votingCountries = getFilenames(year);
		
		System.out.println("Voted but have no points:");
		for(String country : votingCountries) {
			if (!points.containsKey(country)) {
				System.out.println(country);
			}
		}
		System.out.println();
		System.out.println("Have points, but still have not voted");
		Set<String> countries = new TreeSet<>();
		for(String country : points.keySet()) {
			if (!votingCountries.contains(country)) {
				countries.add(country);
			}
		}
		System.out.println(countries);
		
	}
	
	private static Set<String> getFilenames(int year) throws IOException {
		Set<String> votingCountries = new TreeSet<>();		
		Path dir = Path.of("data",  Integer.valueOf(year).toString()  , "voting");
		if (Files.exists(dir) && Files.isDirectory(dir)) {
			for(Path p : Files.newDirectoryStream(Path.of("data/" + year + "/voting"), new VotingFilter())) {
				String filename = p.getFileName().toString();
				int ind = filename.indexOf('-');
				votingCountries.add(filename.substring(0, ind));
			}
		}
		return votingCountries;
	}
}
