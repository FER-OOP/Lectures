package hr.fer.oop.simple;

public class ArgumentDisplay {
   public static void main(String[] args) { 
      int argCount = args.length;
      for(int i = 0; i < argCount; i++) { 
         System.out.printf("Argument[%d] = %s%n", i, args[i]);
      }
    }
}
