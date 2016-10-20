package hr.fer.oop.recapitulation.mylist;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class MyListElement {
    private Object content;
    private MyListElement next;

    public MyListElement(Object content) {
        this.content = content;
    }        

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public MyListElement getNext() {
        return next;
    }

    public void setNext(MyListElement next) {
        this.next = next;
    }        
}
