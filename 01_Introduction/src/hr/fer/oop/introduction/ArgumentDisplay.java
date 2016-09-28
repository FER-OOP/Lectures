package hr.fer.oop.introduction;
/**
 * @author OOP course
 * @version 1.0
 */
public class ArgumentDisplay {
   /**
    * This method is called once the program is run.   
    * Arguments are described below
    * @param args Command line arguments.
   */
   public static void main(String[] args) { 
      int argumentNum = args.length;
      for(int i = 0; i < argumentNum; i++) { 
         System.out.println("Argument " + (i+1) + ": " + args[i]);
      }
    }
}
