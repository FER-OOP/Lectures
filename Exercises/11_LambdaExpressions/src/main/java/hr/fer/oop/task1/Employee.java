package hr.fer.oop.task1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
	private String name;
	private double salary;
	private LocalDate employmentDate;

	public Employee(String name, double salary, LocalDate employmentDate) {
		this.name = name;
		this.salary = salary;
		this.employmentDate = employmentDate;
    }
	
	@Override
	public String toString() {
		return String.format("%s %.2f %s", name, salary, employmentDate.format(DateTimeFormatter.ISO_DATE));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(LocalDate employmentDate) {
		this.employmentDate = employmentDate;
	}
}
