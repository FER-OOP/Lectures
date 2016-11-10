package hr.fer.oop.testing.example7;

public interface Container<T> {

    public Container add(T item);

    public boolean contains(T item);
}
