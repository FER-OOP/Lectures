package hr.fer.oop.task2;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import hr.fer.oop.task2.items.*;

public class Main {

    public static void main(String[] args) {
        List<Item> items = ItemsDB.load();
        Set<MilkType> types = items.stream()
                .filter(i -> i instanceof Milk)
                .map(i -> (Milk) i)
                .filter(new NegatePredicate<>(Main::isSmallBottle))
                .map(m -> m.getType())
                .collect(Collectors.toSet());
        for (MilkType type : types) {
            System.out.println(type);
        }
    }

    private static boolean isSmallBottle(Beverage b) {
        return b.getVolume() <= 0.5;
    }

}
