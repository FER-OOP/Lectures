package hr.fer.oop.lists;

import java.util.function.Predicate;

public class BelowLimit implements Predicate<Double> {

	private double limit;

	public BelowLimit(double limit) {
		this.limit = limit;
	}

	public boolean test(Double d) {
		return d < limit;
	}
}
