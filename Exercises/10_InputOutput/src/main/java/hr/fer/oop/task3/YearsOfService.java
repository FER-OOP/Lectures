package hr.fer.oop.task3;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;

public class YearsOfService implements Predicate<Employee> {

	private int years;
	private LocalDate onDate;

	public YearsOfService(int years, LocalDate onDate) {
		this.years = years;
		this.onDate = onDate;
	}

	@Override
	public boolean test(Employee t) {
		Period period = Period.between(t.getEmploymentDate(), onDate);
		return period.getYears() == years;
	}

}
