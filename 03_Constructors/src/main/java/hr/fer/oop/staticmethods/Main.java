package hr.fer.oop.staticmethods;
public class Main {
	
	public static void main(String[] args) {
		Point a = new Point(0,0);
		Point b = new Point(6,0);
		Point c = new Point(3,5);
		Point center = Point.centerOf(a, b, c);
		System.out.println(center.toString()); //toString ovdje nije bio nu�an, ali je dodan da se naglasi razlika izme�u stati�ke i ne-stati�ke
		
		Point[] points = new Point[] {a, b, c};
		center = Point.centerOf(points);
		System.out.println(center);
		
		System.out.println(Point.centerOf(a, b));
		System.out.println(Point.centerOf(a, b, c));
		System.out.println(Point.centerOf(a, b, c, new Point(4,8)));
		
		Vector v = new Vector(new Point(3,4));
		System.out.println(v);
		Vector.alpha1 = new Vector(1,1);
		Vector.alpha2 = new Vector(-1,2);
		System.out.println(v);
	}
}
