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
		list.add(new Student("Ani�", "Anica", "0000000001", 3));
		list.add(new Student("Bani�", "Banica", "0000000002", 4));
		list.add(new Student("�tefi�", "�tefica", "0000000003", 5));
		list.add(new Student("Ani�", "Ante", "0000000004", 3));
		list.add(new Student("Ivi�", "Ivo", "0000000005", 4));
		list.add(new Student("Peri�", "Perica", "0000000006", 5));
		list.add(new Student("Zeni�", "Zanatea", "0000000007", 5));
		list.add(new Student("Reni�", "Renato", "0000000008", 5));
		return list;
	}

}