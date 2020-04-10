package hr.fer.oop.generics.example2;

public class Main {	
    public static void main(String[] args) {
        Pair<Integer> iPair = new Pair<>(10, 20);
        Pair<String> sPair = new Pair<>("ABC", "DEF");

        System.out.println("Before: " + iPair + ", " + sPair);
        iPair = updateRandomlyInt(iPair);
        sPair = updateRandomlyString(sPair);
        // Will compiler catch the error if we uncomment
        // next line?
        //sPair = updateRandomlyInt(sPair);
        System.out.println("After: " + iPair + ", " + sPair);

        // If we create a pair with String, compiler
        // will allow us to call String methods on wrapped
        // object because it knows that the object is is an
        // instance of string.        
        System.out.println(sPair.getFirst().length());

        // The next line is compile time error:
        // Integer i = (Integer)sPair.getX().getValue();

        // But you can force compiler to forget types:
        Integer i = (Integer)(Object)sPair.getFirst();
        // so now the following line will compile, but
        // will never execute since the previous one will
        // throw an exception...
        System.out.println(i.intValue());
    }

    private static Pair<Integer> updateRandomlyInt(Pair<Integer> pair) {
    	int addX = (int) Math.round(Math.random());
    	int addY = (int) Math.round(Math.random());
        return new Pair<>(pair.getFirst()+addX, pair.getSecond()+addY);
    }

    private static Pair<String> updateRandomlyString(Pair<String> pair) {  
    	if (Math.random() > 0.5)
    		return new Pair<>(pair.getFirst()+ "A", pair.getSecond()+ "B");
    	else 
    		return pair;
    }
}
