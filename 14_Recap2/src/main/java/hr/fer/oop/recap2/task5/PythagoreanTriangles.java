package hr.fer.oop.recap2.task5;

import java.util.Iterator;
import java.util.NoSuchElementException;

import hr.fer.oop.recap2.task1.Ntuple;

public class PythagoreanTriangles implements Iterable<Ntuple<Integer>> {

  private final int a;
  private final int b;

  public PythagoreanTriangles(int a, int b) {
    this.a = a;
    this.b = b;
    if (a <= 0)
      throw new IllegalArgumentException("The first range value is not valid: " + a);
    if (b <= 0)
      throw new IllegalArgumentException("The second range value is not valid: " + b);
  }

  @Override
  public Iterator<Ntuple<Integer>> iterator() {
    return new PythagoreanIterator();
  }

  private class PythagoreanIterator implements Iterator<Ntuple<Integer>> {

    private int x = 1;
    private int y = 2;
    private Ntuple<Integer> next = null;
    private boolean nextFound = false;

    @Override
    public boolean hasNext() {
      if (nextFound)
        return true;
      else
        return findNext();
    }

    @Override
    public Ntuple<Integer> next() {
      if (hasNext()) {
        nextFound = false; // next is used...
        return next;
      } else
        throw new NoSuchElementException();
    }

    private boolean findNext() {
      while (x <= a) {
        while (y <= b) {
          double z = Math.sqrt(x * x + y * y);
          if (Math.abs(Math.round(z) - z) < 1e-5) {
            next = new Ntuple<>(x, y, (int) Math.round(z));
            nextFound = true; // wait for return until y is incremented
          }
          y++;
          if (nextFound)
            return true;
        }
        x++;
        y = x;
      }
      return false;
    }
  }
}
