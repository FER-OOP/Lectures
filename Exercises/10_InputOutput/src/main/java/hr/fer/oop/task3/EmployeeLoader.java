package hr.fer.oop.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class EmployeeLoader {
	public static List<Employee> loadFromFile(String fileName) throws IOException {
		List<Employee> list = new LinkedList<>();
		Path path = Path.of(fileName);
		if (Files.exists(path)) {
			//if the file is large, use Scanner or Reader!
			List<String> lines = Files.readAllLines(path);
			for(String line : lines) {
				String[] data = line.split(";");
				String name = data[0];
				double salary = Double.parseDouble(data[1]);
				int year = Integer.parseInt(data[2]);
				int month = Integer.parseInt(data[3]);
				int day = Integer.parseInt(data[4]);
				Employee e = new Employee(name, salary, LocalDate.of(year, month, day));
				list.add(e);
			}
		}
		return list;
	}
}
