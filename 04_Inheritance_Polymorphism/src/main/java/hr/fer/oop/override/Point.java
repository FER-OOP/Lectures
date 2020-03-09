package hr.fer.oop.override;

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

}
