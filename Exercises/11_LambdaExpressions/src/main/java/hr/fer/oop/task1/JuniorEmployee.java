package hr.fer.oop.task1;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Predicate;

public class JuniorEmployee implements Predicate<Employee> {

	private LocalDate onDate;

	public JuniorEmployee(LocalDate onDate) {
		this.onDate = onDate;
	}

	@Override
	public boolean test(Employee t) {
		Period period = Period.between(t.getEmploymentDate(), onDate);
		return period.getYears() < 2;
	}

}
