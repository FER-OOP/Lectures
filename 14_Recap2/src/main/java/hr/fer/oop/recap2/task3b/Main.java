package hr.fer.oop.recap2.task3b;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import hr.fer.oop.recap2.task2.DistanceFromOrigin;
import hr.fer.oop.recap2.task2.Point;
import hr.fer.oop.recap2.task2.QuadrantPredicate;

public class Main {

  public static void main(String[] args) {
    List<Point> list = new ArrayList<>();
    list.add(new Point(-5, 12));
    list.add(new Point(3, -4));
    list.add(new Point(12, 9));
    list.add(new Point(3, 4));
    list.add(new Point(4, 3));
    list.add(new Point(-9, 12));
    list.add(new Point(-5, -12));

    DistanceFromOrigin dist = new DistanceFromOrigin();

    OptionalDouble avg = list.stream()
      .filter(new QuadrantPredicate(true, false, false, false))
      .mapToDouble(p -> dist.apply(p))
      .average();
    avg.ifPresentOrElse(
        val -> System.out.println("Avg = " + val),
        () -> System.out.println("No data for selected quadrants"));
  }
}
