package hr.fer.oop.homework_04.e02;

import hr.fer.oop.homework_04.e01.Dessert;

public class MainClass {

	public static void main(String[] args) {
		
		Dessert genericDessert = new Dessert("Chocolate Cake #1", 120, 300);
		
		Dessert cake2 = new Cake("Chocolate cake #2", 350.5, 400, false, "birthday");
		Cake cake3 = new Cake("Chocolate cake #3", 350.5, 400, false, "birthday");
		
		IceCream vanillaIce = new IceCream("Vanilla ice cream", 50, 100, "vanilla", "white");
		
		System.out.println(genericDessert.getName() + ", " + genericDessert.getDessertType()); // Dessert ref, Dessert object
		System.out.println(cake2.getName() + ", " + cake2.getDessertType()); // Dessert ref, Cake object
		System.out.println(cake3.getName() + ", " + cake3.getDessertType()); // Cake ref, Cake object
		
		System.out.println(vanillaIce + ", " + vanillaIce.getDessertType());

	}

}
