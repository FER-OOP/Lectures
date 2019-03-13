package hr.fer.oop.constructors.glass;

/**
 * Zadatak 1:
 * Proširite klasu Point iz primjera s predavanja s metodom distanceToPoint(Point p) koja računa
 * geometrijsku udaljenost do dane točke. Stvorite klasu PointOperations koja služi za izvršavanje
 * operacija nad točkama. Klasa PointOperations mora imati metodu getPointMostDistantFromOrigin koja
 * vraća točku koja je najudaljenija od ishodišta koordinatnog sustava. Klasa PointOperations također
 * mora imati main metodu u kojoj je potrebno inicijalizirati proizvoljan broj točaka te nad njima
 * pozvati metodu getPointMostDistantFromOrigin.
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
				overflowVolume = currentIceCubeVolume - glassSize;
				
				//rounding up the number of cubes to ceiling
				int overflownIceCubes = (overflowVolume + 49) / 50;
				currentIceCubeCount -= overflownIceCubes;

				System.out.println("All water has overflown. "
						+ overflownIceCubes + " ice cubes have overflown.");
			}
		}
		
	}
	
	public static void main(String[] args) {
		GlassOfWater glass = new GlassOfWater(250);
		glass.addWater(200);
		glass.addIceCubes(3);
		glass.addIceCubes(4);
	}

}
