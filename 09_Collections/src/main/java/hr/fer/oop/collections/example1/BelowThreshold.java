package hr.fer.oop.collections.example1;

import java.util.function.Predicate;

public class BelowThreshold implements Predicate<Number> {

	private final double threshold;

	public BelowThreshold(double threshold) {
		this.threshold = threshold;
	}

	public boolean test(Number d) {
		return d.doubleValue() < threshold;
	}
}
