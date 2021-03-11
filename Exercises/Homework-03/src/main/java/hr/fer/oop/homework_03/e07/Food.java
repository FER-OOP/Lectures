package hr.fer.oop.homework_03.e07;

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

  public double getProtein() {
    return type.getProtein() * weight / 100.0;
  }

  public double getCarbs() {
    return type.getCarbs() * weight / 100.0;
  }

  public double getFat() {
    return type.getFat() * weight / 100.0;
  }

  public String toStringInGrams() {
    return String.format("%s: p - %.1fg, c - %.1fg, f - %.1fg, w - %dg", type.getName(), getProtein(), getCarbs(), getFat(), weight);
  }
}
