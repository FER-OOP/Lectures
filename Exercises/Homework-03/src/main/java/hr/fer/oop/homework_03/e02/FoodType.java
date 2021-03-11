package hr.fer.oop.homework_03.e02;

public class FoodType {
  private String name;
  private int protein;
  private int carbs;
  private int fat;

  public FoodType(String name, int protein, int carbs, int fat) {
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
}
