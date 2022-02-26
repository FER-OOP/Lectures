package hr.fer.oop.task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import hr.fer.oop.task2.items.*;

public class ItemsDB {
	public static List<Item> load(){
		List<Item> list = new ArrayList<>();
		list.add(new Beverage("23", "Coca cola", 10, 2));		
		list.add(new Milk("890", "Beee", 34, 1, MilkType.SHEEP , LocalDate.of(2017,2, 25)));
		list.add(new Food("777", "CaoCao", 2.5, LocalDate.of(2017,5, 11)));		
		list.add(new Cloth("045", "Simple T-shirt", 350, 54));
		list.add(new Milk("888", "Tonka", 6.5, 1, MilkType.COW , LocalDate.of(2017,2, 25)));
		list.add(new Milk("850", "Vindija", 6.5, 1, MilkType.COW , LocalDate.of(2017,2, 25)));
		list.add(new Milk("802", "Dukat", 7, 1, MilkType.COW , LocalDate.of(2017,2, 25)));
		list.add(new Milk("803", "Dukat", 9.5, 1.5, MilkType.COW , LocalDate.of(2017,2, 25)));
		list.add(new Milk("804", "Dukat", 4, 0.5, MilkType.COW , LocalDate.of(2017,2, 25)));		
		list.add(new Milk("850", "Dukat", 14, 0.5, MilkType.GOAT , LocalDate.of(2017,2, 25)));
		return list;
	}
}
