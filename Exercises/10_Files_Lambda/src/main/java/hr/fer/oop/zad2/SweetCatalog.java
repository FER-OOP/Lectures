package hr.fer.oop.zad2;

import java.util.ArrayList;
import java.util.List;

public class SweetCatalog {
	
	public static List<Sweet> loadSweets() {
		List<Sweet> list = new ArrayList<Sweet>();
		list.add(new Sweet("Cookie", 12, 5, 70));
		list.add(new Sweet("Ice cream", 5, 10, 25));
		list.add(new Sweet("Cake", 25, 20.5, 28));
		list.add(new Sweet("Fruit", 23, 10, 5));
		list.add(new Sweet("Muffin", 43, 52, 50));
		list.add(new Sweet("Lollipop", 3, 7, 70));
		list.add(new Sweet("Candy", 33, 2, 90));
		return list;
	}

}
