package hr.fer.oop.recap2.task2;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

  public static void main(String[] args) {
    Pair<String> p = new Pair<>("first", "second");
    System.out.println(p.toString()); // (first, second)
    p.setX(p.getY().replace("cond", "rious"));
    System.out.println(p); // (serious, second)

    List<Pair<Double>> points = new LinkedList<>();
    points.add(new Pair<>(1.5, 5.0));
    points.add(new Pair<>(3.0, -4.0));
    points.add(new Pair<>(-5.0, -12.0));
    points.add(new Pair<>(-1.0, 3.5));

    DistanceFromOrigin distance = new DistanceFromOrigin();
    for (var point : points) {
      System.out.format("%s dist = %.2f%n", point, distance.apply(point));
    }
    // print should be
    // (1.5, 5.0) dist = 5.22
    // (3.0, -4.0) dist = 5.00
    // (-5.0, -12.0) dist = 13.00
    // (-1.0, 3.5) dist = 3.64

    List<Point> intpoints = new LinkedList<>();
    intpoints.add(new Point(1, 5));
    intpoints.add(new Point(3, -4));
    intpoints.add(new Point(-5, -12));
    intpoints.add(new Point(-9, 12));

    // the next print should be
//		Predicate: Take points from quadrants 1-4? (false, true, true, true)
//		(3, -4) dist = 5.00
//		(-5, -12) dist = 13.00
//		(-9, 12) dist = 15.00
    Predicate<Pair<? extends Number>> predicate = new QuadrantPredicate(false, true, true, true);
    System.out.println("Predicate: " + predicate.toString());
    for (var point : intpoints) {
      if (predicate.test(point))
        System.out.format("%s dist = %.2f%n", point, distance.apply(point));
    }
  }
}
