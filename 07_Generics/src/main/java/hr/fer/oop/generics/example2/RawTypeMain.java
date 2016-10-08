package hr.fer.oop.generics.example2;

public class RawTypeMain {

	public static void main(String[] args) {
		Wrapper iNumber = new Wrapper(5);
		Wrapper dNumber = new Wrapper(15.0);
		System.out.println("Before: " + iNumber+", "+dNumber);
		updateRandomlyInt(iNumber);
		updateRandomlyDouble(dNumber);
		// Will compiler catch the error if we uncomment
		// next line?
		updateRandomlyDouble(iNumber);
		System.out.println("After: " + iNumber+", "+dNumber);
	}

	private static void updateRandomlyInt(Wrapper number) {
		if(Math.random() < 0.5) {
			Integer value = (Integer)number.getValue();
			number.setValue(Integer.valueOf(value.intValue()+1));
		}
	}

	private static void updateRandomlyDouble(Wrapper number) {
		Double value = (Double)number.getValue();
		number.setValue(Double.valueOf(value.doubleValue()+Math.random()));
	}
}
