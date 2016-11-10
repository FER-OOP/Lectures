package hr.fer.oop.topic16.example7;

public interface Container<T> {

    public Container add(T item);

    public boolean contains(T item);
}
