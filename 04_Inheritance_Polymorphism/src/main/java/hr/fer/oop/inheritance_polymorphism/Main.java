package hr.fer.oop.inheritance_polymorphism;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Item item = new Item("1256", "Rambo keks");
		item.setNetSalePrice(5);
		System.out.format("%s, price: %.2f, type: %s%n", item, item.getPrice(1), item.getItemType());		
		Food food = new Food("777", "CaoCao", 2.5, LocalDate.of(2016,5, 11));
		System.out.format("%s, price: %.2f, type: %s%n", food, food.getPrice(1), food.getItemType());
		Beverage beverage = new Beverage("23", "Coca cola", 10, 2);
		System.out.format("%s, price: %.2f, type: %s%n", beverage, beverage.getPrice(1), beverage.getItemType());
	}

}
