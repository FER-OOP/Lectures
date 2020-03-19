package hr.fer.oop.classes.operations;

import hr.fer.oop.classes.Point;


public class PointOperations {

	public static Point pointMostDistantFromOrigin(Point... points) {
		Point origin = new Point(0, 0);
		Point mostDistantPoint = null;
		double maxDistance = 0;
		for (Point point: points) {
			double distance = point.distanceToPoint(origin);
			if (distance > maxDistance) {
				mostDistantPoint = point;
				maxDistance = distance;
			}
		}
		return mostDistantPoint;
	}
}
