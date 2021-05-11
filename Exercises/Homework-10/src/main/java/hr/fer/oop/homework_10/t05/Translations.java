package hr.fer.oop.homework_10.t05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translations {
		
	public static Map<String, Map<String, String>> load() throws IOException {
		Map<String, Map<String, String>> map = new HashMap<>();
		Path path = Paths.get("data/translations");
		if (Files.exists(path)) {			
			try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
				for(Path p : stream) {
					String filename = p.getName(p.getNameCount() - 1).toString();
					int ind = filename.indexOf(".txt");
					String languageCode = filename.substring(0, ind);
					Map<String, String> translations = new HashMap<String, String>();
					try(Scanner sc = new Scanner(p, StandardCharsets.UTF_8)) { //or you can use Files.readAllLines(p, StandardCharsets.UTF_8)							
						while(sc.hasNextLine()) {							  //and iterate through returned List<String>
							String line = sc.nextLine();
							String[] names = line.split(":");
							translations.put(names[0], names[1]);							
						}						
					}	
					map.put(languageCode.toLowerCase(), translations);
				}
			}				
		}		
		return map;
	}	
	
	public static String translate(String countryName, String languageCode, Map<String, Map<String, String>> translations) {
		Map<String, String> map = translations.get(languageCode.toLowerCase());
		return map == null ? countryName : map.getOrDefault(countryName, countryName);
	}
}
