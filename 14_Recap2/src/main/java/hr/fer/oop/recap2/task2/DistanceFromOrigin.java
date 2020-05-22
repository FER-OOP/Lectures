package hr.fer.oop.recap2.task2;

import java.util.function.Function;

public class DistanceFromOrigin implements Function<Pair<? extends Number>, Double> {

  @Override
  public Double apply(Pair<? extends Number> t) {
    return Math.sqrt(
        Math.pow(t.getX().doubleValue(), 2) +
        Math.pow(t.getY().doubleValue(), 2));
  }

}
