package hr.fer.oop.streams;

import java.util.ArrayList;
import java.util.List;

public class StudentData {

	public static List<Student> loadCN() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("王", "芷若", "CN-001", 30)); //Wáng 	Zhi Ruo
		list.add(new Student("李", "语嫣", "CN-002", 40)); //Lǐ 		Yu Yan
		list.add(new Student("周", "望舒", "CN-003", 50)); //Zhōu 	Wang Shu
		list.add(new Student("徐", "语嫣", "CN-004", 40)); //Xú 		Yu Yan
		list.add(new Student("郭", "风眠", "CN-005", 50)); //Guō 		Feng Mian
		list.add(new Student("林", "芷若", "CN-006", 30)); //Lin 		Zhi Ruo
		list.add(new Student("林", "徽因", "CN-007", 10)); //Lin 		Hui Yin
		list.add(new Student("郭", "芷若", "CN-008", 20)); //Guō 		Zhi Ruo
		return list;
	}
	
	public static List<Student> load() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("Anić", "Anica", "HR-001", 30)); 
		list.add(new Student("Banić", "Banica", "HR-002", 40));
		list.add(new Student("Štefić", "Štefica", "HR-003", 50)); 
		list.add(new Student("Anić", "Ante", "HR-004", 40)); 
		list.add(new Student("Ivić", "Ivo", "HR-005", 30)); 
		list.add(new Student("Dragić", "Drago", "HR-006", 40));
		list.add(new Student("Perić", "Perica", "HR-007", 50)); 
		list.add(new Student("Zenić", "Zanatea", "HR-008", 50));
		list.add(new Student("Markan", "Marko", "HR-009", 20));
		list.add(new Student("Renić", "Renato", "HR-010", 50)); 		
		return list;
	}	
}