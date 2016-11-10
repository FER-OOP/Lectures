package hr.fer.oop.topic11.example7;

public interface Container<T> {

    public Container add(T item);

    public boolean contains(T item);
}
