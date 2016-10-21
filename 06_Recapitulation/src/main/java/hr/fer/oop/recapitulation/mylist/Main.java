package hr.fer.oop.recapitulation.mylist;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
   
        list.addLast("first");
        list.addLast("second");
        list.addLast("third");
        
        System.out.println(list.size());
        list.removeAt(1);
        System.out.println(list.elementAt(1));
        System.out.println(list.size());
        
        list.addLast("fourth");        
        System.out.println(list.elementAt(2));        
    }
}
