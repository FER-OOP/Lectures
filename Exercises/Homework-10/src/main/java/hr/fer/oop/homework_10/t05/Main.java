package hr.fer.oop.homework_10.t05;

import java.io.IOException;
import java.util.Scanner;

import hr.fer.oop.homework_10.t02.PointsUtil;
import hr.fer.oop.homework_10.t03.StandingsUtil;

public class Main {

	public static void main(String[] args) throws IOException {
		var translations = Translations.load();
		Scanner sc = new Scanner(System.in);		
		System.out.println("Enter a language code (e.g. HR, FR, DE, ...)");
		String code = sc.nextLine();
		System.out.println("Enter a year");
		int year = sc.nextInt();	
		var standings = StandingsUtil.orderByPoints(PointsUtil.getForYear(year));
		
		for(var pair : standings) {
			System.out.printf("%s %d %n", Translations.translate(pair.getFirst(), code, translations), pair.getSecond());
		}
	}
}
