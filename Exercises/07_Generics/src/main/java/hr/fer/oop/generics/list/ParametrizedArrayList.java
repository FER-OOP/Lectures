package hr.fer.oop.generics.list;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Task 1
 * 
 * Implement a list that internally uses arrays for storage. The list type must be parameterized. 
 * Initialize the internal array to the size of 2 and double the capacity if the list runs 
 * out of space. The list must be able to retrieve a contained objects index. Objects of
 * the parameterized type can be queried by index.
 * For test, create two list types. The first list must be of integer type.
 * The second list must be parameterized to store person details. Each person has the following
 * properties: OIB, name, surname, birthDate and height. The OIB is the key property for each
 * person.
 * 
 * Zadatak 1
 * 
 * Implementirajte listu koje se interno oslanja na polja kao strukturu podataka. Tip podatka koji
 * se sprema u listu mora biti parametriziran. Inicijalizirajte interno polje na veličinu 2 te 
 * poduplajte kapacitet ako u listi nestane prostora. Iz liste je moguće dobiti indeks traženog
 * objekta. Objekte parametriziranog tipa je moguće dohvaćati po indeksu.
 * Za test implementirajte dvije liste različitog tipa. Prva lista neka bude cjelobrojnog tipa.
 * Druga lista neka sprema objekte koji sadrže podatke o osobama. Svaki osoba sadrži slijedeće
 * podatke: OIB, ime, prezime, datum rođenja i visinu. OIB je ključ svake osobe.
 * 
 * @author Dalibor Krleža
 *
 */

public class ParametrizedArrayList<T> { // T is the type for the list

	private T[] elementData;
	private int size;

	@SuppressWarnings("unchecked")
	public ParametrizedArrayList() {
		// If the parameterized type is defined as <T extends C>, then the array initialized as "new Object[size]"
		// can cause ClassCastException. Instead, the array should be initialized as "new C[size]". 
		// See SortedParametrizedArrayList.
		elementData = (T[])new Object[2];
		size = 0; // Was not necessary
	}

	// Appends the specified element to the end of this list.
	public boolean add(T o) {
		ensureCapacity(size + 1);
		elementData[size++] = o;
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
			T[] newData = (T[])new Object[Math.max(current * 2, minCapacity)];
			System.arraycopy(elementData, 0, newData, 0, size);
			elementData = newData;
		}

	}

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
		// The integer list
		ParametrizedArrayList<Integer> intArray=new ParametrizedArrayList<Integer>();
		intArray.add(Integer.valueOf(1));
		intArray.add(Integer.valueOf(1));
		intArray.add(Integer.valueOf(2));
		intArray.add(Integer.valueOf(3));
		intArray.add(Integer.valueOf(5));
		intArray.add(Integer.valueOf(8));

		System.out.println("Integer array size "+intArray.size());
		System.out.println("Number 5 found at index "+(intArray.indexOf(Integer.valueOf(5))+1));
		
		// The person list
		ParametrizedArrayList<Person> persons=new ParametrizedArrayList<Person>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy.");
		Person p1=new Person("4356798212", "Marko", "Markić", sdf.parse("12.04.1999."), Integer.valueOf(186));
		persons.add(p1);
		Person p2=new Person("8736661786", "Iva", "Ivić", sdf.parse("21.02.1996."), Integer.valueOf(172));
		persons.add(p2);
		Person p3=new Person("9389389898", "Darko", "Darkić", sdf.parse("19.08.2000."), Integer.valueOf(179));
		persons.add(p3);
		
		System.out.println("Persons array size "+persons.size());
		Person searchPerson=new Person();
		searchPerson.setOIB("8736661786");
		System.out.println("Person having OIB:"+searchPerson.getOIB()+" found at index "+(persons.indexOf(searchPerson)+1));
	}
}
