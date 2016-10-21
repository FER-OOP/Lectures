package hr.fer.oop.generics.example1;

public class IntegerPoint {
	private Integer x;
	private Integer y;
	
	public IntegerPoint(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	@Override
	public String toString() {
		return "IntegerPoint [x=" + x + ", y=" + y + "]";
	}
	
	public static void main(String[] args) {
		IntegerPoint point = new IntegerPoint(10, 20);
		System.out.println(point);
	}
}
