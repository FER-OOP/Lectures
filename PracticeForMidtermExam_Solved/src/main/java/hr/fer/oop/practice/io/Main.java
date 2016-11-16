package hr.fer.oop.practice.io;

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

            System.out.println("Similarity is: " + getSimilarity(dir1, dir2));
        }
    }

    private static float getSimilarity(Path dir1, Path dir2) {
        MyFileVisitor visitor1 = new MyFileVisitor(dir1.toString());
        MyFileVisitor visitor2 = new MyFileVisitor(dir2.toString());
        try {
            Files.walkFileTree(dir1, visitor1);
            Files.walkFileTree(dir2, visitor2);
            
            return compareMaps(visitor1.map, visitor2.map);
        } catch (IOException ex) {
            throw new IllegalArgumentException("Cannot compare these directories");
        }
    }

    private static <K, V> float compareMaps(Map<K, V> map1, Map<K, V> map2) {
        int count = 0;

        for (Map.Entry<K, V> entry : map1.entrySet()) {
            V value = map2.get(entry.getKey());
            if (value != null && value.equals(entry.getValue())) {
                count++;
            }
        }

        //number of common elements divided by the number of elements in the union
        return count / (float) (map1.size() + map2.size() - count);
    }
}