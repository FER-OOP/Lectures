package hr.fer.oop.homework_03.e05;

import hr.fer.oop.homework_03.e04.FoodType;

public class Food {

  private FoodType type;
  private int weight;

  public Food(FoodType type, int weight) {
    this.type = type;
    this.weight = weight;
  }

  public FoodType getType() {
    return type;
  }

  public int getWeight() {
    return weight;
  }

  @Override
  public String toString() {
    return String.format("%s, w - %dg", type.toString(), weight);
  }

}
