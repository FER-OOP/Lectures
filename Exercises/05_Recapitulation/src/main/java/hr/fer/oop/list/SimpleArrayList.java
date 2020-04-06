package hr.fer.oop.list;

/**
 * Task 1
 *
 * Implement a list that internally uses arrays for storage. Any object can be
 * added to the list. Initialize the internal array to the size of 2 and double
 * the capacity if the list runs out of space. The list must be able to retrieve
 * a contained objects index. Objects can be queried by index.
 *
 * Zadatak 1
 *
 * Implementirajte listu koje se interno oslanja na polja kao strukturu
 * podataka. Inicijalizirajte interno polje na veličinu 2 te poduplajte
 * kapacitet ako u listi nestane prostora. Iz liste je moguće dobiti indeks
 * traženog objekta. Objekte je moguće dohvaćati po indeksu.
 *
 * @author OOP
 *
 */

public class SimpleArrayList {

  private Object[] elementData;
  private int size;

  public SimpleArrayList() {
    elementData = new Object[2];
    size = 0; // Was not necessary
  }

  // Appends the specified element to the end of this list.
  public boolean add(Object o) {
    ensureCapacity(size + 1);
    elementData[size++] = o;
    return true;

  }

  // Returns the number of elements in this list.
  public int size() {
    return size;
  }

  // Returns the element at the specified position in this list.
  public Object get(int index) {
    Object found = null;
    if (index < size) {
      found = elementData[index];
    }
    return found;
  }

  // Returns the index of the first occurrence of the specified element in this
  // list, or -1 if this list does not contain the element.
  public int indexOf(Object o) {
    int found = -1;
    for (int i = 0; i < size; i++) {
      if (elementData[i] == o) {
        found = i;
        break;
      }
    }
    return found;
  }

  // Increases the capacity of this SimpleArrayList instance, if
  // necessary, to ensure that it can hold at least the number of elements
  // specified by the minimum capacity argument.
  private void ensureCapacity(int minCapacity) {
    int current = elementData.length;
    if (minCapacity > current) {
      // Ensure some extra space so as not to copy too many times
      Object[] newData = new Object[Math.max(current * 2, minCapacity)];
      System.arraycopy(elementData, 0, newData, 0, size);
      elementData = newData;
    }
  }

  public static void main(String[] args) {
    SimpleArrayList list = new SimpleArrayList();
    list.add("first");
    list.add("second");
    list.add("third");

    System.out.println(list.size()); // 3
    for(int i = 0; i < list.size(); i++)
      System.out.println("Element " + i + ": " + list.get(i));
    System.out.println(list.indexOf("second")); // 1
  }
}
