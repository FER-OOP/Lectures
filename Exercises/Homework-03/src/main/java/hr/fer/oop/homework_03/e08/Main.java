package hr.fer.oop.homework_03.e08;

import hr.fer.oop.homework_03.e04.FoodType;
import hr.fer.oop.homework_03.e07.Food;

public class Main {

  public static void main(String[] args) {
    FoodType banana = new FoodType("banana", 4, 93, 3);
    Food oneBanana = new Food(banana, 110);

    FoodType grapes = new FoodType("grapes", 4, 94, 2);
    Food grapeCluster = new Food(grapes, 151);

    Meal fruitSalad = new Meal(oneBanana, grapeCluster);
    fruitSalad.printIngredients();

    System.out.println("*** printing ingredients");
    for (int i = -1; i <= fruitSalad.getNumberOfIngredients(); i++) {
      System.out.println("ingredient[" + i + "] = " + fruitSalad.getIngredient(i));
    }
  }

}
