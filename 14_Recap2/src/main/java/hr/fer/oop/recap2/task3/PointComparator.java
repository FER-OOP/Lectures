package hr.fer.oop.recap2.task3;

import java.util.Comparator;

import hr.fer.oop.recap2.task2.DistanceFromOrigin;
import hr.fer.oop.recap2.task2.Point;

public class PointComparator implements Comparator<Point> {
  private DistanceFromOrigin distance;

  public PointComparator() {
    distance = new DistanceFromOrigin();
  }

  @Override
  public int compare(Point o1, Point o2) {
    double d1 = distance.apply(o1);
    double d2 = distance.apply(o2);
    if (Math.abs(d1 - d2) < 1e-8) // numerical error - treat as same
      return 0;
    else if (d1 < d2)
      return -1;
    else
      return 1;
  }
}
