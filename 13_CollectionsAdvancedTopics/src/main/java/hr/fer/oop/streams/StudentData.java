package hr.fer.oop.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * Shared data for other examples.
 * 
 * @author marcupic
 */
public class StudentData {

	public static List<Student> load() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("Anić", "Anica", "0000000001", 3));
		list.add(new Student("Banić", "Banica", "0000000002", 4));
		list.add(new Student("Štefić", "Štefica", "0000000003", 5));
		list.add(new Student("Anić", "Ante", "0000000004", 4));
		list.add(new Student("Ivić", "Ivo", "0000000005", 3));
		list.add(new Student("Perić", "Perica", "0000000006", 5));
		list.add(new Student("Zenić", "Zanatea", "0000000007", 5));
		list.add(new Student("Renić", "Renato", "0000000008", 5));
		return list;
	}

}