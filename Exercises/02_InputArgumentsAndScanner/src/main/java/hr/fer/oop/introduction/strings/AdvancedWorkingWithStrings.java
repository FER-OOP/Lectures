package hr.fer.oop.introduction.strings;

/**
 * Task 1:
 * * Your task is to concatenate all received parameters into one string separated with semicolon character (CSV format), for example for
 * received parameters "one two three" your string needs to look like this: "one;two;three;". This string will be used in the following tasks.
 *
 * a) splitting string:
 *  You need to create a method for splitting string based on the semicolon character - ";". Received split parts need to be printed on standard output
 *
 * b) indexOfCharacter
 *  You need to find the first and the last index of semicolon character - ";", and print them on standard output
 *
 * c) substring
 *  You need to get substring of original string by removing part before the first semicolon character - ";", and removing part behind the last semicolon
 *  character - ";". Received substring needs to be printed on standard output.
 *
 * Zadatak 1:
 * Vaš zadatak je spojiti (konkatenirati) sve primljene parametre u jedan niz znakova (String) odvojene točka-zarezom (CSV format), npr. za primljeni niz parametara "jedan dva tri", znakovni niz bi trebao izgledati "jedan;dva;tri;". Ovaj znakovni niz koristit �e se u nastavku za pod zadatke
 *
 * a) separacija znakovnog niza
 * potrebno je napisati metodu za separaciju znakovnog niza po znaku točka-zarez - ";". Dobivene dijelove isprintati na standardni izlaz
 *
 * b) indeksOdređenogZnaka
 * potrebno je napisati metodu za pronalazak prvog i zadnjeg indeksa određenog znaka, u ovom slučaju točka-zarez - ";" te ih potom ispisati na početni ekran
 *
 * c) podniz
 * potrebno je napisati metodu za pronalazak određenog podniza. Podniz se u ovom slučaju sastoji od dijela iza prve točka-zareza pa sve do zadnjeg točke-zareza. Dobiveni podniz je potrebno ispisati na standardni izlaz
 *
 *
 *
 * @author OOP
 *
 */
public class AdvancedWorkingWithStrings {

  static String text = "";

  public static void main(String[] args) {

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < args.length; i++) {
      sb.append(args[i]).append(";");
    }

    text = sb.toString();

    if (!text.isEmpty()) {
      System.out.println(text);
      System.out.println();
      split();
      System.out.println();
      indexOfLetter();
      System.out.println();
      substring();
    }
  }

  // **************
  // * part a) *
  // **************
  public static void split() {

    String[] splits = text.split(";");
    for (int i = 0; i < splits.length; i++) {
      System.out.println(splits[i]);
    }
  }

  // **************
  // * part b) *
  // **************
  public static void indexOfLetter() {
    int firstIndexOfSemicolon = text.indexOf(";");
    int lastIndexOfSemicolon = text.lastIndexOf(";");

    System.out
      .println("First semicolon index is " + firstIndexOfSemicolon + ", and the last one is " + lastIndexOfSemicolon);
  }

  // **************
  // * part c) *
  // **************
  public static void substring() {
    int firstIndexOfSemicolon = text.indexOf(";");
    int lastIndexOfSemicolon = text.lastIndexOf(";");

    String substring = text.substring(firstIndexOfSemicolon + 1, lastIndexOfSemicolon);
    System.out.println(substring);
  }
}
