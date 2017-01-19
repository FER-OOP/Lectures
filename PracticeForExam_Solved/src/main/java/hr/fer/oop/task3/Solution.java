package hr.fer.oop.task3;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.TreeMap;

public class Solution {

    private static class Averages extends SimpleFileVisitor<Path> {
        // Map<CourseId, Map<Exam, Average>>:

        private Map<Integer, Map<String, Double>> data = new TreeMap<>();

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            String name = file.getFileName().toString().toLowerCase();
            if (!name.endsWith(".txt")) {
                return FileVisitResult.CONTINUE;
            }
            List<String> retci = Files.readAllLines(file);
            OptionalDouble optResult = retci.stream()
                    .filter(s -> !s.isEmpty() && !s.startsWith("#"))
                    .mapToInt(Integer::parseInt)
                    .average();
            if (optResult.isPresent()) {
                Integer course = Integer.valueOf(file.getParent().getFileName().toString());
                if (!data.containsKey(course)) {
                    data.put(course, new HashMap<>());
                }
                String exam = withoutExtension(file.getFileName().toString());
                data.get(course).put(exam, optResult.getAsDouble());
            }
            return FileVisitResult.CONTINUE;
        }

        private String withoutExtension(String name) {
            return name.substring(0, name.lastIndexOf('.'));
        }

        public void writeReport() {
            data.forEach((course, map) -> {
                System.out.println("Kolegij: " + course);
                map.forEach((rok, avg) -> {
                    System.out.printf("  %s: %.3f\n", rok, avg);
                });
                double totalAvg = map.values().stream().mapToDouble(d -> d).average().getAsDouble();
                boolean troubled = map.values().stream().mapToDouble(d -> d / totalAvg).anyMatch(d -> d < 0.9 || d > 1.1);
                if (troubled) {
                    System.out.println("  UPOZORENJE");
                }
            });
        }
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.out.println("Očekivao sam 1 argument: putanju do vršnog direktorija.");
            return;
        }

        Path root = Paths.get(args[0]);

        Averages p = new Averages();
        try {
            Files.walkFileTree(root, p);
        } catch (IOException ex) {
            System.out.println("Pogreška: " + ex.getClass().getName() + " - " + ex.getMessage());
            return;
        }

        p.writeReport();

    }

}
