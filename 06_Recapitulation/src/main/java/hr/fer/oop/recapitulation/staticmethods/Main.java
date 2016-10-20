package hr.fer.oop.recapitulation.staticmethods;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class Main {

    public static void main(String[] args) {
        ExtendedClass ec = new ExtendedClass();
        System.out.println(ec.getMessage());
        System.out.println(ec.getStaticMessage());

        BaseClass bc = ec;
        System.out.println(bc.getMessage());
        System.out.println(bc.getStaticMessage());
    }
}
