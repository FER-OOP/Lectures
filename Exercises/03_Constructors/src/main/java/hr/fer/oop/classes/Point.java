package hr.fer.oop.classes;

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

public class Point {	
	private double x, y;
	
	public double getX(){		
		return x;
	}
	public void setX(double x){
		this.x = x;
	}
	
	public double getY(){
		return y;
	}
	public void setY(double y){
		this.y = y;
	}

	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p){
		this(p.x, p.y);
	}
	
	@Override
	public String toString(){
		return String.format("(%.2f, %.2f)",  x,  y);		
	}
		
	@Override
	public boolean equals(Object obj) {	    
	    Point other = (Point) obj;	   
	    return Math.abs(x-other.x)<1E-8
	    		&&
	    	   Math.abs(y-other.y)<1E-8;
	}
	
	public double distanceToPoint(Point p) {
		return Math.sqrt( Math.pow(this.y - p.getY(), 2) + Math.pow(this.x - p.getX(), 2) );
	}

}
