package hr.fer.oop.recapitulation.staticmethods;

public class BaseClass {
    private final String message1 = "M1";
    private static final String message2 = "M2";

    public String getMessage() {
        return message1  + " " + getStaticMessage();
    }
    public static String getStaticMessage() {
        return message2;
    }
}
