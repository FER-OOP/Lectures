package hr.fer.oop.recap2.task4;

import hr.fer.oop.recap2.task2.Point;

public class QuadrantCalculator {
  public static int quadrant(Point t) {
    int quadrant = 0;
    if (t.getX().doubleValue() > 0 && t.getY().doubleValue() > 0)
      quadrant = 1;
    else if (t.getX().doubleValue() < 0 && t.getY().doubleValue() > 0)
      quadrant = 2;
    else if (t.getX().doubleValue() < 0 && t.getY().doubleValue() < 0)
      quadrant = 3;
    else if (t.getX().doubleValue() > 0 && t.getY().doubleValue() < 0)
      quadrant = 4;

    return quadrant;
  }
}
