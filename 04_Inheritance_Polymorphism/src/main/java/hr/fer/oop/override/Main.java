package hr.fer.oop.override;
public class Main {
	
	public static void main(String[] args) {
		Point p1 = new Point(2, 5);
		Point p2 = new Point(2, 5);		
		System.out.println("p1.equals(p2) : " + p1.equals(p2));
		p1.setX(1); 
		p1.setY(2);
		System.out.println("p1.equals(p2) : " + p1.equals(p2));
		System.out.println(p1);
		System.out.println(p2);		
	}
}
