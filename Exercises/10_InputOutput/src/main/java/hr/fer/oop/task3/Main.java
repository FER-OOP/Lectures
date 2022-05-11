package hr.fer.oop.task3;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) throws IOException {
		String filenameEmployees = "src/main/resources/employees.txt";
		String filenameYears = "src/main/resources/years.dat";
		
		List<Employee> employees = EmployeeLoader.loadFromFile(filenameEmployees);
		
		//for small files we can use Files.readAllBytes
		try(InputStream stream = Files.newInputStream(Path.of(filenameYears))) {
			int years;
			while((years = stream.read()) != -1) { // years can be in [0,255]
				Predicate<Employee> predicate = new YearsOfService(years, LocalDate.now());
				System.out.printf("Employees with %d years of service.%n", years);
				for(Employee e : employees) {
					if (predicate.test(e)) {
						System.out.printf("\t%s%n", e);
					}
				}
				System.out.println();
			}
		}
	}

}
