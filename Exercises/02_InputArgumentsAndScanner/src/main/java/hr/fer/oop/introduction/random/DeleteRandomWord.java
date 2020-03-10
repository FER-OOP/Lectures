package hr.fer.oop.introduction.random;

import java.util.Scanner;

/**
 * Task 3: Write a program that will load a line of text from the standard
 * input, remove a randomly selected word and print new text on the standard
 * output. The text should be loaded using the Scanner class and the nextLine
 * method.   Assume that the words in the text are separated by spaces.
 *
 * Zadatak 3: Napisati program koji će sa standardnog ulaza učitati redak
 * teksta, iz njega izbaciti nasumce odabranu riječ i novi tekst ispisati na
 * ekran. Tekst treba učitati koristeći klasu Scanner i metodu nextLine.
 * Pretpostaviti da su riječi u tekstu odvojene razmakom.
 *
 * @author OOP
 *
 */

public class DeleteRandomWord {

  public static void main(String[] args) {

    // Loading text
    Scanner sc = new Scanner(System.in);
    System.out.println("Write one sentence:");
    String tekst = sc.nextLine();

    // Split text to words
    String[] rijeci = tekst.split(" ");

    // Write all words
    System.out.print("Read words: ");
    for (int i = 0; i < rijeci.length; i++) {
      System.out.print(rijeci[i] + ", ");
    }

    // Remove random word
    int izbaci = (int) (Math.random() * rijeci.length);
    System.out.println("\nDeleting word: " + rijeci[izbaci]);

    // New text without deleted word
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < rijeci.length; i++) {
      if (i != izbaci)
        sb.append(rijeci[i] + " ");
    }

    // Write new text
    System.out.print("New text: " + sb.toString());

    sc.close();
  }
}
