package hr.fer.oop.simple;
public class FindMin {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments received");
        }
        else {
            int min = Integer.parseInt(args[0]);
            for(int i=1; i<args.length; i++) {
                int temp = Integer.parseInt(args[i]);
                if (temp < min) {
                    min = temp;
                }
            }
            System.out.printf("The smallest number is %d%n", min);        
        }
    }
}

