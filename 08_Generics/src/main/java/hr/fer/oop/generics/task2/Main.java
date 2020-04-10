package hr.fer.oop.generics.task2;

import hr.fer.oop.generics.task1.MyList;

public class Main {

	public static void main(String[] args) {
		MyList<Point<Integer>> list1 = new MyList<>();
		list1.addLast(new Point<>(4, 5));
		list1.addLast(new Point<>(5, 3));
		list1.addLast(new Point<>(0, 4));
		System.out.println("Center of list1: " + center(list1));
		
		MyList<Point<Double>> list2 = new MyList<>();
		list2.addLast(new Point<>(4.5, 5.7));
		list2.addLast(new Point<>(5.1, 3.4));
		list2.addLast(new Point<>(0.0, 4.1));
		System.out.println("Center of list2: " + center(list2));
	}
	
	public static <T extends Number> Point<Double> center(MyList<Point<T>> list){
		double x = 0;
		double y = 0;
		int size = list.size();
		for(int i=0; i < size ; i++){
			Point<T> p = list.elementAt(i);
			x += p.getX().doubleValue();
			y += p.getY().doubleValue();
		}
		Point<Double> point = new Point<>(x / size, y / size);
		return point;
	}	
}
