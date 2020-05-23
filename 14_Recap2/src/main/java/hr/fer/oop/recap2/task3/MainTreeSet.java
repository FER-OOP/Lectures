package hr.fer.oop.recap2.task3;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import hr.fer.oop.recap2.task2.Point;

public class MainTreeSet {

  public static void main(String[] args) {
    Comparator<Point> comp = new PointComparator();
    Set<Point> set = new TreeSet<>(comp);
    addToSet(set);
    System.out.println("Set with distance comparator:\n" + set);

    set = new TreeSet<>();
    addToSet(set);
    System.out.println("Set with natural order:\n" + set);
  }

  private static void addToSet(Set<Point> set) {
    set.add(new Point(-5, 12));
    set.add(new Point(3, -4));
    set.add(new Point(12, 9));
    set.add(new Point(3, 4));
    set.add(new Point(4, 3));
    set.add(new Point(-9, 12));
    set.add(new Point(-5, -12));
  }
}
