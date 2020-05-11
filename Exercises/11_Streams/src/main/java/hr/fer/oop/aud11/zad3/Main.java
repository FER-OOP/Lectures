package hr.fer.oop.aud11.zad3;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<PopulationSample> data = Loader.load();

        //minimum age
        System.out.println(data.stream().mapToInt(sample -> sample.getAge()).min().getAsInt());

        //oldest sample
        System.out.println(data.stream().sorted(Comparator.comparing(PopulationSample::getAge).reversed()).findFirst().get());

        //female percentage
        System.out.println(data.stream().filter(sample -> sample.getGender().equals("F")).count() / (double) data.size());
    }
}
