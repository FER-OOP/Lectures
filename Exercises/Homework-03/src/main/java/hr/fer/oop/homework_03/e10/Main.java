package hr.fer.oop.homework_03.e10;

import hr.fer.oop.homework_03.e04.FoodType;
import hr.fer.oop.homework_03.e07.Food;

public class Main {

  public static void main(String[] args) {
    FoodType milk = new FoodType("milk", 3, 5, 2);
    FoodType polenta = new FoodType("polenta", 2, 16, 0);
    FoodType cornFlakes = new FoodType("corn flakes", 7, 83, 1);

    Meal polentaMeal = new Meal(new Food(milk, 500), new Food(polenta, 200));
    Meal cornFlakesMeal = new Meal(new Food(milk, 200), new Food(cornFlakes, 100));

    System.out.println("similarity is " + polentaMeal.compare(cornFlakesMeal));
  }
}
