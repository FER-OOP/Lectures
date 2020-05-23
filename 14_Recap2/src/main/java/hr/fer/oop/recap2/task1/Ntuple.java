package hr.fer.oop.recap2.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ntuple<T extends Comparable<T>> implements Comparable<Ntuple<T>> {
  private List<T> data;

  @SuppressWarnings("unchecked")
  public Ntuple(T first, T second, T... others) {
    data = new ArrayList<>(others.length + 2);
    data.add(first);
    data.add(second);
    for (int i = 0; i < others.length; i++)
      data.add(others[i]);
  }

  public T get(int index) {
    return data.get(index - 1);
  }

  public void set(int index, T element) {
    data.set(index - 1, element);
  }

  public int size() {
    return data.size();
  }

  @Override
  public String toString() {
    // variant 1:
//    StringBuilder sb = new StringBuilder();
//    sb.append('(');
//    boolean addcomma = false;
//    for (T t : data) {
//      if (addcomma)
//        sb.append(", ");
//      sb.append(t.toString());
//      addcomma = true;
//    }
//    sb.append(')');
//    return sb.toString();

    // variant 2:
    return data.stream()
      .map(t -> t.toString())
      .collect(Collectors.joining(", ", "(", ")"));
  }

  @Override
  public boolean equals(Object obj) {
    // cannot write if (obj instanceof NTuple<T>) due to Java generics
    if (!(obj instanceof Ntuple))
      return false;

    Ntuple<?> other = (Ntuple<?>) obj; // Ntuple<T> or Ntuple raise warning, and it is not necessary
    return Objects.equals(this.data, other.data);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(data);
  }

  @Override
  public int compareTo(Ntuple<T> o) {
    int min = Math.min(this.size(), o.size());
    for (int i = 0; i < min; i++) {
      int r = this.data.get(i).compareTo(o.data.get(i));
      if (r != 0)
        return r;
    }
    return this.size() - o.size();
  }
}
