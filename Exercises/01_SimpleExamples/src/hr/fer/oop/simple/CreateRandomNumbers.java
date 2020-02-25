package hr.fer.oop.simple;
public class CreateRandomNumbers {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Program requires lower and upper bound");
        }
        else {    
            int low = Integer.parseInt(args[0]);
            int hi = Integer.parseInt(args[1]);
            if (hi <= low) {
                System.out.println("Invalid bounds");
                System.exit(1);
            }

            int x, y;
            do {
                x = getRandomNumber(low, hi);
                y = getRandomNumber(low, hi);
            }
            while (x == y);
            
            System.out.printf("Two different random number in range [%d, %d] are %d and %d%n",
                low, hi, x, y);        
        }
    }
    public static int getRandomNumber(int from, int to) {
        return (int) (from + (to - from + 1) * Math.random());
    }
}

