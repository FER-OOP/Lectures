package hr.fer.oop.homework_10.t04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import hr.fer.oop.homework_10.t03.StandingsUtil;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a year");
		int year = sc.nextInt();
		Path path = Paths.get(String.format("data/%d/voting", year));
		if (Files.exists(path)) {
			VotingResultVisitor visitor = new VotingResultVisitor();
			Files.walkFileTree(path, visitor);
			System.out.println(StandingsUtil.orderByPoints(visitor.standings())); //to do: print data ordered by points
		}
		else {
			System.out.println("No data for year: " + year);
		}		
	}
}
