package hr.fer.oop.introduction.random;

/**
 * Task 2: You need to create an integer array. Size of array is given as
 * arguments of the main program. You can assume user will provide valid
 * arguments that don't need to be checked. Array needs to be filled with random
 * numbers in range 0-100. At the end of the program you need to print the array
 * on standard output backwards (from last element up to first one). Also, you
 * need to find the largest and the smallest integer in the array and print them
 * and their index in the array (in case of duplicated values return the index
 * of first appearing one).
 *
 * Zadatak 2: Potrebno je napraviti program koji stvara polje cijelih brojeva
 * (int). Veličina polja određena je argumentom iz glavnog programa. Možete
 * pretpostaviti da će korisnik unijeti ispravan argument te nije potrebno
 * izvoditi provjere nad argumentom. Potom polje je potrebno popuniti nasumičnim
 * brojevima iz raspona 0-100. Nakon punjenja polja, program treba silazno
 * ispisati sadržaj polja (od zadnjeg elementa prema prvom). Također potrebno je
 * pronaći najveći i najmanji element u polju, te ih ispisati kao i njihove
 * indekse (u slučaju da se pojave dupliciranje vrijednosti ispisati indeks onog
 * koji se pojavljuje prvi).
 *
 * @author OOP
 *
 */

public class RandomAndArrays {

  public static void main(String[] args) {

    if (args.length != 1) {
      System.err.println("A program needs argument for array length!");
      System.exit(1);
    }

    // parsing value of array size from input parameters
    int arraySize = Integer.parseInt(args[0]);
    // creating array of certain size
    int[] randomArray = new int[arraySize]; // at this point array is filled with null's

    // filling array with values from 0-100. Since Math.random returns double values
    // from 0-1,
    // we need to multiply those with 100 and cast to int
    for (int i = 0; i < randomArray.length; i++) {
      randomArray[i] = (int) (Math.random() * 100);
    }

    // printing array backwards on standard output
    for (int i = randomArray.length - 1; i >= 0; i--) {
      System.out.println("Array[" + i + "] = " + randomArray[i]);
    }

    int largestInt = randomArray[0];
    int smallestInt = randomArray[0];
    // ALTERNATIVE
    // int largestInt = Integer.MIN_VALUE; //we could also put 0 here
    // int smallestInt = Integer.MAX_VALUE; //we could also put 100 here

    int indexOfLargest = 0;
    int indexOfSmallest = 0;

    // find largest and smallest integer in array
    for (int i = 0; i < randomArray.length; i++) {

      if (randomArray[i] > largestInt) {
        largestInt = randomArray[i];
        indexOfLargest = i;
      }

      if (randomArray[i] < smallestInt) {
        smallestInt = randomArray[i];
        indexOfSmallest = i;
      }
    }

    System.out.println();
    System.out.println("Smallest integer in array is: " + smallestInt + " at position [" + indexOfSmallest + "]");
    System.out.println("Largest integer in array is: " + largestInt + " at position [" + indexOfLargest + "]");
  }
}
