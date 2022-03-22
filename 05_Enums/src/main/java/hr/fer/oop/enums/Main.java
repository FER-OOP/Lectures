package hr.fer.oop.enums;

public class Main {

  public static void main(String[] args) {
    AndroidVersion ver = AndroidVersion.valueOf("OREO");

    System.out.println(ver);


    for(AndroidVersion v: AndroidVersion.values()) {
      System.out.println(v + " " + v.getVersion());
      AndroidVersion.printOpinion(v);
    }
  }
}
