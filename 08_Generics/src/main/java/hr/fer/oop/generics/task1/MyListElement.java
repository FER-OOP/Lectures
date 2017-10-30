package hr.fer.oop.generics.task1;

public class MyListElement<T> {
    private T content;
    private MyListElement<T> next;

    public MyListElement(T content) {
        this.content = content;
    }        

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public MyListElement<T> getNext() {
        return next;
    }

    public void setNext(MyListElement<T> next) {
        this.next = next;
    }        
}
