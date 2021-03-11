package hr.fer.oop.homework_03.e04;

public class FoodType {
  private static int counter = 0;
  private String name;
  private int protein;
  private int carbs;
  private int fat;

  public FoodType(String name, int protein, int carbs, int fat) {
    FoodType.counter++;
    this.name = name;
    this.protein = protein;
    this.carbs = carbs;
    this.fat = fat;
  }

  public String getName() {
    return name;
  }

  public int getProtein() {
    return protein;
  }

  public int getCarbs() {
    return carbs;
  }

  public int getFat() {
    return fat;
  }

  @Override
  public String toString() {
    return String.format("%s: p - %d%%, c - %d%%, f - %d%%", name, protein, carbs, fat);
  }

  public static int getNumberOfCreatedInstances() {
    return counter;
  }
}
