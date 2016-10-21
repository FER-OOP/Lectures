package hr.fer.oop.generics.example2;

public class RawPointMain {

	public static void main(String[] args) {
		Point iPoint = new Point(5,5);
		Point dPoint = new Point(15.0, 10.0);
		System.out.println("Before: " + iPoint + ", " + dPoint);
		iPoint = updateRandomlyInt(iPoint);
		dPoint = updateRandomlyDouble(dPoint);
		// Will compiler catch the error if we uncomment
		// next line?
		updateRandomlyDouble(iPoint);
		System.out.println("After: " + iPoint + ", " + dPoint);
	}

	private static Point updateRandomlyInt(Point point) {
		Integer x = (Integer)point.getX();
		Integer y = (Integer)point.getY();
		return new Point(Integer.valueOf(x.intValue()+1),
				Integer.valueOf(y.intValue()+1));
	}

	private static Point updateRandomlyDouble(Point point) {
		Double x = (Double)point.getX();
		Double y = (Double)point.getY();
		return new Point(Double.valueOf(x.doubleValue() + Math.random()),
				Double.valueOf(y.doubleValue()+Math.random()));
	}
}
