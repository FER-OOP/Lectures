package hr.fer.oop.aud11.zad3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Loader {
    public static List<PopulationSample> load() {
        List<PopulationSample> ret = new LinkedList<>();
        Path filepath = Paths.get("data.csv");

        try {
            Files.lines(filepath).forEach(row -> {
                String[] fragments = row.split(";");
                String fileName = fragments[0];
                String gender = fragments[1];
                Integer age = Integer.parseInt(fragments[2]);

                PopulationSample newSample = new PopulationSample(fileName, gender, age);
                ret.add(newSample);
            });
        } catch (IOException e) {
            e.printStackTrace();
        } 

        return ret;
    }
}
