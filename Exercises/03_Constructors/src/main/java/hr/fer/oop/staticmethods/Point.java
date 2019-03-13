package hr.fer.oop.staticmethods;

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
	
	public static Point centerOf(Point a, Point b, Point c){		
		double x = (a.x + b.x + c.x) / 3.;
		double y = (a.y + b.y + c.y) / 3.;
		Point p = new Point(x, y);
		return p;		
	}
	
	public static Point centerOf(Point a, Point b, Point... points){		
		double x = a.x + b.x;
		double y = a.y + b.y;		
		for(Point p : points){
			x += p.x;
			y += p.y;
		}		
		int len = points.length + 2; //points.length and also a and b
		Point p = new Point(x / len, y / len);
		return p;		
	}
	
	public static Point centerOf(Point[] points){		
		double x = 0, y = 0;
		int len = points.length;
//		for(int i=0; i<len; i++){
//			x += points[i].x;
//			y += points[i].y;
//		}
		for(Point p : points){
			x += p.x;
			y += p.y;
		}
		
		Point p = new Point(x / len, y / len);
		return p;		
	}
	
	@Override		
	public String toString(){
		return "(" + x + ", " + y + ")";		
	}
	
	@Override
	public boolean equals(Object obj) {	    
	    Point other = (Point) obj;
	    return x == other.x && y == other.y; 
	}
}
