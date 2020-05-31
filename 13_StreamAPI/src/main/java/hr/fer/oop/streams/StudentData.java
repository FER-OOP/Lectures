package hr.fer.oop.streams;

import java.util.ArrayList;
import java.util.List;

public class StudentData {

	public static List<Student> loadCN() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("王", "芷若", "0000000001", 30)); //Wáng 	Zhi Ruo
		list.add(new Student("李", "语嫣", "0000000002", 40)); //Lǐ 		Yu Yan
		list.add(new Student("周", "望舒", "0000000003", 50)); //Zhōu 	Wang Shu
		list.add(new Student("徐", "语嫣", "0000000004", 40)); //Xú 		Yu Yan
		list.add(new Student("郭", "风眠", "0000000005", 30)); //Guō 		Feng Mian
		list.add(new Student("林", "芷若", "0000000006", 50)); //Lin 		Zhi Ruo
		list.add(new Student("林", "徽因", "0000000007", 50)); //Lin 		Hui Yin
		list.add(new Student("郭", "芷若", "0000000008", 50)); //Guō 		Zhi Ruo
		return list;
	}
	
	public static List<Student> load() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("Anić", "Anica", "0000000001", 30)); 
		list.add(new Student("Banić", "Banica", "0000000002", 40));
		list.add(new Student("Štefić", "Štefica", "0000000003", 50)); 
		list.add(new Student("Anić", "Ante", "0000000004", 40)); 
		list.add(new Student("Ivić", "Ivo", "0000000005", 30)); 
		list.add(new Student("Perić", "Perica", "0000000006", 50)); 
		list.add(new Student("Zenić", "Zanatea", "0000000007", 50)); 
		list.add(new Student("Renić", "Renato", "0000000008", 50)); 
		return list;
	}	
}