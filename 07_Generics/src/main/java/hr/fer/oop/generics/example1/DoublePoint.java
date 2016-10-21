package hr.fer.oop.generics.example1;

public class DoublePoint {
	private Double x;
	private Double y;
	
	public DoublePoint(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	@Override
	public String toString() {
		return "DoublePoint [x=" + x + ", y=" + y + "]";
	}
	
	public static void main(String[] args) {
		DoublePoint point = new DoublePoint(10.0, 20.0);
		System.out.println(point);
	}
}
