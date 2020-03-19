package hr.fer.oop.classes.glass;

public class Main {

	public static void main(String[] args) {
		GlassOfWater glass = new GlassOfWater(250);
		glass.addWater(200);
		System.out.println();
		glass.addIceCubes(3);
		System.out.println();
		glass.addIceCubes(4);
	}

}
