package hr.fer.oop.homework_03.e04;

public class Main {

  public static void main(String[] args) {
    System.out.println("created " + FoodType.getNumberOfCreatedInstances() + " instances");
    FoodType foodType = new FoodType("banana", 4, 93, 3);
    System.out.println("created " + FoodType.getNumberOfCreatedInstances() + " instances");
  }

}
