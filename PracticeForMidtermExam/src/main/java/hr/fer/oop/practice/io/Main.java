package hr.fer.oop.practice.io

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class Main {

    public static void main(String[] args) {

        Path dir1, dir2;

        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("Enter the first directory:");
                dir1 = Paths.get(sc.nextLine());
            } while (!dir1.toFile().exists());

            do {
                System.out.println("Enter the second directory:");
                dir2 = Paths.get(sc.nextLine());
            } while (!dir2.toFile().exists());

            System.out.println("Similarity is: " + 
            		getSimilarity(dir1, dir2));
        }
    }

    private static float getSimilarity(Path dir1, Path dir2) {
        //TO DO:
    	//Note: you can write additional private methods
    }   
}
