package hr.fer.oop.recapitulation.mylist;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class MyList {

    private MyListElement head;

    public int addLast(Object o) {
        if (head == null) {
            head = new MyListElement(o);
            return 0;
        }

        MyListElement current = head;
        int index = 0;
        while (current.getNext() != null) {
            current = current.getNext();
            index++;
        }

        current.setNext(new MyListElement(o));
        return index + 1;

    }

    public void removeAt(int index) {

        if (index == 0) {
            head = head.getNext();
            return;
        }

        MyListElement current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) {
                return;
            }
            current = current.getNext();
        }

        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
        }
    }

    public Object elementAt(int index) {
        MyListElement current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                return null;
            }
            current = current.getNext();
        }

        if (current != null) {
            return current.getContent();
        }
        return null;
    }

    public int size() {
        MyListElement current = head;
        int index = 0;
        for (; current != null; index++) {
            current = current.getNext();
        }
        return index;
    }
}
