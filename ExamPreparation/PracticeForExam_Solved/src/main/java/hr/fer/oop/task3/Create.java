package hr.fer.oop.task3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Create {

    public static void main(String[] args) throws IOException {
        String[] courses = {
            "12345",
            "23451",
            "34512",
            "45123",
            "51234"
        };
        String[] exams = {
            "kontinuirano",
            "prvi-rok",
            "drugi-rok",
            "dekanski-rok"
        };
        double[][][] parameters = {
            {{100, 3, 1}, {100, 2.8, 1}, {50, 3.1, 1}, {50, 3.1, 1}},
            {{100, 4, 1}, {100, 4.1, 1}, {50, 4.1, 1}, {50, 3.8, 1}},
            {{150, 3.5, 1}, {150, 3.6, 1}, {150, 3.4, 1}, {150, 3.4, 1}},
            {{110, 4.7, 1}, {110, 3.8, 1}, {80, 4.6, 1}, {50, 4.7, 1}},
            {{120, 2.4, 1}, {100, 2.6, 1}, {80, 2.5, 2}, {60, 2.4, 1}}
        };

        Path root = Paths.get("ispiti");
        if (!Files.exists(root)) {
            Files.createDirectories(root);
        }

        int i = -1;
        for (String c : courses) {
            i++;
            int j = -1;
            for (String rok : exams) {
                j++;
                generate(root, c, rok, (int) parameters[i][j][0], parameters[i][j][1], parameters[i][j][2]);
            }
        }
    }

    private static Random rand = new Random();

    private static void generate(Path root, String course, String exam, int n, double avg, double sigma) throws IOException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (rand.nextDouble() < 0.05) {
                list.add("# Komentar...");
            }
            if (rand.nextDouble() < 0.02) {
                list.add("");
            }
            list.add("" + grade(rand.nextGaussian() * sigma + avg));
        }

        Path dir = root.resolve(course);
        Files.createDirectories(dir);

        Files.write(dir.resolve(exam + ".txt"), list, StandardCharsets.UTF_8);
    }

    private static int grade(double d) {
        int o = (int) Math.round(d);
        if (o < 2) {
            o = 2;
        }
        if (o > 5) {
            o = 5;
        }
        return o;
    }
}
