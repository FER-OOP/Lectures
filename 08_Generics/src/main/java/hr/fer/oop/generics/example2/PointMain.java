package hr.fer.oop.generics.example2;

public class PointMain {
    public static void main(String[] args) {
        Point<Integer> iPoint = new Point<>(10, 20);
        Point<Double> dPoint = new Point<>(10.0, 20.0);

        System.out.println("Before: " + iPoint + ", " + dPoint);
        iPoint = updateRandomlyInt(iPoint);
        dPoint = updateRandomlyDouble(dPoint);
        // Will compiler catch the error if we uncomment
        // next line?
        //iPoint = updateRandomlyDouble(iPoint);
        System.out.println("After: " + iPoint + ", " + dPoint);

        // If we create a point with String, compiler
        // will allow us to call String methods on wrapped
        // object because it knows that the object is is an
        // instance of string.
        Point<String> sPoint = new Point<>("10", "20");
        System.out.println(sPoint.getX().length());

        // The next line is compile time error:
        // Integer i = (Integer)sPoint.getX().getValue();

        // But you can force compiler to forget types:
        Integer i = (Integer)(Object)sPoint.getX();
        // so now the following line will compile, but
        // will never execute since the previous one will
        // throw an exception...
        System.out.println(i.intValue());
    }

    private static Point<Integer> updateRandomlyInt(Point<Integer> point) {
    	int addX = (int) Math.round(Math.random());
    	int addY = (int) Math.round(Math.random());
        return new Point<>(point.getX()+addX, point.getY()+addY);
    }

    private static Point<Double> updateRandomlyDouble(Point<Double> point) {
        return new Point<>(point.getX()+Math.random(), point.getY()+Math.random());
    }
}
