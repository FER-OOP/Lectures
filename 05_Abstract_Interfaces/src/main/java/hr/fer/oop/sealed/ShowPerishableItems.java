package hr.fer.oop.sealed;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ShowPerishableItems {

	public static void main(String[] args) {
		Item[] items = new Item[4];
		items[0] =  new Beverage("23", "Coca cola", 10, 2);			
		items[1] = new Food("777", "CaoCao", 2.5, LocalDate.of(2016,5, 11));		
		items[2] = new Cloth("045", "Simple T-shirt", 350, 54);
		items[3] = new Milk("888", "Tonka", 6.5, 1, MilkType.COW , LocalDate.of(2015,10, 25));
		printPerishableItems(items);
	}

	private static void printPerishableItems(Item[] items) {				
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");				
		for(Item item:items){
			if (item instanceof Perishable perishable){ 
				System.out.format("%s, type: %s, use before: %s %n", item, item.getItemType(),
						perishable.getBestBefore().format(formatter));
			}			
		}		
	}

}
