package hr.fer.oop.homework_03.e09;

import hr.fer.oop.homework_03.e07.Food;

public class Meal {

  private Food[] ingredients;

  public Meal(Food...ingredients) {
    this.ingredients = new Food[ingredients.length];
    for (int i = 0; i < ingredients.length; i++) {
      this.ingredients[i] = ingredients[i];
    }
  }

  public Meal(Meal meal, int weight) {
    this.ingredients = new Food[meal.ingredients.length];

    for (int i = 0; i < ingredients.length; i++) {
      this.ingredients[i] = new Food(meal.ingredients[i].getType(), meal.ingredients[i].getWeight() * weight / meal.getWeight());
    }
  }

  private int getWeight() {
    int weight = 0;
    for (int i = 0; i < ingredients.length; i++) {
      weight += ingredients[i].getWeight();
    }
    return weight;
  }

  public void printIngredients() {
    for (int i = 0; i < ingredients.length; i++) {
      System.out.println("Ingredient[" + i + "] = " + ingredients[i].toStringInGrams());
    }
  }

  public int getNumberOfIngredients() {
    return ingredients.length;
  }

  public Food getIngredient(int index) {
    if(index < 0 || index >= ingredients.length)
      return null;

    return ingredients[index];
  }
}
