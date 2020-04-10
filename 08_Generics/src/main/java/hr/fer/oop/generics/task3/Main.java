package hr.fer.oop.generics.task3;

import hr.fer.oop.generics.task1.MyList;
import hr.fer.oop.generics.task2.Point;

public class Main {

	public static void main(String[] args) {
		MyList<Point<? extends Number>> list = new MyList<>();
		list.addLast(new Point<>(4, 5));
		list.addLast(new Point<>(5, 3));
		list.addLast(new Point<>(0, 4));		
		list.addLast(new Point<>(4.5, 5.7));
		list.addLast(new Point<>(5.1, 3.4));
		list.addLast(new Point<>(0.0, 4.1));
		System.out.println("Center of list: " + center(list));		
	}
	
	//public static <T extends Point<? extends Number>> Point<Double> center(MyList<T> list){
	public static Point<Double> center(MyList<Point<? extends Number>> list){
		double x = 0;
		double y = 0;
		int size = list.size();
		for(int i=0; i < size ; i++){
			Point<? extends Number> p = list.elementAt(i);
			x += p.getX().doubleValue();
			y += p.getY().doubleValue();
		}
		Point<Double> point = new Point<>(x / size, y / size);
		return point;
	}	
}
