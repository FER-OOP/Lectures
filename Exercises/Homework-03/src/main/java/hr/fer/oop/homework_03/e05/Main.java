package hr.fer.oop.homework_03.e05;

import hr.fer.oop.homework_03.e04.FoodType;

public class Main {

  public static void main(String[] args) {
    FoodType foodType = new FoodType("banana", 4, 93, 3);
    Food food = new Food(foodType, 110);

    System.out.println(food.toString());
  }

}
