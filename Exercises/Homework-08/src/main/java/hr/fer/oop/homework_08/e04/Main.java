package hr.fer.oop.homework_08.e04;

public class Main {

	public static void main(String[] args) {
		
		int primitive = 5;
		System.out.println("Primitive:"+primitive);
		
		// a)
		Integer objectWrapper = Integer.valueOf(primitive);
		System.out.println("Object:"+objectWrapper.toString());
		
		// b) 
		int primitiveFromObject = objectWrapper.intValue();
		System.out.println("Primitive from object:"+primitiveFromObject);
		
		// c)
		Integer automaticObjectWrapper = primitive;
		System.out.println("Automatic object:"+automaticObjectWrapper.toString());
		int automaticPrimitive = automaticObjectWrapper;
		System.out.println("Automatic primitive:"+automaticPrimitive);
		
		// d)
		Integer ohNo = null;
		System.out.println(ohNo);
		// problem:
		int ohNoPrimitive = ohNo;
		System.out.println(ohNoPrimitive);

	}

}
