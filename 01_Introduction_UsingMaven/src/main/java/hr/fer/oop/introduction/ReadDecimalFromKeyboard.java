package hr.fer.oop.introduction;
import java.util.Scanner;
/**
 * @author OOP course
 * @version 1.0
 */
public class ReadDecimalFromKeyboard{
   public static void main(String[] args)  { 
      System.out.println("Program calculates the sum of positive numbers."); 
      System.out.println("Enter numbers, one per line."); 
      System.out.println("After the first negative number or zero is entered, sum will be calculated.");
      
      double sum = 0.0; 
      Scanner sc = new Scanner(System.in);               
      while(true) {
    	 double number = sc.nextDouble();    	          
         if(number<=0) break; 
         sum += number;
      }
      System.out.format("Sum is: %f%n", sum);
      sc.close();
   }
}
