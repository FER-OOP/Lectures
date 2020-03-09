package hr.fer.oop.objectmethods;

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
		
	public void print(){
		System.out.printf("(%.2f, %.2f)%n", x, y);		
	}
			
	public boolean isEqualTo(Point other) {	    
	    //return x == other.x && y == other.y;
	    return Math.abs(x-other.x)<1E-8
	    		&&
	    	   Math.abs(y-other.y)<1E-8;
	}

}
