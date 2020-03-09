package hr.fer.oop.objectmethods;
public class Main {
	
	public static void main(String[] args) {				
		Point p1 = new Point(2, 5);
		System.out.println(p1.toString());
		Point p2 = new Point(2, 5);
		Point p3 = p2;
		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p3));
		
		System.out.println(p1.getX());
		Object o1 = p1; //upcast
		//System.out.println(o1.getX()); //compile error
		Point po1 = (Point) o1; //downcast
		System.out.println(po1.getX());
		System.out.println(p1 == po1);
	}
}
