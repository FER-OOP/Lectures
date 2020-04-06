package hr.fer.oop.garden.plants;

public class Violet extends Plant {

  public Violet(int requiredWaterAmount) {
    super.requiredWaterAmount = requiredWaterAmount;
  }

  @Override
  public void water(int waterAmount) {
    if (super.watered) {
      System.out.println("The violet has already been watered enough");
    } else {
      System.out.println("Using the watering can for watering the violet...");
    }

    super.collectedWater += waterAmount;

    if (super.collectedWater >= requiredWaterAmount) {
      super.watered = true;
      System.out.println("The violet has been watered properly");
    }
  }

}
