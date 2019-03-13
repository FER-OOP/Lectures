package hr.fer.oop.constructors.operations;

import hr.fer.oop.constructors.Point;

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
public class PointOperations {

	public static void main(String[] args) {
		Point a = new Point(1, 1);
		Point b = new Point(-2, 3);
		Point c = new Point(-3, -3);
		Point d = new Point(4, -2);
		
		Point mostDistantPoint = pointMostDistantFromOrigin(a, b, c, d);
		System.out.println(mostDistantPoint);
	}

	public static Point pointMostDistantFromOrigin(Point... points) {
		Point origin = new Point(0, 0);
		Point mostDistantPoint = null;
		double maxDistance = 0;
		double distance;
		for (Point point: points) {
			distance = point.distanceToPoint(origin);
			if (distance > maxDistance) {
				mostDistantPoint = point;
				maxDistance = distance;
			}
		}
		return mostDistantPoint;
	}
}
