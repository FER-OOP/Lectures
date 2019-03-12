package hr.fer.oop.staticmethods;
public class Main {
	
	public static void main(String[] args) {
		Point a = new Point(0,0);
		Point b = new Point(6,0);
		Point c = new Point(3,5);
		Point center = Point.centerOf(a, b, c);
		center.print();
		
		Point[] points = new Point[] {a, b, c};
		center = Point.centerOf(points);
		center.print();
		
		Point.centerOf(a, b).print();
		Point.centerOf(a, b, c).print();
		Point.centerOf(a, b, c, new Point(4,8)).print();;
		
		Vector v = new Vector(new Point(3,4));
		v.print();
		Vector.alpha1 = new Vector(1,1);
		Vector.alpha2 = new Vector(-1,2);
		v.print();
	}
}
