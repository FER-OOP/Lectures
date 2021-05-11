package hr.fer.oop.homework_10.t01;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class PointsSaver {
	private static final int[] points = {12, 10, 8, 7, 6, 5, 4, 3, 2, 1};

	static void saveJuryPoints(int year, String juryCountry, String[] countries) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		String filename = String.format("data/%d/voting/%s-jury.txt", year, juryCountry);
		savePoints(filename, countries);
	}

	static void saveTelevotingPoints(int year, String country, String[] countries) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		String filename = String.format("data/%d/voting/%s-televoting.txt", year, country);
		savePoints(filename, countries);
	}

	private static void savePoints(String filename, String[] countries) throws UnsupportedEncodingException, FileNotFoundException, IOException {
		File file = new File(filename);
		if (!file.exists()) {
		 	file.getParentFile().mkdirs();
		}

//		try(Writer writer = new BufferedWriter(
//								new OutputStreamWriter(
//									new BufferedOutputStream(
//										new FileOutputStream(filename)
//									)
//									, StandardCharsets.UTF_8))) {
		try(Writer writer = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8))) {
			for(int i=0; i<countries.length ; i++) {
				writer.write(String.format("%2d %s%n", points[i], countries[i]));
			}
		}

	}
}
