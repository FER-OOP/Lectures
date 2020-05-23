package hr.fer.oop.recap2.task2;

import java.util.function.Predicate;

public class QuadrantPredicate implements Predicate<Pair<? extends Number>> {
  private boolean[] quadrants;

  public QuadrantPredicate(boolean q1, boolean q2, boolean q3, boolean q4) {
    quadrants = new boolean[4];
    quadrants[0] = q1;
    quadrants[1] = q2;
    quadrants[2] = q3;
    quadrants[3] = q4;
  }

  @Override
  public String toString() {
    return String.format("Take points from quadrants 1-4? (%b, %b, %b, %b)",
        quadrants[0], quadrants[1], quadrants[2], quadrants[3]);
  }

  @Override
  public boolean test(Pair<? extends Number> t) {
    int quadrant = 0;
    if (t.getX().doubleValue() > 0 && t.getY().doubleValue() > 0)
      quadrant = 1;
    else if (t.getX().doubleValue() < 0 && t.getY().doubleValue() > 0)
      quadrant = 2;
    else if (t.getX().doubleValue() < 0 && t.getY().doubleValue() < 0)
      quadrant = 3;
    else if (t.getX().doubleValue() > 0 && t.getY().doubleValue() < 0)
      quadrant = 4;

    return quadrant != 0 && quadrants[quadrant - 1];
  }

}
