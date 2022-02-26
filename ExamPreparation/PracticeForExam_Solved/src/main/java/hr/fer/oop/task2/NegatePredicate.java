package hr.fer.oop.task2;

import java.util.function.Predicate;

public class NegatePredicate<T> implements Predicate<T> {

    private Predicate<T> predicate;

    public NegatePredicate(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean test(T t) {
        return !predicate.test(t);
    }
}
