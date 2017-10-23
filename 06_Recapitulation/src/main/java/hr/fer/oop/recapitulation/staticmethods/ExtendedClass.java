package hr.fer.oop.recapitulation.staticmethods;

public class ExtendedClass extends BaseClass {
    private final String message3 = "M3";
    private static final String message4 = "M4";
    
    @Override
    public String getMessage() {
        return message3  + " " + getStaticMessage();
    }
    public static String getStaticMessage() {
        return message4;
    }    
}
