package hr.fer.oop.staticmethods;

public class Vector {
	public final static Vector e1 = new Vector(new Point(1,0));
	public final static Vector e2 = new Vector(new Point(0,1));
	
	public static Vector alpha1, alpha2;	
	
	private Point p;
	
	static{		
		alpha1 = e1;
		alpha2 = e2;
	}
	
	public Vector(Point p){
		this.p = new Point(p);		
	}
	
	public Vector(double x, double y){
		this.p = new Point(x, y);		
	}
				
	public void print() {
		//(this.p.x, this.p.y) = a1 * (alpha1.x , alpha1.y) + a2 *  (alpha2.x , alpha2.y)
		// => alpha1.x * a1 + alpha2.x * a2 = this.p.x
		// => alpha1.y * a1 + alpha2.y * a2 = this.p.y
		//need to find a1 and a2 => coeff = (a1,a2)		
		Point coeff = EquationsSolver.Solve(alpha1.p.getX(), alpha2.p.getX(), p.getX(),
								   alpha1.p.getY(), alpha2.p.getY(), p.getY() );
		System.out.format("(%.2f, %.2f) = %.2f * (%.2f, %.2f) + %.2f * (%.2f, %.2f)%n", 
				p.getX(), p.getY(),
				coeff.getX(), alpha1.p.getX(), alpha1.p.getY(),
				coeff.getY(), alpha2.p.getX(), alpha2.p.getY()
		);				
	}
	
	

}
