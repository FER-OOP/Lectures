package hr.fer.oop.recap2.task3a;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hr.fer.oop.recap2.task2.DistanceFromOrigin;
import hr.fer.oop.recap2.task2.Point;
import hr.fer.oop.recap2.task2.QuadrantPredicate;
import hr.fer.oop.recap2.task3.PointComparator;

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

    List<String> newlist = list.stream()
      .filter(new QuadrantPredicate(true, true, false, true))
      .sorted(new PointComparator().reversed())
      .map(p -> String.format("dist(%s) = %.2f", p, dist.apply(p)))
      .collect(Collectors.toList());
    System.out.println(newlist);
  }
}
