package hr.fer.oop.classes.glass;

/**
 * Zadatak 2:
 * Napisati klasu GlassOfWater koja modelira čašu koja se može puniti vodom ili kockama leda.
 * Svaka instanca klase mora enkapsulirati svoje stanje (kolika je zapremina čaše, koliko vode
 * i koliko kocki leda sadrži) te imati dvije javne metode – addWater(int waterAmount) i
 * addIceCubes(int numberOfIceCubes) kojima se čaša puni vodom zadanom u mililitrima ili ledom
 * zadanim brojem kocaka. Svaka kocka leda zauzima 50ml i kocke se mogu savršeno složiti u čašu.
 * Zapremina čaše zadaje se konstruktorom. Ukoliko se u čašu utoči previše vode ili doda
 * previše leda, dolazi do prelijevanja. U slučaju prelijevanja prvo izlazi višak vode, a onda
 * otpada višak kocaka leda. Enkapsulirati prelijevanje u zasebnu metodu koja se poziva iz
 * javnih metoda klase za dodavanje vode ili leda. Pri dodavanju leda ili vode ispisati na
 * ekran stanje čaše prije dodavanja, zatim količinu vode i leda koji se dodaju, a naposljetku
 * nakon provjere prelijevanja ispisati novo stanje. U slučaju prelijevanja ispisati na ekran
 * koliko se vode prelilo i koliko je kocki leda otpalo.
 * 
 * @author OOP
 *
 */

public class GlassOfWater {

	private int glassSize, currentWaterAmount, currentIceCubeCount;

	public GlassOfWater(int glassSize) {
		this.glassSize = glassSize;
	}

	public void addWater(int waterAmount) {
		System.out.println("Glass contains " + currentWaterAmount + " milliliters of water and "
				+ currentIceCubeCount + " ice cubes before addition.");
		System.out.println("Adding " + waterAmount + " milliliters of water.");

		currentWaterAmount += waterAmount;

		checkForOverflow();

		System.out.println("Glass contains " + currentWaterAmount + " milliliters of water and "
				+ currentIceCubeCount + " ice cubes after addition.");
	}

	public void addIceCubes(int numberOfIceCubes) {
		System.out.println("Glass contains " + currentWaterAmount + " milliliters of water and "
				+ currentIceCubeCount + " ice cubes before addition.");
		System.out.println("Adding " + numberOfIceCubes + " ice cubes.");

		currentIceCubeCount += numberOfIceCubes;

		checkForOverflow();

		System.out.println("Glass contains " + currentWaterAmount + " milliliters of water and "
				+ currentIceCubeCount + " ice cubes after addition.");
	}

	private void checkForOverflow() {
		int currentIceCubeVolume = currentIceCubeCount * 50;

		//if true an overflow will happen
		if (currentIceCubeVolume + currentWaterAmount > glassSize) {
			int overflowVolume = (currentIceCubeVolume + currentWaterAmount) - glassSize;

			//if true only water will be overflown
			if (overflowVolume <= currentWaterAmount) {
				currentWaterAmount -= overflowVolume;

				System.out.println(overflowVolume + " milliliters of water has overflown.");
			} else {
				//entire water overflows
				currentWaterAmount = 0;
				int maxCubes = glassSize / 50;
				int overflownIceCubes = Math.max(currentIceCubeCount - maxCubes, 0);
				
				currentIceCubeCount = Math.min(currentIceCubeCount, maxCubes);

				System.out.println("All water has overflown. "
						+ overflownIceCubes + " ice cubes have overflown.");
			}
		}
    }
}
