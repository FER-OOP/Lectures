package hr.fer.oop.garden.plants;

public class Tomato extends Plant {

  public Tomato(int requiredWaterAmount) {
    super.requiredWaterAmount = requiredWaterAmount;
  }

  @Override
  public void water(int waterAmount) {
    if (super.watered) {
      System.out.println("The tomato has already been watered enough");
    } else {
      System.out.println("Using the sprinkler for watering the tomato...");
    }

    super.collectedWater += waterAmount;

    if (super.collectedWater >= requiredWaterAmount) {
      System.out.println("The tomato has been watered properly");
    }
  }
}
