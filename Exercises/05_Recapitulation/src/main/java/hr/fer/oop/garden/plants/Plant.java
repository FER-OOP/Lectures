package hr.fer.oop.garden.plants;

public abstract class Plant implements Growable {
  public static final String GARDENER = "Matteo";

  protected boolean watered;
  private boolean fertilized; // Could have been protected
  private boolean plucked;

  protected int requiredWaterAmount;
  protected int collectedWater;

  public boolean pluck() {
    if (watered && fertilized) {
      plucked = true;
      System.out.println("Plucked the plant.");
    } else {
      System.out.println("The plant is not ready to be plucked!");
    }

    return plucked;
  }

  @Override
  public void fertilize() {
    this.fertilized = true;
    System.out.println("The plant has been fertilized!");
  }

  // No setter or getter for watered since variable is protected and can be
  // accessed from subclass

  // Need to use getters for private variables, they are not available from
  // subclasses
  public boolean isFertilized() {
    return fertilized;
  }

  // No setter - can't un-pluck a plant
  public boolean isPlucked() {
    return plucked;
  }
}
