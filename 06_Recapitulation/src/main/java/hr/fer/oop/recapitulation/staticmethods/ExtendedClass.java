package hr.fer.oop.recapitulation.staticmethods;

public class ExtendedClass extends BaseClass {
    private final String message3 = "message3";
    private static final String message4 = "message4";
    
    @Override
    public String getMessage() {
        return message3;
    }
    public static String getStaticMessage() {
        return message4;
    }    
}
