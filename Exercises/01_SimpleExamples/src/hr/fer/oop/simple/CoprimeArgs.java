package hr.fer.oop.simple;
import hr.fer.oop.util.GCD;

public class CoprimeArgs {
    public static void main(String[] args) {
        for(int i=0; i<args.length - 1; i++) {
            for(int j=i+1; j<args.length; j++) {
                int a = Integer.parseInt(args[i]);
                int b = Integer.parseInt(args[j]);
                int gcd = GCD.gcd(a, b);                
                System.out.printf("gcd(%d, %d) = %d %s %n", 
                                    a, b, gcd,
                                    Math.abs(gcd) == 1 ? "coprime!" : ""
                                  );
            }
        }
    }
}

