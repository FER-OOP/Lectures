package hr.fer.oop.recap2.task2;

import hr.fer.oop.recap2.task1.Ntuple;

public class Pair<T extends Comparable<T>> extends Ntuple<T> {

  @SuppressWarnings("unchecked")
  public Pair(T x, T y) {
    super(x, y);
  }

  public T getX() {
    return get(1); // super.get(1)
  }

  public void setX(T value) {
    set(1, value); // super.set(1, value)
  }

  public T getY() {
    return get(2);
  }

  public void setY(T value) {
    set(2, value);
  }

}
