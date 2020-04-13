package hr.fer.oop.generics.sorted;

class MyListElement<T> {
    private T content;
    private MyListElement<T> next;

    public MyListElement(T content) {
        this(content, null);
    } 
    
    public MyListElement(T content, MyListElement<T> next) {
        this.content = content;
        this.next = next;
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
