package hr.fer.oop.generics.sorted;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Task 2
 * 
 * Implement a sorting variant of the list from task 1. The list must have a parameterized type 
 * that is an implementation of the Comparable<T> interface. The list must be automatically sorted
 * when adding an object to the list. Elements of the list must be persons defined in the task 1, 
 * now implementing the Comparable<T> interface.
 * The list of persons must be sorted ascending by birth dates. 
 * 
 * Zadatak 2
 * 
 * Implementirajte sortirajuću varijantu liste iz zadatka 1. Lista mora imati parametrizirani tip 
 * koji implementira sučelje Comparable<T>. Prilikom dodavanja novog objekta u listu, lista se 
 * automatski sortira. Elementi liste moraju biti osobe iz prvog zadatka, no klasa Person sada 
 * mora implementirati sučelje Comparable<T> kako bi se mogla koristiti u sortirajućoj listi. 
 * Lista osoba mora biti sortirana uzlazno prema datumu rođenja osobe.
 * 
 * @author Dalibor Krleža
 *
 */

public class ParametrizedArrayList<T extends Comparable<T>> { // T is the type for the list

	private T[] elementData;
	private int size;

	@SuppressWarnings("unchecked")
	public ParametrizedArrayList() {
		// We initialize the array as Comparable, not Object
		// This is necessary, so that we don't encounter ClassCastException
		elementData = (T[])new Comparable[2];
		size = 0; // Was not necessary
	}

	// Adds the specified element to the appropriate (sorted) position in this list.
	public boolean add(T o) {
		ensureCapacity(size + 1);
		int i=0;
		// Find the place to put the new object, so that the array remains sorted
		while(i<size && o.compareTo(elementData[i])>=0) i++;
		// If the new object is the "greatest" one, append it to the list
		if(i==size) elementData[size++]=o;
		else {
			// If somewhere in the middle, move the remainder of the array for one place
			for(int j=size++;j>i;j--) elementData[j]=elementData[j-1];
			// Insert the new object in between
			elementData[i]=o;
		}
		return true;

	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns the element at the specified position in this list.
	public T get(int index) {
		T found = null;
		if (index < size) {
			found = elementData[index];
		}
		return found;
	}

	// Returns the index of the first occurrence of the specified element in this
	// list, or -1 if this list does not contain the element.
	public int indexOf(T o) {
		int found = -1;
		for (int i = 0; i < size; i++) {
			if (elementData[i].equals(o)) {
				found = i;
				break;
			}
		}
		return found;

	}

	// Increases the capacity of this ParametrizedArrayList instance, if
	// necessary, to ensure that it can hold at least the number of elements
	// specified by the minimum capacity argument.
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int minCapacity) {
		int current = elementData.length;
		if (minCapacity > current) {
			// Ensure some extra space so as not to copy too many times
			T[] newData = (T[])new Comparable[Math.max(current * 2, minCapacity)];
			System.arraycopy(elementData, 0, newData, 0, size);
			elementData = newData;
		}

	}

	// print the list
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<size;i++) {
			sb.append(elementData[i]);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	// The test
	public static void main(String[] args) throws ParseException {
		ParametrizedArrayList<Person> persons=new ParametrizedArrayList<Person>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy.");
		Person p1=new Person("4356798212", "Marko", "Markić", sdf.parse("12.04.1999."), Integer.valueOf(186));
		persons.add(p1);
		Person p2=new Person("8736661786", "Iva", "Ivić", sdf.parse("21.02.1996."), Integer.valueOf(172));
		persons.add(p2);
		Person p3=new Person("9389389898", "Darko", "Darkić", sdf.parse("19.08.2000."), Integer.valueOf(179));
		persons.add(p3);
		Person p4=new Person("9875698734", "Mirko", "Galamdžija", sdf.parse("23.10.1987."), Integer.valueOf(169));
		persons.add(p4);
		
		System.out.println(persons);
	}
}
