package hr.fer.oop.recap2.task4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;

import hr.fer.oop.recap2.task2.Point;
import hr.fer.oop.recap2.task3.PointComparator;

public class Main {

  public static void main(String[] args) {
    List<Point> list = new ArrayList<>();
    addPoints(list);
    Map<Integer, Set<Point>> map = new TreeMap<>();
    Comparator<Point> comp = new PointComparator();
    comp = comp.thenComparing(Comparator.naturalOrder());
    map.put(1, new TreeSet<>(comp));
    map.put(2, new TreeSet<>(comp));
    map.put(3, new TreeSet<>(comp));
    map.put(4, new TreeSet<>(comp));

    Function<Point, Integer> quadrantFunction = QuadrantCalculator::quadrant;

    for (var point : list) {
      int quadrant = quadrantFunction.apply(point);
      if (quadrant != 0)
        map.get(quadrant).add(point);
    }
    System.out.println(map);
  }

  private static void addPoints(List<Point> list) {
    list.add(new Point(-5, 12));
    list.add(new Point(3, -4));
    list.add(new Point(12, 9));
    list.add(new Point(3, 4));
    list.add(new Point(4, 3));
    list.add(new Point(-9, 12));
    list.add(new Point(-5, -12));
  }

}
