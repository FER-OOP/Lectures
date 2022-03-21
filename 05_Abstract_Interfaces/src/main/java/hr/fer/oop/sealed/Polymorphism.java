package hr.fer.oop.sealed;

import java.time.LocalDate;

public class Polymorphism {

	public static void main(String[] args) {
		Item[] items = new Item[3];
		items[0] =  new Beverage("23", "Coca cola", 10, 2);			
		items[1] = new Food("777", "CaoCao", 2.5, LocalDate.of(2016,5, 11));		
		items[2] = new Cloth("045", "Simple T-shirt", 350, 54);
		calculatePrice(items);
	}

	private static void calculatePrice(Item[] items) {
		double price = 0;
		for(Item item:items){
			System.out.format("%s, price: %.2f, type: %s%n", item, item.getPrice(1), item.getItemType());
			price += item.getPrice(1);
		}
		System.out.println("Total price = " + price);	
	}

}
